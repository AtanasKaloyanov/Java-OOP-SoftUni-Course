package T12DesignPatterns.Exercise.Creational.P02Prototype;

public class Main {
    private static final String NAME = "Dolly";
    private static final int AGE = 10;

    public static void main(String[] args) {
        try {
            // 1. Creating 2 objects - by the first using a constructor
            // and by the second an overridden clone method:
            Cloning prototype = new Cloning(NAME, AGE);
            Cloning cloning = prototype.clone();
            // 2. Checking the fields
            String cloningName = cloning.getName();
            int cloningAge = cloning.getAge();
            System.out.println(cloningName + "-" + cloningAge);
            System.out.println(prototype.equals(cloning));
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println(cloneNotSupportedException.getMessage());
        }
    }
}
