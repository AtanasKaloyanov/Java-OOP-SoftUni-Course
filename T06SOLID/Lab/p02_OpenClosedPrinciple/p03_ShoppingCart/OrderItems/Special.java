package T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public class Special extends OrderItem{
    public double getItemPrice() {
        double result = 0;
        result += getQuantity() * 4.0;
        int setsOfThree = getQuantity() / 3;
        result -= setsOfThree * 2.0;

        return result;
    }
}
