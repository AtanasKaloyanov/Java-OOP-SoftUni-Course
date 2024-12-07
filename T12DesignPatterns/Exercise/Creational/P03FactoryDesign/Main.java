package T12DesignPatterns.Exercise.Creational.P03FactoryDesign;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 2 factories via Polymorphism:
        Factory milkFactory = new MilkFactory();
        Factory cheeseFactory = new CheeseFactory();

        // 2. Creating 2 products using the factories:
        Product milk = milkFactory.createProduct();
        Product cheese = cheeseFactory.createProduct();

        // 3. Invoking the info method from the objects.
        // Both messages should be different:
        milk.info();
        cheese.info();
    }
}
