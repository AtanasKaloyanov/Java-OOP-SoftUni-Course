package T02Encapsulation.Exercise.P02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age >= 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double egsPerDay;
        if (this.age < 6) {
            egsPerDay = 2;
        } else if (this.age < 12) {
            egsPerDay = 1;
        } else {
            egsPerDay = 0.75;
        }
        return egsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(), this.getAge(), this.productPerDay());
    }
}

/*

-	name: String
-	age: int
+	Chicken(String, int)
-	setName(String) : void
-	setAge (int): void
+	productPerDay (): double
+	toString(): Override
-	calculateProductPerDay() : double

 */
