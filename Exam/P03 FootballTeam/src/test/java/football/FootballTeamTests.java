package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private Footballer footballer;
    private FootballTeam footballTeam;

    @Before()
    public void setUp() {
        footballer = new Footballer("I");
        footballTeam = new FootballTeam("Aytos", 2);

        footballTeam.addFootballer(footballer);
    }

    @Test()
    public void testGetName(){
        Assert.assertEquals("Aytos", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameForE1(){
        FootballTeam second = new FootballTeam(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPosE1(){
        FootballTeam second = new FootballTeam("a", -1);
    }

    @Test()
    public void testGetCount(){
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddE1(){
        Footballer second = new Footballer("You");
        footballTeam.addFootballer(second);
        Footballer third = new Footballer("A");
        footballTeam.addFootballer(third);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveE1(){
        footballTeam.removeFootballer("You");
    }

    @Test()
    public void testRemoveC1(){
        footballTeam.removeFootballer("I");
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFForSaleE1(){
        footballTeam.footballerForSale("You");

    } @Test()
    public void testSellC1(){;
        Boolean expectedBoolean = false;

        Assert.assertEquals(expectedBoolean, footballTeam.footballerForSale("I").isActive());

    }

    @Test()
    public void testToString(){
        String expectedMassege = "The footballer I is in the team Aytos.";
        Assert.assertEquals(footballTeam.getStatistics(), expectedMassege);
    }

}
