package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Executable;

// P04:
public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
             this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
