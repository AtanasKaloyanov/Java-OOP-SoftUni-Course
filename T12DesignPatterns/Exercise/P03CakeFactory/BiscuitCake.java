package T12DesignPatterns.Exercise.P03CakeFactory;

public class BiscuitCake extends Cake {
    private static final double DIAMETER = 10;
    private static final double PRICE = 10;
    private static final int PIECES = 12;
    public BiscuitCake() {
        super(DIAMETER, PRICE, PIECES);
    }

    @Override
    public void prepare() {
        System.out.println("The Biscuit cake is prepared!");
    }

    @Override
    public void bake() {
        System.out.println("The Biscuit cake is baked!");
    }

    @Override
    public void box() {
        System.out.println("The Biscuit cake is packaged!");
    }
}
