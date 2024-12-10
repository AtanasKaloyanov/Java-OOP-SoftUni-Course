package T12DesignPatterns.Exercise.P03CakeFactory;

public class ChocolateCake extends Cake {
    private static final double DIAMETER = 20;
    private static final double PRICE = 20;
    private static final int PIECES = 12;
    public ChocolateCake() {
        super(DIAMETER, PRICE, PIECES);
    }

    @Override
    public void prepare() {
        System.out.println("The Chocolate cake is prepared!");
    }

    @Override
    public void bake() {
        System.out.println("The Chocolate cake is baked!");
    }

    @Override
    public void box() {
        System.out.println("The Chocolate cake is packaged!");
    }
}
