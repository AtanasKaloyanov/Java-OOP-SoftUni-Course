import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class InstockTest {
    private Instock instock;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product clonedProduct;
    private Product nonExistProduct1;
    private Product nonExistProduct2;

    // 1. Before testing settings:
    @Before
    public void setUp() {
        // 1.1 Initializing the stock and initializing and adding 3 products:
        this.instock = new Instock();
        this.product1 = new Product(Constants.PRODUCT_1_LABEL, Constants.PRODUCT_1_PRICE, Constants.PRODUCT_1_QUANTITY);
        this.product2 = new Product(Constants.PRODUCT_2_LABEL, Constants.PRODUCT_2_PRICE, Constants.PRODUCT_2_QUANTITY);
        this.product3 = new Product(Constants.PRODUCT_3_LABEL, Constants.PRODUCT_3_PRICE, Constants.PRODUCT_3_QUANTITY);
        this.instock.add(this.product1);
        this.instock.add(this.product2);
        this.instock.add(this.product3);

        // 1.2. Initializing the copied and the non-existent products:
        this.clonedProduct = new Product(Constants.PRODUCT_1_LABEL, Constants.CLONED_PRODUCT_PRICE, Constants.CLONED_PRODUCT_QUANTITY);
        this.nonExistProduct1 = new Product(Constants.NON_EXIST_PRODUCT_1_LABEL, Constants.NON_EXIST_PRODUCT_1_PRICE, Constants.NON_EXIST_PRODUCT_1_QUANTITY);
        this.nonExistProduct2 = new Product(Constants.NON_EXIST_PRODUCT_2_LABEL, Constants.NON_EXIST_PRODUCT_2_PRICE, Constants.NON_EXIST_PRODUCT_2_QUANTITY);
    }

    // 2. Add:
    @Test
    public void testAdding3ProductForCorrectness() {
        // 2.1. List:
        // 2.1.1. List's size:
        List<Product> expectedList = new ArrayList<>(List.of(this.product1, this.product2, this.product3));
        int expectedListSize = expectedList.size();
        List<Product> actualProductList = this.instock.getProductList();
        int actualListSize = actualProductList.size();
        Assert.assertEquals(expectedListSize, actualListSize);

        // 2.1.2. List's elements:
        comparingProducts(expectedList, actualProductList, expectedListSize);

        // 2.2. Map:
        // 2.3. Map's size
        Map<String, Product> expectedProductsByLabelMap = new TreeMap<>();
        expectedProductsByLabelMap.put(this.product1.getLabel(), this.product1);
        expectedProductsByLabelMap.put(this.product2.getLabel(), this.product2);
        expectedProductsByLabelMap.put(this.product3.getLabel(), this.product3);
        int expectedMapSize = expectedProductsByLabelMap.size();
        Map<String, Product> actualProductsByLabelMap = this.instock.getProductByLabelMap();
        int actualMapSize = actualProductsByLabelMap.size();
        Assert.assertEquals(expectedMapSize, actualMapSize);

        // 2.4. Map's elements:
        List<Product> expectedProducts = new ArrayList<>(expectedProductsByLabelMap.values());
        comparingProducts(expectedList, actualProductList, expectedProducts.size());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testAddingWithExistentProductShouldThrow() {
        this.instock.add(this.clonedProduct);
    }

    // 3. Contains:
    @Test
    public void testContainsWithExistentAndUnexistentProducts() {
        boolean expectedExistedProduct1 = this.instock.contains(this.product1);
        boolean expectedExistedProduct2 = this.instock.contains(this.product2);
        boolean expectedExistedProduct3 = this.instock.contains(this.product3);
        boolean expectedExistedProduct4 = this.instock.contains(this.clonedProduct);
        boolean expectedNonExistent1 = this.instock.contains(this.nonExistProduct1);
        boolean expectedNonExistent2 = this.instock.contains(this.nonExistProduct2);

        Assert.assertTrue(expectedExistedProduct1);
        Assert.assertTrue(expectedExistedProduct2);
        Assert.assertTrue(expectedExistedProduct3);
        Assert.assertTrue(expectedExistedProduct4);
        Assert.assertFalse(expectedNonExistent1);
        Assert.assertFalse(expectedNonExistent2);
    }

    // 4. getCount:
    @Test
    public void testGetCountForCorrectness() {
        int expectedProducts = Constants.PRODUCT_COUNT_THREE;
        int actualCount = this.instock.getCount();
        Assert.assertEquals(expectedProducts, actualCount);
    }

    // 5. changeQuantity:
    @Test
    public void testChangeQuantity() {
        String label1 = this.product1.getLabel();
        this.instock.changeQuantity(label1, Constants.CHANGED_QUANTITY);

        // 5.1. check of the change in the map:
        int actualQuantity1 = this.instock.getProductByLabelMap()
                .get(label1)
                .getQuantity();
        Assert.assertEquals(actualQuantity1, Constants.CHANGED_QUANTITY);

        // 5.2. Check the check in the list:
        int actualQuantity2 = this.instock.getProductList()
                .get(0)
                .getQuantity();
        Assert.assertEquals(actualQuantity2, Constants.CHANGED_QUANTITY);
    }

    // 6. find:
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithNegativeIndex() {
        this.instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithIndexEqualsTheSize() {
        int index = this.instock.getProductList().size();
        this.instock.find(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithTooGreatIndex() {
        int tooGreatIndex = this.instock.getCount() + this.instock.getCount();
        this.instock.find(tooGreatIndex);
    }

    @Test
    public void testFindForCorrectProduct() {
        int index = 0;
        Product actualProduct1 = this.instock.find(index++);
        Assert.assertEquals(actualProduct1, this.product1);
        Product actualProduct2 = this.instock.find(index++);
        Assert.assertEquals(actualProduct2, this.product2);
        Product actualProduct3 = this.instock.find(index);
        Assert.assertEquals(actualProduct3, this.product3);
    }

    // 7. findByLabel:
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWithNonExistentLabel() {
        this.instock.findByLabel(Constants.NON_EXIST_PRODUCT_1_LABEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWithNonExistentLabel2() {
        this.instock.findByLabel(Constants.NON_EXIST_PRODUCT_2_LABEL);
    }

    @Test
    public void testFindByLabelForCorrectProduct() {
        Product actualProduct1 = this.instock.findByLabel(Constants.PRODUCT_1_LABEL);
        Product actualProduct2 = this.instock.findByLabel(Constants.PRODUCT_2_LABEL);
        Product actualProduct3 = this.instock.findByLabel(Constants.PRODUCT_3_LABEL);
        Assert.assertEquals(this.product1, actualProduct1);
        Assert.assertEquals(this.product2, actualProduct2);
        Assert.assertEquals(this.product3, actualProduct3);
    }

    // 8. findFirstByAlphOrder:
    @Test
    public void testFindFirstByAlphOrderWithTooGreatCount() {
        Iterable<Product> expectedIterable = new ArrayList<>();
        int tooGreatCount = this.instock.getCount() + Constants.PRODUCT_COUNT_THREE;
        Iterable<Product> actualIterable = this.instock.findFirstByAlphabeticalOrder(tooGreatCount);
        Assert.assertEquals(expectedIterable, actualIterable);
    }

    @Test
    public void testFirstByAlphOrderWithProductsCount() {
        Iterable<Product> expectedIterable = new ArrayList<>(this.instock.getProductByLabelMap().values());
        Iterable<Product> actualIterable = this.instock.findFirstByAlphabeticalOrder(Constants.PRODUCT_COUNT_THREE);
        Assert.assertEquals(expectedIterable, actualIterable);
    }

    // 9. findAllInRange:
    @Test
    public void testFindAllInRangeForCorrectResult() {
        // lo = 1.10 (exclusive), hi = 3.30 (inclusive)
        double lowBound = Constants.lowBound;
        double highBound = Constants.highBound;
        // 9.1.
        Iterable<Product> expectedResult1 = new ArrayList<>(List.of(this.product3, this.product2, this.product1));
        Iterable<Product> actualResult1 = this.instock.findAllInRange(lowBound - 0.01, highBound);
        // 9.2.
        Iterable<Product> expectedResult2 = new ArrayList<>(List.of(this.product3, this.product2));
        Iterable<Product> actualResult2 = this.instock.findAllInRange(lowBound, highBound);
        // 9.3.
        Iterable<Product> expectedResult3 = new ArrayList<>(List.of(this.product2));
        Iterable<Product> actualResult3 = this.instock.findAllInRange(lowBound, highBound - 0.01);
        // 9.4.
        Iterable<Product> expectedResult4 = new ArrayList<>(List.of(this.product2, this.product1));
        Iterable<Product> actualResult4 = this.instock.findAllInRange(lowBound - 0.01, highBound - 0.01);

        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult2, actualResult2);
        Assert.assertEquals(expectedResult3, actualResult3);
        Assert.assertEquals(expectedResult4, actualResult4);
    }

    // 10. findAllByPrice:
    @Test
    public void testFindAllByPrice() {
         Iterable<Product> testFind;
    }

    // 11. findMostExpensiveProducts:


    // 12. findAllByQuantity:


    // 13. iterator
    @Test
    public void testIteratorCorrectness() {
        Iterator<Product> actualIter = this.instock.iterator();
        Product actualProduct1 = actualIter.next();
        Product actualProduct2 = actualIter.next();
        Product actualProduct3 = actualIter.next();
        Assert.assertEquals(this.product1, actualProduct1);
        Assert.assertEquals(this.product2, actualProduct2);
        Assert.assertEquals(this.product3, actualProduct3);
    }

    private static void comparingProducts(List<Product> expectedList, List<Product> actualProductList, int expectedListSize) {
        for (int i = 0; i < expectedListSize; i++) {
            Product currentExpectedProduct = expectedList.get(i);
            Product currentActualProduct = actualProductList.get(i);
            Assert.assertEquals(currentExpectedProduct, (currentActualProduct));
        }
    }
}
