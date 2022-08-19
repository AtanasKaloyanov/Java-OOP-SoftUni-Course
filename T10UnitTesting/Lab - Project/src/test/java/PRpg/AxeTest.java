package PRpg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AxeTest {
    private final static int AXE_ATTACK_POINTS = 10;
    private final static int AXE_DURABILITY_POINTS = 10;
    private final static int BROKEN_AXE_DURABILITY_POINTS = 0;
    private final static int DECREASING_DURABILITY_BY_EVERY_ATTACK = 1;

    private final static int DUMMY_HEALTH = 10;
    private final static int DUMMY_EXPERIENCE = 10;


    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setup() {
        axe = new Axe(AXE_ATTACK_POINTS, AXE_DURABILITY_POINTS);
        brokenAxe = new Axe(AXE_ATTACK_POINTS, BROKEN_AXE_DURABILITY_POINTS);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY_POINTS - DECREASING_DURABILITY_BY_EVERY_ATTACK, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrowException() {
        Dummy dummy = new Dummy(10, 10);

        brokenAxe.attack(dummy);
    }

}