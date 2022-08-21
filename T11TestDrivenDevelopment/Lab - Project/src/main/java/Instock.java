
import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> productList;

    public Instock() {
        productList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.productList.size();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean contains(Product product) {
        return productList.contains(product);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        Product searchedProduct = productList.stream()
                .filter(element -> element.getLabel().equals(product))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        searchedProduct.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= productList.size()) {
            throw new IndexOutOfBoundsException();
        }

        return this.productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return this.productList.stream()
                .filter(element -> element.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > productList.size()) {
            return new ArrayList<>();
        }

        return this.productList.stream()
                .skip(count)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> sortedList = productList.stream()
                .filter(element -> element.getPrice() > lo && element.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        return sortedList;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.productList.stream()
                .filter(element -> element.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> productList = this.productList.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());

        int productForSkipping = productList.size() - count;

        if (productForSkipping <= 0) {
            throw new IllegalArgumentException();
        }

        productList = productList.stream()
                .skip(productForSkipping)
                .collect(Collectors.toList());

        Collections.reverse(productList);

        return productList;

    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.productList.stream()
                .filter(element -> element.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.productList.iterator();
    }

    public void addFiveProducts(Product product, Product secondProduct, Product thirdProduct, Product fourthProduct, Product fifthProduct) {
        this.productList.add(product);
        this.productList.add(secondProduct);
        this.productList.add(thirdProduct);
        this.productList.add(fourthProduct);
        this.productList.add(fifthProduct);
    }
}
