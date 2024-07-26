package T05Polymorphism.Lab.P03Animals;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 2 animals - a cat and a dog via Polymorphism:
        Animal cat = new Cat("Tom", "Whiskas");
        Animal dog = new Dog("Doggo", "Bratwurst");

        // 2. Printing the messages of the both animals via the method explainSelf():
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
