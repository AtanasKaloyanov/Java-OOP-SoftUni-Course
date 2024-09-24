package P04BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    // Arrays for testing:
    private int[] array1 = {1, 2, 3, 4, 5};
    private int[] array2 = {1, 8, 8, 8};
    private int[] array3 = {8, 8, 8, 1};
    private int[] array4 = {2, 1, 3, 4, 5};
    private int[] array5 = {1, 2, 3, 5, 4};
    private int[] array6 = {1, 2, 8, 8, 1};

    // Constants - Sorted arrays:
    private final int[] array1Expected = {1, 2, 3, 4, 5};
    private final int[] array2Expected = {1, 8, 8, 8};
    private final int[] array3Expected = {1, 8, 8, 8};
    private final int[] array4Expected = {1, 2, 3, 4, 5};
    private final int[] array5Expected = {1, 2, 3, 4, 5};
    private final int[] array6Expected = {1, 1, 2, 8, 8};


    @Test
    public void testBubbleSortArray1() {
        Bubble.sort(this.array1);
        Assert.assertArrayEquals(this.array1Expected, this.array1);
    }

    @Test
    public void testBubbleSortArray2() {
        Bubble.sort(this.array2);
        Assert.assertArrayEquals(this.array2Expected, this.array2);
    }

    @Test
    public void testBubbleSortArray3() {
        Bubble.sort(this.array3);
        Assert.assertArrayEquals(this.array3Expected, this.array3);
    }

    @Test
    public void testBubbleSortArray4() {
        Bubble.sort(this.array4);
        Assert.assertArrayEquals(this.array4Expected, this.array4);
    }

    @Test
    public void testBubbleSortArray5() {
        Bubble.sort(this.array5);
        Assert.assertArrayEquals(this.array5Expected, this.array5);
    }

    @Test
    public void testBubbleSortArray6() {
        Bubble.sort(this.array6);
        Assert.assertArrayEquals(this.array6Expected, this.array6);
    }
}
