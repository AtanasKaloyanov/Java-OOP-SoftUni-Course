package T12DesignPatterns.Exercise.Creational.P03FactoryDesign;

public class CheeseFactory extends Factory {
    @Override
    public Product initialize() {
        return new Cheese();
    }
}
