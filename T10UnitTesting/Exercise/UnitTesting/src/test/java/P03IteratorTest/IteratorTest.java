package P03IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorTest {
    private ListIterator listIterator;
    private ListIterator emptyIterator;

    private static final String[] elements = {"a", "b", "c", "d"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(elements);
        this.emptyIterator = new ListIterator();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorReceiveNullParam() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test
    public void testIterationAndPrintingEveryElement() {
        String actualFirstElement = this.listIterator.print();
        String expectedFirstElement = elements[0];
        Assert.assertEquals(expectedFirstElement, actualFirstElement);

        for (int i = 1; i < elements.length; i++) {
            boolean expectedResult = this.listIterator.move();
            Assert.assertTrue(expectedResult);
            String expectedCurrentElement = elements[i];
            String actualCurrentElement = this.listIterator.print();
            Assert.assertEquals(expectedCurrentElement, actualCurrentElement);
        }
    }

    @Test
    public void testMoveMethodWhenEveryElementIsIterated() {
        testIterationAndPrintingEveryElement();
        boolean actualResult = this.listIterator.move();
        Assert.assertFalse(actualResult);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintMethodShouldThrowExcByZeroElements() throws OperationNotSupportedException {
        this.emptyIterator.print();
    }

}
