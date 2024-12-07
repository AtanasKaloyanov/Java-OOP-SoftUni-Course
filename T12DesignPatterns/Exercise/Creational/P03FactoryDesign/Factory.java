package T12DesignPatterns.Exercise.Creational.P03FactoryDesign;

public abstract class Factory {
    private Product product;

    public Product createProduct() {
        this.product = initialize();
        return this.product;
    }

    public abstract Product initialize();
}
