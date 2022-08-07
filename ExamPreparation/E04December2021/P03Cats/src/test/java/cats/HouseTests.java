package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

public class HouseTests {
    private Cat kitty;
    private House house;

    @Before
    public void setUp() {
        kitty = new Cat("Shosho");
        house = new House("Ap", 5);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Ap", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameForNull() {
        House house = new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameForWhitespace() {
        House house = new House(" ", 5);
    }

    @Test()
    public void testSetNameForCorrectness() {
        House house = new House("H", 5);
        Assert.assertEquals(house.getName(), "H");
    }

    @Test
    public void testGetCapacityMethod() {
        Assert.assertEquals(house.getCapacity(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityMethodForNull() {
        House house = new House("H", -1);
    }

    @Test()
    public void testSetCapacityMethodCorrectness() {
        House house = new House("H", 5);
        Assert.assertEquals(house.getCapacity(), 5);
    }

    @Test()
    public void testGetCount() {
        house.addCat(kitty);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatMethodForException() {
        House house = new House("A", 0);
        Cat secondCat = new Cat("Zion");
        house.addCat(kitty);
        house.addCat(secondCat);
    }

    @Test()
    public void testAddCatMethodCorrectness() {
        house.addCat(kitty);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatForNull() {
        house.removeCat("A");
    }

    @Test()
    public void testRemoveCatForCorrectNess() {
        house.addCat(kitty);
        house.removeCat("Shosho");

        Assert.assertEquals(house.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleForNull() {
        house.catForSale("A");
    }

    @Test()
    public void testCatForSaleCorrectness() {
        house.addCat(kitty);
        house.catForSale("Shosho");

        Assert.assertFalse(kitty.isHungry());
    }

    @Test()
    public void testCatForSaleCorrectness2() {
        house.addCat(kitty);
        house.catForSale("Shosho");

        Cat expectedCat = new Cat("Shosho");

        Assert.assertEquals(expectedCat.getName(), kitty.getName());
    }

    @Test()
    public void testStatistics() {
        house.addCat(kitty);
        Cat secondCat = new Cat("Zion");
        house.addCat(secondCat);

        String message = "The cat Shosho, Zion is in the house Ap!";

        Assert.assertEquals(message, house.statistics());
    }



}
