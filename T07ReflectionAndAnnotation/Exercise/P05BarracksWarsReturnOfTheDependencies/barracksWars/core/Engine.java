package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core;

import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.annotations.Inject;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.*;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException |
					 InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	// P04: Refactoring:

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		// 1. Obtain the commandClass by its simple name:
		String commandClassSimpleName = getClassSimpleName(commandName);
		Class<?> commandClass = Class.forName(commandClassSimpleName);
		// 2. Instantiating the class:
		Constructor<?> constructor =  commandClass.getDeclaredConstructor(String[].class);
		Executable commandObject = (Executable) constructor.newInstance((Object) data);

		// P05: 3. Dependency Injection:
		//      3.1. Obtain all fields values by their return type simple name.
		//            The data is stored in a map.
		Map<String, Object> fieldsByTypeName = getFieldValuesByReturnTypeSimpleName();
		Field[] commandObjectFields = commandClass.getDeclaredFields();
		//      3.2. Looping through the command's fields. If some of the fields has Injection
		//           annotation => Getting the Object value from the map
		//           and setting it to the command object.
		for (Field commandObjectField : commandObjectFields) {
		     commandObjectField.setAccessible(true);
			 if (commandObjectField.isAnnotationPresent(Inject.class)) {
				 String commandTypeSimpleName = commandObjectField.getType().getSimpleName();
				 Object searchedObject = fieldsByTypeName.get(commandTypeSimpleName);
				 if (searchedObject != null) {
					 commandObjectField.set(commandObject, searchedObject);
				 }
			 }
		}

		// 4. Return the result of the execute method:
		return commandObject.execute();

		// P04 This was the old implementation of the method interpretCommands:
        /*
		switch (commandName) {
			case "add":
				result = this.addUnitCommand(data);
				break;
			case "report":
				result = this.reportCommand(data);
				break;
			case "fight":
				result = this.fightCommand(data);
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}
		 */
	}

	private static String getClassSimpleName(String commandName) {
		return "T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands." +
				Character.toUpperCase(commandName.charAt(0))
				+ commandName.substring(1);
	}

	private  Map<String, Object> getFieldValuesByReturnTypeSimpleName() throws IllegalAccessException {
		Map<String, Object> fieldValuesBySimpleName = new HashMap<>();
		Field[] fields = Engine.class.getDeclaredFields();

		for (Field field : fields) {
			String typeName = field.getType().getSimpleName();
			Object fieldValue = field.get(this);
			fieldValuesBySimpleName.put(typeName, fieldValue);
		}

		return fieldValuesBySimpleName;
	}

	// P04: These 3 methods were invoked from the old implementation of the method interpretCommands:
    /*
	private String reportCommand(String[] data) {
		String output = this.repository.getStatistics();
		return output;
	}

	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}
	
	private String fightCommand(String[] data) {
		return "fight";
	}
	 */
}
