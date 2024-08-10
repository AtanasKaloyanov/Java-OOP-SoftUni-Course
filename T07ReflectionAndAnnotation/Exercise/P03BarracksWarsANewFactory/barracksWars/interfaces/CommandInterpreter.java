package T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
