package T06SOLID.Exercise2;


import T06SOLID.Exercise2.products.Product;

import java.util.List;

public class Printer {
    private Calculator calculator;
    private static final String SUM_PATTERN = "Sum: %f";
    private static final String AVERAGE_PATTERN = "Average: %f";

    public Printer() {
        this.calculator = new CalorieCalculator();
    }

    public void printSum(List<Product> products) {
        System.out.printf(SUM_PATTERN,
                this.calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf(AVERAGE_PATTERN,
                this.calculator.average(products));
    }

}
