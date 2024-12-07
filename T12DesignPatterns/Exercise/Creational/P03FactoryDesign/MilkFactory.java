package T12DesignPatterns.Exercise.Creational.P03FactoryDesign;

public class MilkFactory extends Factory{
    @Override
    public Product initialize() {
        return new Milk();
    }
}
