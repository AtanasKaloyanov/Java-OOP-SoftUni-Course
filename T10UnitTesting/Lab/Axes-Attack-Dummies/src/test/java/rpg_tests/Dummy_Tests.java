package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class Dummy_Tests {
    private static final int INITIAL_HEALTH = 100;
    private static final int INITIAL_EXPERIENCE = 1000;
    private static final int TAKEN_DAMAGE = 10;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(INITIAL_HEALTH, INITIAL_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthAfterAttack() {
        int expectedHealthAfterAttack = INITIAL_HEALTH;
        for (int i = 0; i < 10; i++) {
            expectedHealthAfterAttack -= TAKEN_DAMAGE;
            this.dummy.takeAttack(TAKEN_DAMAGE);
            int realHealthAfterAttack = this.dummy.getHealth();
            Assert.assertEquals(expectedHealthAfterAttack, realHealthAfterAttack);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyShouldThrowIllegalStateExc() {
        for (int i = 0; i < 11; i++) {
            this.dummy.takeAttack(TAKEN_DAMAGE);
        }
    }

    @Test
    public void testDeadDummyGiveXP() {
        testDummyLosesHealthAfterAttack();
        int realXP = this.dummy.giveExperience();
        Assert.assertEquals(INITIAL_EXPERIENCE, realXP);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyShouldThrowsIllegalStateExc() {
        this.dummy.giveExperience();
    }
}
