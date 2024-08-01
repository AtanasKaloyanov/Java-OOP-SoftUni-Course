package T06SOLID.Exercise.PSOLID;

import T06SOLID.Exercise.PSOLID.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    double average(List<Product> products);

}
