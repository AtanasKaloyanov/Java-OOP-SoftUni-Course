package T01WorkingWithAbstraction.Lab.P03StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getCommentary() {
        String result;
        if (this.grade >= 5.00) {
            result = "Excellent student";
        } else if (this.grade >= 3.50) {
            result = "Average student";
        } else {
            result = "Very nice person";
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" is ")
                .append(this.age).append(" years old. ")
                .append(this.getCommentary()).append(".");
        return sb.toString();
    }
}
