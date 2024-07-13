package T01WorkingWithAbstraction.Lab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentByName = new HashMap<>();

    public void addStudent(String name, int age, double grade) {
        Student student = new Student(name, age, grade);
        this.studentByName.putIfAbsent(name, student);
    }

    public void printStudent(String name) {
        Student student = this.studentByName.get(name);
        if (student != null) {
            System.out.println(student);
        }
    }
}
