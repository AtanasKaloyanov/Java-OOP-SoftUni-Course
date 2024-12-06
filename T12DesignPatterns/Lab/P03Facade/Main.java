package T12DesignPatterns.Lab.P03Facade;

public class Main {
    private static final String PRODUCT_NAME = "Green tea";
    private static final String MANUFACTURER = "China system";
    private static final String DISTRIBUTOR = "Around the world";

    public static void main(String[] args) {
        // 1. Creating 2 objects and another one that associated them:
        Manufacturer manufacturer = new Manufacturer(MANUFACTURER);
        Distributor distributor = new Distributor(DISTRIBUTOR);
        Product product = new Product(PRODUCT_NAME, manufacturer, distributor);

        // 2. Getting the info of the third object and printing it. The method uses method
        // of the associated objects:
        String result = product.info();
        System.out.println(result);
    }
}
