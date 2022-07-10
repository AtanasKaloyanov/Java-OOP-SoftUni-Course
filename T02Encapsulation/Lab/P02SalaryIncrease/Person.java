package T02Encapsulation.Lab.P02SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.age >= 30) {
            this.salary = this.salary + this.salary * bonus / 100;
        } else {
            this.salary = this.salary + this.salary * bonus / 100 / 2;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.#######");
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, df.format(this.salary));
    }
}
