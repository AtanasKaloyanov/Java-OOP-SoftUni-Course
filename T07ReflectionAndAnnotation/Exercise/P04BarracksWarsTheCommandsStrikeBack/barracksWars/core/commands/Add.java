package T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

// P04:
public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
