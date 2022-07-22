package T04InterfacesAndAbstraction.Lab.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();

        Goat goat = new Goat();
        Koala koala = new Koala();
        Lion lion = new Lion();

        animalList.add(goat);
        animalList.add(koala);
        animalList.add(lion);

        for (Animal animal : animalList) {
            System.out.println(animal.getFood());
        }
    }
}
