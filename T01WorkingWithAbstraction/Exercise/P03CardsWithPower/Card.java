package T01WorkingWithAbstraction.Exercise.P03CardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int powerCalculation() {
        int rankPower = this.rank.getPower();
        int suitPower = this.suit.getPower();
        return rankPower + suitPower;
    }
}
