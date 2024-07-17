package T02Encapsulation.Exercise.P01ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading - double length, double width and double height:
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        // 2. Instantiation of class Box and getting the

        Box box = new Box(length, width, height);
        double surface = box.calculateSurfaceArea();
        double lateralSurface = box.calculateLateralSurfaceArea();
        double volume = box.calculateVolume();

        // 3. Output printing:
        System.out.printf("Surface Area - %.2f\n", surface);
        System.out.printf("Lateral Surface Area - %.2f\n", lateralSurface);
        System.out.printf("Volume - %.2f", volume);
    }
}
