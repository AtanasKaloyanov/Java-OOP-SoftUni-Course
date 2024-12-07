package T12DesignPatterns.Exercise.Creational.P02Prototype;

public class Cloning implements Cloneable {
    private String name;
    private int age;

    public Cloning(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Cloning clone() throws CloneNotSupportedException {
        return (Cloning) super.clone();
    }
}
