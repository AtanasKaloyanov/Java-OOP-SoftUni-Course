package T01WorkingWithAbstraction.Lab.P04HotelReservation;

public class PriceCalculator {
    public static double calculateHoliday(double pricePerDay, int days, Discount discount, Season season) {
        int discountPerc = discount.getDiscount();
        double pricePerDayWithDisc = pricePerDay - pricePerDay * (discountPerc * 1.0 / 100);
        pricePerDayWithDisc *= days;
        int multiplier = season.getMultiplyN();
        pricePerDayWithDisc *= multiplier;
        return pricePerDayWithDisc;
    }
}
