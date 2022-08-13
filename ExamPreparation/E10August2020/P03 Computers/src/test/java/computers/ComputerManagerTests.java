package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private Computer computer;
    private ComputerManager computerManager;

    @Before()
    public void setUp() {
        computer = new Computer("I", "my", 100.0);
        computerManager = new ComputerManager();

        computerManager.addComputer(computer);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        computerManager.getComputers().clear();
    }

    @Test()
    public void testGetCount() {
        Assert.assertEquals(1, computerManager.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerE() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddE2() {
        Computer second = new Computer("I", "my", 1000.0);
        computerManager.addComputer(second);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerE1() {
        computerManager.getComputer(null, "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTestGetComputerE2() {
        computerManager.getComputer("a", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerE3() {
        computerManager.getComputer("b", "c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveE1() {
        computerManager.removeComputer(null, "b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveE2() {
        computerManager.removeComputer("a", null);
    }

    @Test()
    public void testRemoveCorrect() {
        Computer expercted = computerManager.removeComputer("I", "my");
        Assert.assertEquals(expercted, computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCorrect2() {
        Computer expected = computerManager.removeComputer("a", "my");
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerByManifacturer() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test()
    public void testGetComputerByManifacturerC() {
        List<Computer> expectedList = new ArrayList<>(List.of(computer));
        Assert.assertEquals(expectedList, computerManager.getComputersByManufacturer("I"));
    }

}