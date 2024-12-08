package T12DesignPatterns.Exercise.Behavioural.P01Command;

public class ProductCommandImpl implements Command {
    private Product product;

    public ProductCommandImpl(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        double oldPrice = product.getPrice();
        double newPrice = 1.20 * oldPrice;
        this.product.setPrice(newPrice);
    }
}
