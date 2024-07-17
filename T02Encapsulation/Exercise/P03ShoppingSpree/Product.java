package T02Encapsulation.Exercise.P03ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/*

-	name: String
-	cost: double
+ 	Product (String,  double)
-	setCost (double): void
-	setName (String): void
+	getName(): String
+	getCost (): double

 */
