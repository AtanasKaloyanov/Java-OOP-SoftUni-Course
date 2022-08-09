package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        energy -= 15;

        if (energy < 0) {
            setEnergy(0);
        }
    }

    @Override
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public String tosString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, name));
        sb.append("\n");
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, energy));
        sb.append("\n");

        if (suitcase.getExhibits().isEmpty()) {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
        } else {
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, suitcase.getExhibits().toString().replaceAll("[\\[\\]]", "")));
        }

        return sb.toString();
    }
}
