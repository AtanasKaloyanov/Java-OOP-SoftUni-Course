package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private Hero hero;
    private HeroRepository repository;


    @Before()
    public void setUp(){
        hero = new Hero("I", 10);
        repository = new HeroRepository();
    }

    @Test()
    public void testGetCount() {
        repository.create(hero);
        Assert.assertEquals(1, repository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExc() {
        Hero hero = null;
        repository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExc2() {
        Hero secondHero = new Hero("I", 9);
        repository.create(hero);
        repository.create(secondHero);


    }@Test()
    public void testCreateCorrectness() {
        repository.create(hero);
        Assert.assertEquals(1, repository.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveForExc() {
        repository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveForExc2() {
        repository.remove(" ");
    }

    @Test()
    public void testRemoveCorrectness() {
        repository.create(hero);
        boolean isTrue = repository.remove("I");
        Assert.assertTrue(isTrue);

        boolean isFalse = repository.remove("You");
        Assert.assertFalse(isFalse);

    }

    @Test()
    public void testGetHeroWithHLevele() {
        Hero secondHero = new Hero("You", 9);
        repository.create(hero);
        repository.create(secondHero);

        Hero expectedHero = repository.getHeroWithHighestLevel();
        Assert.assertEquals(expectedHero, hero);
    }
    @Test()
    public void testGNull() {
        Hero expectedHero = repository.getHeroWithHighestLevel();
        Assert.assertNull(expectedHero);
    }

    @Test()
    public void testGetHeroNull() {
        Hero expectedHero = repository.getHero("You");
        Assert.assertNull(expectedHero);
    }

    @Test()
    public void testGetHeroCorrectness() {
        repository.create(hero);
        Hero expectedHero = repository.getHero("I");
        Assert.assertEquals(hero, expectedHero);
    }

}
