package T12DesignPatterns.Exercise.Creational.P01Singleton;

public class Main {
    public static void main(String[] args) {
        // 1. I invoked 2 times the method getInstance.
        // By the first invocation it created an instance and returned it.
        // By the second invocation it only returned the instance.
        Capital capital = Capital.getInstance();
        Capital sameCapital = Capital.getInstance();
    }
}
