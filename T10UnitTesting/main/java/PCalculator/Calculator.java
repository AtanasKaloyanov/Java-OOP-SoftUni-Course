package PCalculator;

public class Calculator {
    public static void main(String[] args) {

    }
    public int sum(int a, int b) {
        return a + b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public void throwAnException() {
        throw new IllegalArgumentException();
    }
}
