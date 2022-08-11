package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;

            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;

            case "Plant":
                decoration = new Plant();
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);

    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration desiredDecoration = decorations.findByType(decorationType);

        if (desiredDecoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        decorations.remove(desiredDecoration);
        aquariums.stream()
                .filter(element -> element.getName().equals(aquariumName))
                .findFirst()
                .orElse(null)
                .getDecorations()
                .add(desiredDecoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);

    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;

            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium currentAquarium = aquariums.stream()
                .filter(element -> element.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        if (currentAquarium.getCapacity() == currentAquarium.getFish().size()) {
            return ConstantMessages.NOT_ENOUGH_CAPACITY;
        }

        if ((currentAquarium instanceof FreshwaterAquarium && fish instanceof SaltwaterFish) ||
                (currentAquarium instanceof SaltwaterAquarium && fish instanceof FreshwaterFish)) {
            return ConstantMessages.WATER_NOT_SUITABLE;
        }

        currentAquarium.addFish(fish);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium currentAquarium = aquariums.stream()
                .filter(element -> element.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        currentAquarium.feed();
        return String.format(ConstantMessages.FISH_FED, currentAquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium currentAquarium = aquariums.stream()
                .filter(element -> element.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        double totalSum;
        double allFishesSum = 0;


        for (Fish currentFish : currentAquarium.getFish()) {
            allFishesSum += currentFish.getPrice();
        }


        totalSum = allFishesSum + currentAquarium.calculateComfort();
        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, totalSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium currentAquarium : aquariums) {
            sb.append(currentAquarium.getInfo());
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
