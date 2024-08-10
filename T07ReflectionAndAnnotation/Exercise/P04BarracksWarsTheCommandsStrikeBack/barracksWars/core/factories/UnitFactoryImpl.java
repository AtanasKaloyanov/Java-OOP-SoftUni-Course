package T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.factories;

import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.";

	// P03 - Obtain a unit (it is abstract - there are 5 options),
	// then return an object of this class
	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
	    String classSimpleName = UNITS_PACKAGE_NAME + unitType;
		Class<?> unitClass = Class.forName(classSimpleName);
		Constructor<?> constructor = unitClass.getDeclaredConstructor();
		return (Unit) constructor.newInstance();
 	}
}
