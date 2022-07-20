package T02Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
           if (this.money >= product.getCost()) {
               this.money -= product.getCost();
               this.products.add(product);
               System.out.printf("%s bought %s%n", this.name, product.getName());
           } else {
               throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.name, product.getName()));
           }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return String.format("%s – Nothing bought", this.name);
        } else {
           return String.format("%s - %s", this.name, products.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
