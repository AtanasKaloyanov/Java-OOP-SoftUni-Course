import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> productList = new ArrayList<>();
    private Map<String, Product> productByLabelMap = new TreeMap<>();

    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public boolean contains(Product product) {
        String searchedProductLabel = product.getLabel();
        return this.productByLabelMap.containsKey(searchedProductLabel);
    }

    @Override
    public void add(Product product) {
        if (this.contains(product)) {
            throw new UnsupportedOperationException(
                    "There is already a product with this label in the stock");
        }

        String newProductLabel = product.getLabel();
        this.productByLabelMap.put(newProductLabel, product);
        this.productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        Product searchedProduct = this.findByLabel(product);
        searchedProduct.setQuantity(quantity);

        changeProductQuantityInTheList(product, quantity);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= this.productList.size()) {
            throw new IndexOutOfBoundsException("The index is invalid.");
        }

        return this.productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        Product searchedProduct = this.productByLabelMap.get(label);
        if (searchedProduct == null) {
            throw new IllegalArgumentException(
                    "There is no product with the given label in the stock.");
        }

        return searchedProduct;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (isNotCorrect(count)) {
            return new ArrayList<>();
        }
        return this.productByLabelMap.values()
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        Predicate<Product> productPredicate = getRangePredicate(lo, hi);
        Comparator<Product> productComparator = getPriceComp();
        return this.productList.stream()
                .filter(productPredicate)
                .sorted(productComparator)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        Predicate<Product> pricePredicate = getPricePredicate(price);
        return this.productList.stream()
                .filter(pricePredicate)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (isNotCorrect(count)) {
            throw new IllegalArgumentException(
                    "The count parameter is greater that the products number.");
        }

        return this.productList.stream()
                .sorted(getPriceComp())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        Predicate<Product> quantityPredicate = getQuantityPredicate(quantity);
        return this.productList.stream()
                .filter(quantityPredicate)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return new IteratorHelper();
    }

    private class IteratorHelper implements Iterator<Product> {
        private List<Product> products = getProductList();
        private int index;

        @Override
        public boolean hasNext() {
            return this.index == this.products.size();
        }

        @Override
        public Product next() {
            return this.products.get(this.index++);
        }
    }

    public List<Product> getProductList() {
        return this.productList;
    }
    public Map<String, Product> getProductByLabelMap() {
        return this.productByLabelMap;
    }

    private boolean isNotCorrect(int count) {
        return count < 0 || count > this.productByLabelMap.size();
    }
    private static Predicate<Product> getPricePredicate(double price) {
        return product -> product.getPrice() == price;
    }

    private static Predicate<Product> getQuantityPredicate(int quantity) {
        return product -> product.getQuantity() == quantity;
    }

    private static Predicate<Product> getRangePredicate(double lo, double hi) {
        return product -> product.getPrice() > lo && product.getPrice() <= hi;
    }

    private static Comparator<Product> getPriceComp() {
        return Comparator.comparing(Product::getPrice).reversed();
    }

    private void changeProductQuantityInTheList(String product, int quantity) {
        for (Product currentProduct : this.productList) {
            if (currentProduct.getLabel().equals(product)) {
                currentProduct.setQuantity(quantity);
                return;
            }
        }
    }

}
