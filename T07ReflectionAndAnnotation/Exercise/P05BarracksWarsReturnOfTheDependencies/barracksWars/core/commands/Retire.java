package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.annotations.Inject;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

// P04:
public class Retire extends Command {
    @Inject
    private Repository repository;
    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = super.getData()[1];
        String result;

        try {
            this.repository.removeUnit(unitType);
            result =  unitType + " retired!";
        } catch (IllegalArgumentException e) {
           result = e.getMessage();
        }

        return result;
    }
}
