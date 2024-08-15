package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    // axe's fields
    private final static int INITIAL_ATTACK_POINTS = 10;
    private final static int INITIAL_DURABILITY_POINTS = 50;
    // dummy's fields
    private final static int INITIAL_HEALTH = 100;
    private final static int INITIAL_EXPERIENCE = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void settings() {
        this.axe = new Axe(INITIAL_ATTACK_POINTS, INITIAL_DURABILITY_POINTS);
        this.dummy = new Dummy(INITIAL_HEALTH, INITIAL_EXPERIENCE);
    }

    @Test
    public void testLosesOfDurabilityAfterAttack() {
        int expectedDurabilityAfterAttack = 49;
        for (int i = 1; i <= 10; i++) {
            this.axe.attack(this.dummy);
            int realDurabilityPoints = this.axe.getDurabilityPoints();
            Assert.assertEquals(realDurabilityPoints, expectedDurabilityAfterAttack);
            expectedDurabilityAfterAttack--;
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenWeaponShouldThrowIllegalEx() {
        for (int i = 1; i <= 11; i++) {
            this.axe.attack(this.dummy);
        }
    }

}
