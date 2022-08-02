package PRpg;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private final static int Target_EXP = 10;



    @Test
    public void testHeroGainsXPWhenTargetDies() {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targertMock = Mockito.mock(Target.class);

        Mockito.when(targertMock.isDead()).thenReturn(true);
        Mockito.when(targertMock.giveExperience()).thenReturn(Target_EXP);

        Hero hero = new Hero("Ragnar", weaponMock);
        hero.attack(targertMock);

        Assert.assertEquals(Target_EXP, hero.getExperience());


    }
}