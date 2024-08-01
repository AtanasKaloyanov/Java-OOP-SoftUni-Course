package T06SOLID.Exercise.PSOLID;

import T06SOLID.Exercise.PSOLID.products.Product;

import java.util.List;

public class Printer {
    private Calculator calculator;
    private static final String CALORIES_SUM_PATTERN = "The sum is: %.2f\n";
    private static final String CALORIES_AVERAGE_PATTERN = "The average sum is: %.2f\n";

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf(CALORIES_SUM_PATTERN,
                this.calculator.sum(products));
    }

    public void printAvg(List<Product> products) {
        System.out.printf(CALORIES_AVERAGE_PATTERN,
                this.calculator.average(products));
    }



}
