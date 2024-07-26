package T05Polymorphism.Lab.P01MathOperation;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an object of type MathOperation and initializing 3 variables
        // using its different add methods:
        MathOperation mathOperation = new MathOperation();
        int result1 = mathOperation.add(1, 2);
        int result2 = mathOperation.add(1, 2, 3);
        int result3 = mathOperation.add(1, 2, 3, 4);

        // 2. Results printing:
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
