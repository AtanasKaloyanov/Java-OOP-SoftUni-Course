package T03Inheritance.Exercise.P01Person;

public class Child extends Person{
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + "\n" + super.getAge();
    }
}
