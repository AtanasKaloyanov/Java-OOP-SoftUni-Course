package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.annotations.Inject;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Unit;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

// P04:
public class Add extends Command {
    @Inject
    private UnitFactory unitFactory;

    @Inject
    private Repository repository;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
