
package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int sum = 0;

        for (Decoration currentDecoration : decorations) {
            sum += currentDecoration.getPrice();
        }

        return sum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (capacity <= fish.getSize()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish currentFish : fish) {
            currentFish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, getClass().getSimpleName()));
        sb.append("\n");

        if (this.fish.size() == 0) {
            sb.append("Fish: none");
        } else {
            sb.append(String.format("Fish: %s", this.fish.toString().replaceAll("[\\[\\],]", "")));
        }

        sb.append("\n");
        sb.append(String.format("Decorations: %d", decorations.size()));
        sb.append("\n");
        sb.append(String.format("Comfort: %d", decorations.stream().mapToInt(element -> element.getComfort()).sum()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
