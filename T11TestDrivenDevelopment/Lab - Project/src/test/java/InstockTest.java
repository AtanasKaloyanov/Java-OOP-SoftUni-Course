import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class InstockTest {

    private Product product;
    private Product secondProduct;
    private Product thirdProduct;
    private Product fourthProduct;
    private Product fifthProduct;
    private Instock instock;
    private Iterable<Product> returnedProducts;
    private List<Product> returnedList;
    List<Product> expectedProducts;

    private static final String PRODUCT_WINE = "wine";
    private static final String UNEXISTENT_PRODUCT_BREAD = "bread";
    private static final int NEGATIVE_INDEX = -1;
    private static final int CORRECT_INDEX = 1;
    private static final int LARGE_INDEX = 10;
    private static final int PRODUCTS_NUMBER = 4;
    private static final int LOW_BORDER = 1;
    private static final int HIGH_BORDER = 7;
    private static final int SEARCHED_PRICE = 7;
    private static final int PRODUCT_QUANTITY = 3;

    @Before()
    public void setUp() {
        this.product = new Product("cheese", 3.40, 2);
        this.secondProduct = new Product("wine", 90, 2);
        this.thirdProduct = new Product("grape", 7.0, 3);
        this.fourthProduct = new Product("cola", 2, 3);
        this.fifthProduct = new Product("tea", 1, 5);

        this.instock = new Instock();
        this.instock.add(this.product);
        this.returnedList = new ArrayList<>();
        this.expectedProducts = new ArrayList<>();
    }

    @Test()
    public void testAddProductCorrectness() {
        Assert.assertTrue(this.instock.contains(this.product));
    }

    @Test()
    public void testContainMethodForCorrectness() {
        addingTwoProductsInStock();
        Product expectedProduct = getProduct(PRODUCT_WINE);
        Assert.assertEquals(this.secondProduct.getLabel(), expectedProduct.getLabel());
    }

    @Test()
    public void testCounMethodCorrectness() {
        int realProductsInStock = this.instock.getCount();
        int expectedProductInStrock = 1;

        Assert.assertEquals(realProductsInStock, expectedProductInStrock);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMethodForIndexOutOfBoundsExceptionBecauseOfNegativeIndex() {
        instock.find(NEGATIVE_INDEX);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMethodForIndexOutOfBoundsExceptionBecauseOfLargIndex() {
        addingTwoProductsInStock();
        this.instock.find(LARGE_INDEX);
    }

    @Test()
    public void testFindMethodCorrectNess() {
        addingTwoProductsInStock();
        Product returnedProduct = this.instock.find(CORRECT_INDEX);
        Product expectedProduct = getProduct(PRODUCT_WINE);

        Assert.assertEquals(returnedProduct, expectedProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityForIllegalArgumentExceptionBeacauseOfProductThatDoesntExist() {
        addingTwoProductsInStock();
        this.instock.changeQuantity(UNEXISTENT_PRODUCT_BREAD, 2);
    }

    @Test()
    public void testChangeQuantityCorrectness() {
        addingTwoProductsInStock();
        this.instock.changeQuantity(PRODUCT_WINE, 5);

        Product product = getProduct(PRODUCT_WINE);
        int productQuantity = product.getQuantity();

        int expectedProductQuantity = 5;

        Assert.assertEquals(productQuantity, expectedProductQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelMethodForExceptionBecauseOfNonexistentProduct() {
        addingTwoProductsInStock();
        Product nonexistentProduct = this.instock.findByLabel(UNEXISTENT_PRODUCT_BREAD);
    }

    @Test()
    public void testFindByLabelForEmptyListWithNegativeNumber() {
        Iterable<Product> returnedEmptyList = this.instock.findFirstByAlphabeticalOrder(NEGATIVE_INDEX);
        this.returnedList = (List<Product>) returnedEmptyList;

        Assert.assertEquals(0, this.returnedList.size());
    }

    @Test()
    public void testFindByLabelForEmptyListWithLargeNumber() {
        this.returnedProducts = this.instock.findFirstByAlphabeticalOrder(LARGE_INDEX);
        this.returnedList = (List<Product>) this.returnedProducts;

        Assert.assertEquals(0, this.returnedList.size());
    }

    @Test()
    public void testFindByLabelCorrectness() {
        addingTwoProductsInStock();
        Product returnedProduct = this.instock.findByLabel(PRODUCT_WINE);
        Product expectedProduct = getProduct(PRODUCT_WINE);

        Assert.assertEquals(returnedProduct, expectedProduct);
    }

    @Test()
    public void testFirstByAlphabethicalOrderCorrectness() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();

        this.returnedProducts = this.instock.findFirstByAlphabeticalOrder(PRODUCTS_NUMBER);
        listFilling();

        this.expectedProducts = this.instock.getProductList()
                .stream()
                .skip(PRODUCTS_NUMBER)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

        Assert.assertEquals(this.returnedList, expectedProducts);
    }

    @Test()
    public void testFindAllInPriceInRange() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();

        this.returnedProducts = this.instock.findAllInRange(LOW_BORDER, HIGH_BORDER);
        listFilling();

        this.expectedProducts = this.instock.getProductList().stream()
                .filter(element -> element.getPrice() > LOW_BORDER && element.getPrice() <= HIGH_BORDER)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(this.returnedList, expectedProducts);
    }

    @Test()
    public void testFindAllByPrice() {
        this.returnedProducts = this.instock.findAllByPrice(SEARCHED_PRICE);
        listFilling();

        this.expectedProducts = this.instock
                .getProductList().stream()
                .filter(element -> element.getPrice() == SEARCHED_PRICE)
                .collect(Collectors.toList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstMostExpensiveProductsForExceptionBecauseOfLargeIndex() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();
        this.instock.findFirstMostExpensiveProducts(LARGE_INDEX);
    }

    @Test()
    public void testFirstMostExpensiveProductsCorrectness() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();
        this.returnedProducts = this.instock.findFirstMostExpensiveProducts(PRODUCTS_NUMBER);
        listFilling();

        this.expectedProducts = this.instock.getProductList().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .skip(instock.getCount() - PRODUCTS_NUMBER)
                .collect(Collectors.toList());

        Collections.reverse(expectedProducts);

        Assert.assertEquals(returnedList, expectedProducts);
    }

    @Test()
    public void testFindAllByQuantityCorrectness() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();

        this.returnedProducts = instock.findAllByQuantity(PRODUCT_QUANTITY);
        listFilling();

        this.expectedProducts = instock.getProductList()
                        .stream().filter(element -> element.getQuantity() == PRODUCT_QUANTITY)
                        .collect(Collectors.toList());

        Assert.assertEquals(returnedList, expectedProducts);
    }

    @Test()
    public void testIteratorCorrectness() {
        addingTwoProductsInStock();
        addingFourthAndFifthProduct();

        Iterator<Product> returnedProducts = this.instock.iterator();

        while (returnedProducts.hasNext()) {
            returnedList.add(returnedProducts.next());
        }

        this.expectedProducts = this.instock.getProductList();
        Assert.assertEquals(this.expectedProducts, this.returnedList);
    }

    private void listFilling() {
        this.returnedProducts.forEach(element -> this.returnedList.add(element));
    }

    @org.jetbrains.annotations.NotNull
    private Product getProduct(String label) {
        return this.instock.getProductList().stream()
                .filter(element -> element.getLabel().equals(label))
                .findFirst()
                .get();
    }

    private void addingTwoProductsInStock() {
        this.instock.add(secondProduct);
        this.instock.add(thirdProduct);
    }

    private void addingFourthAndFifthProduct() {
        this.instock.add(fourthProduct);
        this.instock.add(fifthProduct);
    }

}
