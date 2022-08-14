package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        football.entities.field.Field field;

        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;

            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

        fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement;

        switch (type) {
            case "Powdered":
                currentSupplement = new Powdered();
                break;

            case "Liquid":
                currentSupplement = new Liquid();
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        supplementRepository.add(currentSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field desiredField = fields.stream()
                .filter(element -> element.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        Supplement currentSupplement = supplementRepository.findByType(supplementType);

        if (currentSupplement == null) {
            throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.", supplementType));
        }

        desiredField.addSupplement(currentSupplement);
        supplementRepository.remove(currentSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field desiredField = fields.stream()
                .filter(element -> element.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        Player player;
        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;

            case "Men":
                player = new Men(playerName, nationality, strength);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        if ((player instanceof Men && desiredField instanceof ArtificialTurf) ||
                (player instanceof Women && desiredField instanceof NaturalGrass)) {
            return "The pavement of the terrain is not suitable.";
        }

        desiredField.addPlayer(player);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field desiredField = fields.stream()
                .filter(element -> element.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        desiredField.drag();

        return String.format(ConstantMessages.PLAYER_DRAG, desiredField.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field desiredField = fields.stream()
                .filter(element -> element.getName().equals(fieldName))
                .findFirst()
                .orElse(null);


        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, desiredField.getPlayers().stream().mapToInt(element -> element.getStrength()).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Field currentField : fields) {
            sb.append(currentField.getInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
