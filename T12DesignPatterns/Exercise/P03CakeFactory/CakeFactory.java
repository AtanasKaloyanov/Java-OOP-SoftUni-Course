package T12DesignPatterns.Exercise.P03CakeFactory;

public class CakeFactory {
    public Cake createCake(CakeType type) {
        return switch (type) {
            case BISCUIT -> new BiscuitCake();
            case CHOCOLATE -> new ChocolateCake();
            case SPINACH -> new SpinachCake();
            case WHITE -> new WhiteCake();
        };
    }
}
