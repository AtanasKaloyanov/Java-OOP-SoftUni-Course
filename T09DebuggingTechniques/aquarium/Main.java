package T09DebuggingTechniques.aquarium;

import T09DebuggingTechniques.aquarium.core.Engine;
import T09DebuggingTechniques.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
