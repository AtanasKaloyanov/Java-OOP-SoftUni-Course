package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.*;

public class HeroTests {
    private Weapon weapon;
    private Weapon broken_weapon;
    private Target target;
    private Target stronger_target;
    private Target deadTarget;
    private Hero hero;
    private Hero hero_with_broken_weapon;

    private static final int AXE_ATTACK = 100;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 0;
    private static final String HERO_NAME = "Aegon";
    private static final int DUMMY_HEALTH = 100;
    private static final int STRONGER_DUMMY_HEALTH = 101;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 1000;


    @Before
    public void setUp() {
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.broken_weapon = new Axe(AXE_ATTACK, BROKEN_AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.stronger_target = new Dummy(STRONGER_DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadTarget = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.hero = new Hero(HERO_NAME, this.weapon);
        this.hero_with_broken_weapon = new Hero(HERO_NAME, this.broken_weapon);
    }

    @Test
    public void testHeroDestroysTargetAndGainsXP() {
        int expectedXPBefAttack = 0;
        int actualXPBeforeAttack = this.hero.getExperience();
        Assert.assertEquals(expectedXPBefAttack, actualXPBeforeAttack);

        this.hero.attack(this.target);
        int expectedXPAfterAttack = this.target.giveExperience();
        int actualXPAfterAttack = this.hero.getExperience();
        Assert.assertEquals(expectedXPAfterAttack, actualXPAfterAttack);
    }

    @Test
    public void testHeroCantDestroyDummyAndDontBecomeXP() {
        this.hero.attack(this.stronger_target);
        int expectedXP = 0;
        int actualXP = this.hero.getExperience();
        Assert.assertEquals(expectedXP, actualXP);
    }

    @Test(expected = IllegalStateException.class)
    public void testHeroAttackWithBrokenWeapon() {
        this.hero_with_broken_weapon.attack(this.target);
    }

    @Test(expected = IllegalStateException.class)
    public void testHeroAttacksDeadDummyAndThrows() {
        this.hero.attack(this.deadTarget);
    }

}
