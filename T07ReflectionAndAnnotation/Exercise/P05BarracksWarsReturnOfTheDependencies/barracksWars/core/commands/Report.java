package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.commands;


import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.annotations.Inject;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;

// P04:
public class Report extends Command {
    @Inject
    private Repository repository;
    public Report(String[] data) {
        super(data);
    }


    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
