package T03Inheritance.Exercise.P06Animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected abstract String produceSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("\n");
        sb.append(String.format("%s %d %s", this.name, this.age, this.gender)).append("\n");
        sb.append(produceSound());

        return sb.toString().trim();
    }
}
