package P05CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedListTests {
    private CustomLinkedList<Integer> linkedList;
    private List<Integer> numbers;

    // Constants:
    private static final int FIRST_NUMBER = 3;
    private static final int SECOND_NUMBER = 5;
    private static final int THIRD_NUMBER = 6;
    private static final int FOURTH_NUMBER = 8;
    private static final int SET_INDEX = 2;
    private static final int SET_NUMBER = 4;
    private static final int NON_EXISTED_NUMBER = 100;
    private static final int SECOND_INDEX = 2;

    @Before
    public void setUp() {
        this.linkedList = new CustomLinkedList<>();
        this.numbers = new ArrayList<>(List.of(
                FIRST_NUMBER, SECOND_NUMBER, THIRD_NUMBER, FOURTH_NUMBER));
    }

    // 0. This is not test rather a repeatable logic:
    private void testEveryElementAfterFunction() {
        int numbersSize = this.numbers.size();
        for (int i = 0; i < numbersSize; i++) {
            int expectedCurrentElement = this.numbers.get(i);
            int actualCurrentElement = this.linkedList.get(i);
            Assert.assertEquals(expectedCurrentElement, actualCurrentElement);
        }
    }

    // 1. Add method:
    @Test
    public void testAddMethodCorrectness() {
        for (int i = 0; i < this.numbers.size(); i++) {
            int expectedAddingNumber = this.numbers.get(i);
            this.linkedList.add(expectedAddingNumber);
            int actualAddedNumber = this.linkedList.get(i);
            Assert.assertEquals(expectedAddingNumber, actualAddedNumber);
        }
    }

    // 2. Get method:
    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodWithNegativeArgumentShouldThrow() {
        testAddMethodCorrectness();
        this.linkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodWIthNumbersLengthArgumentShouldThrow() {
        testAddMethodCorrectness();
        int numbersLength = this.numbers.size();
        this.linkedList.get(numbersLength);
    }

    // 3. Set method:
    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodWithNegativeArgumentShouldThrow() {
        testAddMethodCorrectness();
        this.linkedList.set(-1, FIRST_NUMBER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodWIthNumbersLengthArgumentShouldThrow() {
        testAddMethodCorrectness();
        int numbersLength = this.numbers.size();
        this.linkedList.set(numbersLength, FIRST_NUMBER);
    }

    @Test
    public void testSetMethodCorrectValue() {
        testAddMethodCorrectness();
        this.numbers.set(SET_INDEX, SET_NUMBER);
        this.linkedList.set(SET_INDEX, SET_NUMBER);
        for (int i = 0; i < this.numbers.size(); i++) {
            int expectedAddingNumber = this.numbers.get(i);
            int actualAddedNumber = this.linkedList.get(i);
            Assert.assertEquals(expectedAddingNumber, actualAddedNumber);
        }
    }

    // 4. Index Of:
    @Test
    public void testIndexOfCorrectness() {
        testAddMethodCorrectness();
        int numbersSize = this.numbers.size();
        for (int i = 0; i < numbersSize; i++) {
            int actualCurrentNumber = this.numbers.get(i);
            int actualCurrentIndex = this.linkedList.indexOf(actualCurrentNumber);
            Assert.assertEquals(i, actualCurrentIndex);
        }
    }

    @Test
    public void testIndexOfWithNonExistentNumber() {
        testAddMethodCorrectness();
        int expectedIndex = -1;
        int actualIndex = this.linkedList.indexOf(NON_EXISTED_NUMBER);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    // 5. Contains
    @Test
    public void testContainsWithNonExistentElement() {
        testAddMethodCorrectness();
        boolean expectedCondition = this.linkedList.contains(NON_EXISTED_NUMBER);
        Assert.assertFalse(expectedCondition);
    }

    @Test
    public void testContainsWithExistentElement() {
        testAddMethodCorrectness();
        boolean expectedCondition = this.linkedList.contains(FIRST_NUMBER);
        Assert.assertTrue(expectedCondition);
    }

    // 6. Remove
    @Test
    public void testRemoveExistentElement() {
        testAddMethodCorrectness();
        int expectedResult = 2;
        int actualResult = this.linkedList.remove(THIRD_NUMBER);
        this.numbers.remove(expectedResult);
        Assert.assertEquals(expectedResult, actualResult);

        testEveryElementAfterFunction();
    }

    @Test
    public void testRemoveNonExistentElement() {
        testAddMethodCorrectness();
        int expectedResult = -1;
        int actualResult = this.linkedList.remove(NON_EXISTED_NUMBER);
        Assert.assertEquals(expectedResult, actualResult);

        testEveryElementAfterFunction();
    }

    // 7. RemoveAt
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtMethodWithNegativeArgumentShouldThrow() {
        testAddMethodCorrectness();
        this.linkedList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtMethodWIthNumbersLengthArgumentShouldThrow() {
        testAddMethodCorrectness();
        int numbersSize = this.numbers.size();
        this.linkedList.removeAt(numbersSize);
    }

    @Test
    public void testRemoveAtMethodWithExistentElement() {
        testAddMethodCorrectness();
        int expectedRemovedIndex = this.numbers.remove(SECOND_INDEX);
        int actualRemovedIndex = this.linkedList.removeAt(SECOND_INDEX);
        Assert.assertEquals(expectedRemovedIndex, actualRemovedIndex);
        testEveryElementAfterFunction();
    }

}
