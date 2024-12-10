package T12DesignPatterns.Exercise.P03CakeFactory;

public class PastryShop {
    private CakeFactory cakeFactory;

    public PastryShop(CakeFactory cakeFactory) {
        this.cakeFactory = cakeFactory;
    }

    public void placeAndOrder(CakeType cakeType) {
        Cake cake = this.cakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();
    }
}
