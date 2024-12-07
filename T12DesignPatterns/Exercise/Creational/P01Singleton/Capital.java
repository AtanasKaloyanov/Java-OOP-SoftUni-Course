package T12DesignPatterns.Exercise.Creational.P01Singleton;

public class Capital {
    private static Capital instance;

    private Capital() {
        System.out.println("I am instantiated!");
    }

    public static Capital getInstance() {
        if (instance == null) {
            instance = new Capital();
        }

        return instance;
    }
}
