package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    private Goods goods;
    private Shop shop;

    @Before
    public void SetUp() {
        goods = new Goods("firstName", "firstCode");
        shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetshelves() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.getShelves().remove("Shelves1");
    }

    @Test()
    public void testGetshelvesC() throws OperationNotSupportedException {
        Map<String, Goods> expMap = new LinkedHashMap<>();
        expMap.put("Shelves1", null);
        expMap.put("Shelves2", null);
        expMap.put("Shelves3", null);
        expMap.put("Shelves4", null);
        expMap.put("Shelves5", null);
        expMap.put("Shelves6", null);
        expMap.put("Shelves7", null);
        expMap.put("Shelves8", null);
        expMap.put("Shelves9", null);
        expMap.put("Shelves10", null);
        expMap.put("Shelves11", null);
        expMap.put("Shelves12", null);

        Assert.assertEquals(expMap, shop.getShelves());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcIll1() throws OperationNotSupportedException {
        shop.addGoods("Shelves", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExcIll2() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        Goods goods2 = new Goods("secondName", "secondCode");
        shop.addGoods("Shelves1", goods2);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testAddExc3() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test()
    public void testAddMethodCorrectness() throws OperationNotSupportedException {
        String message = shop.addGoods("Shelves1", goods);
        String expectedMessage = "Goods: firstCode is placed successfully!";
        Assert.assertEquals(expectedMessage, message);
        Assert.assertEquals(goods.getName(), "firstName");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodForExc() {
        shop.removeGoods("a", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodForExc2() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        Goods goods2 = new Goods("secondName", "secondCode");
        shop.removeGoods("Shelves1", goods2);
    }

    @Test()
    public void testRemoveCorrectness() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        String message = shop.removeGoods("Shelves1", goods);
        String expectedMessage = "Goods: firstCode is removed successfully!";

        Assert.assertEquals(message, expectedMessage);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }
    
}
