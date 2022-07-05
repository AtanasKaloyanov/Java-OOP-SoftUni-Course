package T01WorkingWithAbstraction.Lab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season givenSeason = Season.valueOf(input[2]);
        DiscountType givenDiscountType = DiscountType.valueOf(input[3]);

        double finalPrice = PriceCalculator.calculateFinalPrice(pricePerDay, numberOfDays, givenSeason, givenDiscountType);
        System.out.printf("%.2f", finalPrice);
    }
}
