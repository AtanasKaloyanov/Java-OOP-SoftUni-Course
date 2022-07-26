package T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems.OrderItem;
import T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems.Souvenir;
import T06SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems.Special;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        OrderItem souvenir = new Souvenir();
        cart.add(souvenir);

        OrderItem gift = new Special();
        cart.add(gift);

        System.out.println(cart.getTotalAmount());

    }
}
