package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Astronaut astronaut;
    private Spaceship spaceship;

   @Before()
    public void setUp() {
       astronaut = new Astronaut("I", 90);
       spaceship = new Spaceship("a", 2);
   }

   @Test()
   public void testGetCount(){
       spaceship.add(astronaut);
       Assert.assertEquals(1, spaceship.getCount());

   }

   @Test(expected = IllegalArgumentException.class)
   public void testAddE1(){
       spaceship.add(astronaut);
       Astronaut second = new Astronaut("You", 89);
       spaceship.add(second);
       Astronaut thirdAstronaut = new Astronaut("third", 40);
       spaceship.add(thirdAstronaut);
   }

   @Test()
   public void testAddC(){
       spaceship.add(astronaut);
       Assert.assertEquals(spaceship.getCount(), 1);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAstronautAddE2(){
       Astronaut secondAstrounaut = new Astronaut("I", 20);
       spaceship.add(astronaut);
       spaceship.add(secondAstrounaut);
   }

   @Test()
   public void testRemoveC(){
       spaceship.add(astronaut);
       spaceship.remove("I");
       Assert.assertEquals(0, spaceship.getCount());
   }

   @Test()
   public void testRemoveC2(){
       spaceship.add(astronaut);
       Assert.assertTrue(spaceship.remove("I"));
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetCapacityE(){
       Spaceship spaceship = new Spaceship("a", -1);

   }

   @Test(expected = NullPointerException.class)
   public void testSetNameE1(){
       Spaceship spaceship = new Spaceship(" ", 2);

   }

   @Test(expected = NullPointerException.class)
   public void testSetNameE2(){
       Spaceship spaceship = new Spaceship(null, 2);
   }

   @Test()
   public void getName(){
       spaceship.add(astronaut);
       String name = "a";
       Assert.assertEquals(name, spaceship.getName());
   }

}
