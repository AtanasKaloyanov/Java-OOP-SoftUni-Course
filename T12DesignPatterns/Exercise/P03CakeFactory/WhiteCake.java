package T12DesignPatterns.Exercise.P03CakeFactory;

public class WhiteCake extends Cake {
    private static final double DIAMETER = 40;
    private static final double PRICE = 40;
    private static final int PIECES = 12;
    public WhiteCake() {
        super(DIAMETER, PRICE, PIECES);
    }

    @Override
    public void prepare() {
        System.out.println("The White cake is prepared!");
    }

    @Override
    public void bake() {
        System.out.println("The White cake is baked!");
    }

    @Override
    public void box() {
        System.out.println("The White cake is packaged!");
    }
}
