package T04InterfacesAndAbstraction.Lab.P06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading, Ferrari object creating and printing:
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        Ferrari ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
