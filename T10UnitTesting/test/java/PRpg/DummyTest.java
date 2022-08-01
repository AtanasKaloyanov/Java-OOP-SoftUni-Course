package PRpg;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class DummyTest {
    @Test
    public void testTheDummyForLosingHealth() {
        Dummy dummy = new Dummy(10, 10);
        dummy.takeAttack(5);
        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackDeadDummy() {
        Dummy dummy = new Dummy(0, 10);
        dummy.takeAttack(100);
    }

    @Test
    public void testDeadDummyGivesXP() {
        Dummy dummy = new Dummy(0, 10);
        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveXP() {
        Dummy dummy = new Dummy(100, 10);
        dummy.giveExperience();
    }




}