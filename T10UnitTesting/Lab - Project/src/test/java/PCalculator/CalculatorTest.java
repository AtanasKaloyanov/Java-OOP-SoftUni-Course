package PCalculator;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {

    @Test
    public void testSumWithPositiveNumbers() {
        Calculator calculator = new Calculator();
        int sum = calculator.sum(2, 3);
        Assert.assertEquals(5, sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodThrodWhetherMethodThrowAnExceptionThrowsAnException() {
         Calculator calculator = new Calculator();
         calculator.throwAnException();
    }

}