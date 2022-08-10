package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }


    @Override
    public void breath() {
        oxygen -= 10;

        if (oxygen < 0) {
            oxygen = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, name));
        sb.append("\n");
        sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, oxygen));
        sb.append("\n");

        if (!bag.getItems().isEmpty()) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bag.getItems().toString().replaceAll("[\\[\\]]", "")));
        } else {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
        }

        return sb.toString();
    }
}
