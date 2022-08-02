package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public Database database;

    private static final Integer[] NUMBERS = {7, 45, 34, 12, 98, 23};
    private static final int MORE_THAN_16_ELEMENTS = 17;
    private static final int LESS_THAN_1_ELEMENT = 0;
    private static final int NUMBER_FOR_ADDING = 67;
    private static final int LAST_ELEMENT = 98;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Integer[] elements = database.getElements();
        Assert.assertArrayEquals(elements, NUMBERS);

//        Assert.assertEquals(elements.length, NUMBERS.length);
//        for (int i = 0; i < elements.length; i++) {
//            Assert.assertEquals(elements[i], NUMBERS[i]);
//        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[MORE_THAN_16_ELEMENTS];
        database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[LESS_THAN_1_ELEMENT];
        database = new Database(numbers);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(67);
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length + 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(NUMBER_FOR_ADDING));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNewParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length - 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(LAST_ELEMENT));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowEmptyDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }

        database.remove();
    }

}