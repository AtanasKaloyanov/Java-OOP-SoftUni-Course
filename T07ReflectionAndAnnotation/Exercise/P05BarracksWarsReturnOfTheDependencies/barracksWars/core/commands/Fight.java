package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;

// P04:
public class Fight extends Command {
    public Fight(String[] data) {
        super(data);
    }


    @Override
    public String execute() {
        return "fight";
    }
}
