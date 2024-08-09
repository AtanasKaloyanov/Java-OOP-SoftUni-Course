package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

// P04 Command Pattern
public abstract class Command {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data,
                      Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }
}
