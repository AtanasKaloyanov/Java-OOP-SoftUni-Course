package Example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Creature person1 = new Person("A", 10);
        Creature person2 = new Person("B", 20);
        Creature person3 = new Person("C", 30);
        Set<Creature> peopleSet = new HashSet<>(Set.of(person1, person2, person3));

        System.out.println(peopleSet);
        peopleSet.remove(person1);
        System.out.println(peopleSet);
        peopleSet.remove(person2);
        System.out.println(peopleSet);
    }
}
