package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars;

import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.Runnable;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.interfaces.UnitFactory;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.Engine;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.factories.UnitFactoryImpl;
import T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
