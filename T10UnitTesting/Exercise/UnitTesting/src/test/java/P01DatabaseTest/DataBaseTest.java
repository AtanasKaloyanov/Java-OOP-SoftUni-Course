package P01DatabaseTest;

import P01Database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTest {
    private Database database;

    private static final Integer[] EMPTY_ARRAY = new Integer[0];
    private static final Integer[] NUMBERS_FROM_1_TO_17 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final Integer[] NUMBERS_FROM_1_TO_5 = {1, 2, 3, 4, 5};
    private static final Integer[] ELEMENTS_FOR_ADDING = {6, 7, 8};
    private static final Integer[] ADDING_POSITIONS = {5, 6, 7};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS_FROM_1_TO_5);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseWithoutNumbers() throws OperationNotSupportedException {
        this.database = new Database(EMPTY_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseWithMoreThan16Numbers() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS_FROM_1_TO_17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddingAtNextCell() throws OperationNotSupportedException {
        for (int i = 0; i < ELEMENTS_FOR_ADDING.length; i++) {
            int currentElementsForAdding = ELEMENTS_FOR_ADDING[i];
            this.database.add(currentElementsForAdding);
            int expectedAddingPosition = this.database.getElements().length - 1;
            int realAddingPosition = ADDING_POSITIONS[i];
            Assert.assertEquals(expectedAddingPosition, realAddingPosition);
        }
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        int elementsSize = this.database.getElements().length;
        for (int i = 0; i < elementsSize; i++) {
            List<Integer> expectedNumbers = new ArrayList<>();
            Integer[] elements = this.database.getElements();

            for (int j = 0; j < elements.length - 1; j++) {
                int currentNumber = elements[j];
                expectedNumbers.add(currentNumber);
            }

            this.database.remove();
            List<Integer> realNumbers = new ArrayList<>(List.of(this.database.getElements()));
            Assert.assertEquals(expectedNumbers, realNumbers);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        testRemoveElement();
        this.database.remove();
    }

    @Test
    public void testConstructorSafeTheNumberInArray() throws OperationNotSupportedException {
        Integer[] realNumbers = this.database.getElements();
         for (int i = 0; i < realNumbers.length; i++) {
             Integer currentExpectedNumber = NUMBERS_FROM_1_TO_5[i];
             Integer currentRealNumber = realNumbers[i];
             Assert.assertEquals(currentExpectedNumber, currentRealNumber);
         }
     }


}
