package PRpg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private final static int DUMMY_START_HEALTH = 10;
    private final static int DUMMY_EXPERIENCE = 10;
    private final static int ATTACK_POINTS = 5;
    private final static int DEATH_DUMMY_HEALTH = 0;

    private Dummy dummy;
    private Dummy deathDummy;

    @Before
    public void setup() {
        dummy = new Dummy(DUMMY_START_HEALTH, DUMMY_EXPERIENCE);
        deathDummy = new Dummy(DEATH_DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }


    @Test
    public void testTheDummyForLosingHealth() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_START_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackDeadDummy() {
        deathDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesXP() {
        Assert.assertEquals("We expected 10 exp", 10, deathDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveXP() {
        dummy.giveExperience();
    }


}