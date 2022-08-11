package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Fish f;
    private Aquarium aquarium;

    @Before
    public void setUp() {
        f = new Fish("Nemo");
        aquarium = new Aquarium("name", 2);
    }

    @Test()
    public void testGetName() {
        String name = "name";
        Assert.assertEquals(name, aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameE1() {
        String name = " ";
        Aquarium aquarium2 = new Aquarium(name, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameE2() {
        String name = null;
        Aquarium aquarium2 = new Aquarium(name, 2);
    }

    @Test()
    public void testSetNameCorrectness() {
        String name = "name";
        Aquarium aquarium2 = new Aquarium(name, 2);
        Assert.assertEquals(name, aquarium2.getName());
    }

    @Test()
    public void testGetCapacity() {
        int capacity = 2;
        Assert.assertEquals(aquarium.getCapacity(), capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityExc() {
        Aquarium aquarium2 = new Aquarium("Nemo", -1);
    }

    @Test()
    public void testGetCount() {
        aquarium.add(f);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddE1() {
        aquarium.add(f);
        Fish fish2 = new Fish("a");
        Fish fish3 = new Fish("b");
        aquarium.add(fish2);
        aquarium.add(fish3);
    }

    @Test()
    public void testAddC() {
        aquarium.add(f);
        Assert.assertEquals(aquarium.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveE1() {
        aquarium.add(f);
        aquarium.remove("a");
    }

    @Test()
    public void testRemoveC() {
        aquarium.add(f);
        aquarium.remove("Nemo");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishE1() {
        aquarium.add(f);
        aquarium.sellFish("a");
    }

    @Test()
    public void testSellFishC() {
        aquarium.add(f);
        Fish expectedFish = aquarium.sellFish("Nemo");
        f.setAvailable(false);

        Assert.assertEquals(expectedFish, f);

    }
    @Test()
    public void testSellFishC2() {
        aquarium.add(f);
        Fish expectedFish = aquarium.sellFish("Nemo");

        Assert.assertFalse(f.isAvailable());

    }

    @Test()
    public void testReport() {
        aquarium.add(f);
        Fish secondFish = new Fish("a");
        aquarium.add(secondFish);
         String message = "Fish available at name: Nemo, a";
    }



}

