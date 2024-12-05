package T12DesignPatterns.Lab.P01Singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Creating and filling a Map
        Map<String, Integer> populationByCapitals = new HashMap<>();
        populationByCapitals.put("A", 100);
        populationByCapitals.put("B", 200);
        populationByCapitals.put("C", 300);

        // 2. Invoking the method
        SingletonDataContainer singletonDataContainer = SingletonDataContainer.getInstance();
        SingletonDataContainer singletonDataContainer2 = SingletonDataContainer.getInstance();
        int aNumber = singletonDataContainer.getPopulation(populationByCapitals, "A");
        int bNumber = singletonDataContainer2.getPopulation(populationByCapitals, "B");

        // 3. Result printing:
        System.out.println(aNumber);
        System.out.println(bNumber);
    }
}
