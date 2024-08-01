package T06SOLID.Exercise.PSOLID;

import T06SOLID.Exercise.PSOLID.products.*;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Creating 4 products via Polymorphism:
        Product coke = new Coke(500);
        Product lemonade = new Lemonade(2_000);
        Product chocolate = new Chocolate(350);
        Product chips = new Chips(400);

        // 2. Adding the product into a list:
        List<Product> products = new ArrayList<>(
                List.of(coke, lemonade, chocolate, chips));

        // 3. Creating 2 calculators and printing the messages:
        // 3.1. Calorie calculator
        Calculator calorieCalculator = new CalorieCalculatorImpl();
        Printer caloriesPrinter = new Printer(calorieCalculator);
        caloriesPrinter.printSum(products);
        caloriesPrinter.printAvg(products);

        // 3.2. Quantity calculator:
        Calculator weightCalculator = new QuantityCalculator();
        Printer weightPrinter = new Printer(weightCalculator);
        weightPrinter.printSum(products);
        weightPrinter.printAvg(products);
    }
}
