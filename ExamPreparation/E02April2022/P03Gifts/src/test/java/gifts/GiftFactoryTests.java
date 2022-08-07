package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GiftFactoryTests {
    private Gift gift;
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        gift = new Gift("abra", 5);
        giftFactory = new GiftFactory();
    }

    @Test
    public void testGetCount() {
        giftFactory.createGift(gift);

        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftForException() {
        Gift secondGift = new Gift("abra", 2);
        giftFactory.createGift(gift);
        giftFactory.createGift(secondGift);

    }

    @Test
    public void testCreateGiftForCorrectness() {
     //   String expectedMessage = "Successfully added gift abra with magic 5,00.";
        giftFactory.createGift(gift);
        Assert.assertEquals(gift.getType(), "abra");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveMethodNull() {
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveMethodEmpty() {
        giftFactory.removeGift(" ");
    }

    @Test()
    public void testRemoveMethodCorrectTrue() {
        giftFactory.createGift(gift);

        Assert.assertTrue(giftFactory.removeGift("abra"));
    }

    @Test()
    public void testRemoveMethodCorrectFalse() {
        giftFactory.createGift(gift);

        Assert.assertFalse(giftFactory.removeGift("cadabra"));
    }

    @Test()
    public void testGetPresentWithLeastMagic() {
        Gift secondGift = new Gift("cadabra", 1);
        giftFactory.createGift(gift);
        giftFactory.createGift(secondGift);

        Assert.assertEquals(secondGift, giftFactory.getPresentWithLeastMagic());
    }

    @Test()
    public void testGetPresentWithLeastMagicForNull() {
        Assert.assertNull(giftFactory.getPresentWithLeastMagic());
    }

    @Test()
    public void testGetPresentForCorrectness() {
        giftFactory.createGift(gift);
        Assert.assertEquals(gift, giftFactory.getPresent("abra"));
    }

    @Test()
    public void testGetPresentForNull() {
        giftFactory.createGift(gift);
        Assert.assertNull(giftFactory.getPresent("cadabra"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPresentsForException() {
        giftFactory.createGift(gift);
        giftFactory.getPresents().remove(gift);
    }

}
