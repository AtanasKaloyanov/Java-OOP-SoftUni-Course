package zoo;

import zoo.core.Engine;
import zoo.core.EngineImpl;
import zoo.entities.areas.BaseArea;
import zoo.entities.areas.LandArea;

public class Main {

    public static void main(String[] args) {
     //   Engine engine = new EngineImpl();
     //   engine.run();

        BaseArea area = new LandArea("alabala");
        System.out.println(area.getInfo());
    }
}
