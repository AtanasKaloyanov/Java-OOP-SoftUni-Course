package T02Encapsulation.Exercise.P02AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String chickensName = scanner.nextLine();
        int chickensAge = Integer.parseInt(scanner.nextLine());

        Chicken chicken = new Chicken(chickensName, chickensAge);

        System.out.println(chicken);
    }
}
