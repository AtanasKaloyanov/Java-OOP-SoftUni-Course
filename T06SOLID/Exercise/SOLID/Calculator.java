package T06SOLID.Exercise2;

import T06SOLID.Exercise2.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    double average(List<Product> products);

}
