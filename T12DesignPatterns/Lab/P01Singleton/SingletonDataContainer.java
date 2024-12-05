package T12DesignPatterns.Lab.P01Singleton;

import java.util.Map;

public class SingletonDataContainer {
    private static SingletonDataContainer instance;
    private SingletonDataContainer() {
        System.out.println("Initializing singleton object");
    }

    public int getPopulation(Map<String, Integer> capitals, String name) {
        return capitals.get(name);
    }

    public static SingletonDataContainer getInstance() {
        if (instance == null) {
            instance = new SingletonDataContainer();
        }

        return instance;
    }
}
