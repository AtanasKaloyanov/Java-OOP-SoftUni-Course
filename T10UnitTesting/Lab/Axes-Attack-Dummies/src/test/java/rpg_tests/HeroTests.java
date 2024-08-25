package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeroTests {
    private Weapon weapon;
    private Weapon brokenWeapon;
    private Weapon lootWeapon1;
    private Weapon lootWeapon2;
    private Target target;
    private Target strongerTarget;
    private Target deadTarget;
    private Hero hero;
    private Hero heroWithBrokenWeapon;

    private static final int AXE_ATTACK = 100;
    private static final int AXE_LOOT_ATTACK_1 = 15;
    private static final int AXE_LOOT_ATTACK_2 = 20;
    private static final int AXE_DURABILITY = 10;
    private static final int AXE_LOOT_DURABILITY_1 = 15;
    private static final int AXE_LOOT_DURABILITY_2 = 20;
    private static final int BROKEN_AXE_DURABILITY = 0;
    private static final String HERO_NAME = "Aegon";
    private static final int DUMMY_HEALTH = 100;
    private static final int STRONGER_DUMMY_HEALTH = 101;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 1000;
    private static final int NUMBER_WEAPONS_AFTER_ATTACK = 2;

    @Before
    public void setUp() {
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.lootWeapon1 = new Axe(AXE_LOOT_ATTACK_1, AXE_LOOT_DURABILITY_1);
        this.lootWeapon2 = new Axe(AXE_LOOT_ATTACK_2, AXE_LOOT_DURABILITY_2);
        this.brokenWeapon = new Axe(AXE_ATTACK, BROKEN_AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.strongerTarget = new Dummy(STRONGER_DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadTarget = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.hero = new Hero(HERO_NAME, this.weapon);
        this.heroWithBrokenWeapon = new Hero(HERO_NAME, this.brokenWeapon);
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
        this.hero.attack(this.strongerTarget);
        int expectedXP = 0;
        int actualXP = this.hero.getExperience();
        Assert.assertEquals(expectedXP, actualXP);
    }

    @Test(expected = IllegalStateException.class)
    public void testHeroAttackWithBrokenWeapon() {
        this.heroWithBrokenWeapon.attack(this.target);
    }

    @Test(expected = IllegalStateException.class)
    public void testHeroAttacksDeadDummyAndThrows() {
        this.hero.attack(this.deadTarget);
    }

    @Test
    public void testHeroDestroysTargetGetLoot() {
        // 1. check before attack:
        int expectedLootWeapons = 0;
        int realLootWeapons = this.hero.getLootWeapons().size();
        Assert.assertEquals(expectedLootWeapons, realLootWeapons);

        // 2. Adding loot weapons to the target and attack:
        List<Weapon> lootWeapons = new ArrayList<>(
                List.of(this.lootWeapon1, this.lootWeapon2));
        this.target.addWeapons(lootWeapons);
        this.hero.attack(this.target);

        // 3. Check after attack:
        int realLootWeaponsAfterAttack = this.hero.getLootWeapons().size();
        Assert.assertEquals(NUMBER_WEAPONS_AFTER_ATTACK, realLootWeaponsAfterAttack);

        // 4. Iterable check:
        List<Weapon> addedWeaponsByIterable = new ArrayList<>();
        Iterator<Weapon> weaponsIterator =  this.hero.getInventory().iterator();

        while (weaponsIterator.hasNext()) {
            Weapon currentWeapon = weaponsIterator.next();
            addedWeaponsByIterable.add(currentWeapon);
        }

        Assert.assertEquals(lootWeapons, addedWeaponsByIterable);
    }

}
