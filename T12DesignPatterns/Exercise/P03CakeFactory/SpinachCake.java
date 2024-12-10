package T12DesignPatterns.Exercise.P03CakeFactory;

public class SpinachCake extends Cake {
    private static final double DIAMETER = 30;
    private static final double PRICE = 30;
    private static final int PIECES = 12;
    public SpinachCake() {
        super(DIAMETER, PRICE, PIECES);
    }

    @Override
    public void prepare() {
        System.out.println("The Spinach cake is prepared!");
    }

    @Override
    public void bake() {
        System.out.println("The Spinach cake is baked!");
    }

    @Override
    public void box() {
        System.out.println("The Spinach cake is packaged!");
    }
}
