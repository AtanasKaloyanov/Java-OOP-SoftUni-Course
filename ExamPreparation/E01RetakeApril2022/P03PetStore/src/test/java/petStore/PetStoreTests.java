package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetStoreTests {

    private Animal animal;
    private PetStore petStore;

    @Before
    public void setUp() {
        animal = new Animal("Bulldog", 25, 100);
        petStore = new PetStore();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsForUnsupported() {
        petStore.addAnimal(animal);
        petStore.getAnimals().remove(animal);
    }

    @Test
    public void testGetCount() {
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalMaxKg() {
        petStore.addAnimal(animal);
        Animal secondAnimal = new Animal("German", 80, 1000);
        petStore.addAnimal(secondAnimal);

        List<Animal> list = new ArrayList<>(Arrays.asList(animal, secondAnimal));
        Assert.assertEquals(list, petStore.findAllAnimalsWithMaxKilograms(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalForIllArgException() {
        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimalCorrectNess() {
        petStore.addAnimal(animal);

        Assert.assertEquals(animal.getSpecie(), "Bulldog");
    }

    @Test
    public void testGetMostExpensiveAnimalForNull() {
        Animal expectedNull = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(expectedNull);
    }

    @Test
    public void testGetMostExpensiveAnimalCorrectness() {
        petStore.addAnimal(animal);
        Animal secondAnimal = new Animal("German", 80, 1000);
        petStore.addAnimal(secondAnimal);

        Assert.assertEquals(secondAnimal, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecies() {
        petStore.addAnimal(animal);
        Animal secondAnimal = new Animal("Bulldog", 80, 1000);
        petStore.addAnimal(secondAnimal);

        List<Animal> list = new ArrayList<>(Arrays.asList(animal, secondAnimal));
        Assert.assertEquals(list, petStore.findAllAnimalBySpecie("Bulldog"));
    }


}

