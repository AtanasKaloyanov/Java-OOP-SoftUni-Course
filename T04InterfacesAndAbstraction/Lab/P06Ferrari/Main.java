package T04InterfacesAndAbstraction.Lab.P06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driversName = scanner.nextLine();

        Ferrari ferrari = new Ferrari(driversName);
        System.out.println(ferrari);
    }
}
