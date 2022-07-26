package T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public class Weight extends OrderItem{
    public double getItemPrice() {
        return this.getQuantity() * 4.0 / 1000;
    }

}
