package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Animal animal;
    private Farm farm;

    @Before
    public void setUp() {
          animal = new Animal("cat", 10.2);
          farm = new Farm("Village", 2);
    }

    @Test
    public void testGetCount() {
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testGetName() {
        String expName = farm.getName();
        Assert.assertEquals(expName, "Village");

    }
    @Test
    public void testGetCapacity() {
        int expCapacity = farm.getCapacity();
        Assert.assertEquals(2, expCapacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddForException() {
        Animal secondAnimal = new Animal("dog", 2.5);
        Animal thirdAnimal = new Animal("rabbit", 11.1);
        farm.add(animal);
        farm.add(secondAnimal);
        farm.add(thirdAnimal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalException() {
        farm.add(animal);
        Animal secondAnimal = new Animal("cat", 2.5);
        farm.add(secondAnimal);
    }

    @Test
    public void testAddCorrectness() {
        farm.add(animal);
        Assert.assertEquals(animal.getType(), "cat");
    }

    @Test()
    public void testRemoveTrue() {
        farm.add(animal);
        boolean isRemove = farm.remove("cat");

        Assert.assertTrue(isRemove);

    }

    @Test
    public void testRemoveFalse() {
        farm.add(animal);
        boolean isRemove = farm.remove("dog");

        Assert.assertFalse(isRemove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityForException() {
        Farm farm = new Farm("Selo", - 1);
    }

    @Test()
    public void testSetCapacityCorrectness() {
        Farm farm = new Farm("Selo", 1);
        int expectedCap = farm.getCapacity();

        Assert.assertEquals(1, expectedCap);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameForExceptionNull() {
        Farm farm = new Farm(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameForExceptionEmpty() {
        Farm farm = new Farm(" " ,  1);
    }

    @Test()
    public void testSetNameCorrectness() {
        Farm farm = new Farm("selo" ,  1);
        Assert.assertEquals("selo", farm.getName());
    }
}
