package T01WorkingWithAbstraction.Exercise.P03CardsWithPower;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int powerSuit;

    CardSuit(int powerSuit) {
        this.powerSuit = powerSuit;
    }

    public int getPowerSuit() {
        return powerSuit;
    }
}
