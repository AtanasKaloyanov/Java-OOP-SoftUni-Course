package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GarageTests {
    private Car car;
    private Garage garage;

    @Before
    public void setUp() {
         this.car = new Car("Audi", 1, 2.0);
         this.garage = new Garage();
    }

    @Test
    public void testMethodGetCount() {
        garage.addCar(car);
        Assert.assertEquals(1, this.garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWithNULL() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarWithCorrectValue() {
        garage.addCar(car);
        Assert.assertEquals("Audi", this.car.getBrand());
    }

    @Test
    public void testGetCountMethod() {
        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car expectedCar = new Car("BMW", 1, 3);
        Car anotherCar = new Car("BMW", 1, 2);
        garage.addCar(expectedCar);
        garage.addCar(anotherCar);

        Assert.assertEquals(expectedCar, this.garage.getTheMostExpensiveCar());
    }

    @Test
    public void testGetTheMostExpensiveCarForNullReturn() {
        Assert.assertNull(this.garage.getTheMostExpensiveCar());
    }



    @Test
    public void testFindAllCarsByBrand() {
        Car expectedCar = new Car("BMW", 1, 3);
        Car expectedCar2 = new Car("BMW", 2, 3);
        garage.addCar(expectedCar);
        garage.addCar(expectedCar2);

        List<Car> expectedList = new ArrayList<>(Arrays.asList(expectedCar, expectedCar2));
        Assert.assertEquals(expectedList, garage.findAllCarsByBrand("BMW"));
    }

    @Test
    public void testFindCarWithMaxSpeed() {
        Car expectedCar = new Car("BMW", 3, 2);
        Car expectedCar2 = new Car("BMW", 4, 2);
        garage.addCar(expectedCar);
        garage.addCar(expectedCar2);

        List<Car> expectedList = new ArrayList<>(Arrays.asList(expectedCar, expectedCar2));

        Assert.assertEquals(expectedList, garage.findAllCarsWithMaxSpeedAbove(2));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsMethodForExceptionByModification() {
        Car anotherCar = new Car("BMW", 1, 2);
        garage.addCar(anotherCar);

        garage.getCars().remove(anotherCar);
    }

}