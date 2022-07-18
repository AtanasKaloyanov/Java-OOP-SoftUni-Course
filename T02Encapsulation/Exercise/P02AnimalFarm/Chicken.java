package T02Encapsulation.Exercise.P02AnimalFarm;

public class Chicken {
    //name: String
    //age: int
    //Chicken(String, int)
    //setName(String) : void
    //setAge (int): void
    //productPerDay (): double
    //toString(): Override
    //calculateProductPerDay() : double

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
       return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggs;
        if (this.age <= 5) {
            eggs = 2;
        } else if (this.age <= 11) {
            eggs = 1;
        } else {
            eggs = 0.75;
        }

        return eggs;
    }


    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, productPerDay());
    }
}
