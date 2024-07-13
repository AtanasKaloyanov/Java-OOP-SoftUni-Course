package T01WorkingWithAbstraction.Lab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        double price = Double.parseDouble(array[0]);
        int days = Integer.parseInt(array[1]);
        Discount discount = Discount.valueOf(array[3]);
        Season season = Season.valueOf(array[2]);
        double totalSum = PriceCalculator.calculateHoliday(price, days, discount, season);
        System.out.printf("%.2f", totalSum);
    }
}
