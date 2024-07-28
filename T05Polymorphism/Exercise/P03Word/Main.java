package T05Polymorphism.Exercise.P03Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Reading a line from the input as a StringBuilder:
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());

        // 2. Creating c Command Interface via Polymorphism. For this goal it is used the
        // static method buildCommandInterface:
        CommandInterface commandInterface = Initialization.buildCommandInterface(text);
        String inputLine = scanner.nextLine();

        // 3. The commands are received via while cycle:
        while(!inputLine.equals("exit")) {
            commandInterface.handleInput(inputLine);
            inputLine = scanner.nextLine();
        }

        System.out.println(text);
    }
}

/*

      Input 1:

         som3. text

        1. cut 1 7     -> removes and saves "om3. t" /  sext
        2. paste 3 4
        3.


 */
