package T01WorkingWithAbstraction.Exercise.P02CardRank;

public class Main {
    public static void main(String[] args) {
         
        CardRank[] cardRank = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank rank : cardRank) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank);
        }
    }
}
