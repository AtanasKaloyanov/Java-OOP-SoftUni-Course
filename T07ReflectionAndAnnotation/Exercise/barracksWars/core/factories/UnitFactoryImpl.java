package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {
	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	// P03 method overriding - getting the class name, then the class and then the object of the class.
	// It is abstract and there are 5 options - Archer, Gunner, Horseman, Pikeman ana Swordsman:
	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String className = UNITS_PACKAGE_NAME + unitType;
		Class<?> searchedClass = Class.forName(className);
		return (Unit) searchedClass.getDeclaredConstructor().newInstance();
	}
}
