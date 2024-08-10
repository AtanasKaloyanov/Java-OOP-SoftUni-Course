package T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.Exercise.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

// P04:
public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }


    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
