package T04InterfacesAndAbstraction.Exercise.P04FootShortage;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
}