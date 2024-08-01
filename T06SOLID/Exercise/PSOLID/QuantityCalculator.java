package T06SOLID.Exercise.PSOLID;

import T06SOLID.Exercise.PSOLID.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::calculateAmountInKg)
                .sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
