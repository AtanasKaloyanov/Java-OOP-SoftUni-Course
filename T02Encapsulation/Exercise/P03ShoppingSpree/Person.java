package T02Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products = new ArrayList<>();

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        double cost = product.getCost();
        if (this.money < cost) {
            String personName = this.name;
            String productName = product.getName();
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s\n", personName, productName));
        } else {
            this.money -= cost;
            this.products.add(product);
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String productsInfo;
        if (this.products.isEmpty()) {
            productsInfo = "Nothing bought";
        } else {
            productsInfo = this.products.toString().replaceAll("[\\[\\]]", "");
        }

        return this.getName() + " - " + productsInfo;
    }
}

/*

-	name: String
-	money:  double
-	products:  List<Product>
+ 	Person (String,  double)
-	setName (String): void
-	setMoney (double): void
+	buyProduct (Product): void
+	getName(): String

 */
