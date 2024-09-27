import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        this.product1 = new Product(Constants.PRODUCT_1_NAME, Constants.PRODUCT_1_PRICE, Constants.PRODUCT_1_QUANTITY);
        this.product2 = new Product(Constants.PRODUCT_2_NAME, Constants.PRODUCT_2_PRICE, Constants.PRODUCT_2_QUANTITY);
        this.product3 = new Product(Constants.PRODUCT_3_NAME, Constants.PRODUCT_3_PRICE, Constants.PRODUCT_3_QUANTITY);
        this.instock.add(product1);
        this.instock.add(product2);
        this.instock.add(product3);

        // 1.2. Initializing the copied and the non-existent products:
        this.clonedProduct = new Product(Constants.PRODUCT_1_NAME, Constants.CLONED_PRODUCT_PRICE, Constants.CLONED_PRODUCT_QUANTITY);
        this.nonExistProduct1 = new Product(Constants.NON_EXIST_PRODUCT_1_NAME,Constants.NON_EXIST_PRODUCT_1_PRICE, Constants.NON_EXIST_PRODUCT_1_QUANTITY);
        this.nonExistProduct2 = new Product(Constants.NON_EXIST_PRODUCT_2_NAME, Constants.NON_EXIST_PRODUCT_2_PRICE, Constants.NON_EXIST_PRODUCT_2_QUANTITY);
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
        List<Product> actualProducts = new ArrayList<>(actualProductsByLabelMap.values());

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

    // 4. getCount():
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
    }

    private static void comparingProducts(List<Product> expectedList, List<Product> actualProductList, int expectedListSize) {
        for (int i = 0; i < expectedListSize; i++) {
            Product currentExpectedProduct = expectedList.get(i);
            Product currentActualProduct = actualProductList.get(i);
            Assert.assertEquals(currentExpectedProduct, (currentActualProduct));
        }
    }
}
