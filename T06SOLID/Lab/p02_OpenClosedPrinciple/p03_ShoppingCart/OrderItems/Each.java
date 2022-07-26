package T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public class Each extends OrderItem {
    public double getItemPrice() {
        return this.getQuantity() * 5.0;
    }

}
