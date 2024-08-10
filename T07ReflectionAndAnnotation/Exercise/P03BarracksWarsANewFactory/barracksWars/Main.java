package T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars;

import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.interfaces.Repository;
import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.interfaces.Runnable;
import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.interfaces.UnitFactory;
import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.core.Engine;
import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.core.factories.UnitFactoryImpl;
import T07ReflectionAndAnnotation.Exercise.P03BarracksWarsANewFactory.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
