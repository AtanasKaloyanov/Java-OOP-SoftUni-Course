package T06SOLID.Exercise2;

import T06SOLID.Exercise2.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::calculateCalories)
                .sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
