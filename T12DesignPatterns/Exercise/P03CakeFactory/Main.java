package T12DesignPatterns.Exercise.P03CakeFactory;

public class Main {
    public static void main(String[] args) {
        // 1. Creating a cake factory and a pastry shop:
        CakeFactory cakeFactory = new CakeFactory();
        PastryShop pastryShop = new PastryShop(cakeFactory);

        // 2. Invoking 4 times the method placeAndOrder passing 4 different enums:
        pastryShop.placeAndOrder(CakeType.BISCUIT);
        pastryShop.placeAndOrder(CakeType.CHOCOLATE);
        pastryShop.placeAndOrder(CakeType.SPINACH);
        pastryShop.placeAndOrder(CakeType.WHITE);
    }
}
