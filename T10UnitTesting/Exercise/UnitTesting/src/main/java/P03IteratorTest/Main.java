package P03IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        //1. Read the first line:
        Scanner scanner = new Scanner(System.in);
        String[] firstLineInfo = scanner.nextLine().split(" ");

        // 2. Fill array:
        String[] names =  fillArrayWithNames(firstLineInfo);

        // 3. An attempt of listIterator object creation with try / catch
        ListIterator listIterator = new ListIterator(names);

        // 4. Commands implementation:
        String currentCommand = scanner.nextLine();

        while (!currentCommand.equals("END")) {
            String lineResult = null;
            switch (currentCommand) {
                case "Move":
                    lineResult = String.valueOf(listIterator.move());
                    break;

                case "Print":
                    try {
                        lineResult = listIterator.print();
                    } catch (IllegalStateException illegalStateException) {
                        lineResult = illegalStateException.getMessage();
                    }
                    break;

                case "HasNext":
                    lineResult = String.valueOf(listIterator.hasNext());
                    break;
            }

            System.out.println(lineResult);
            currentCommand = scanner.nextLine();
        }

    }

    private static String[] fillArrayWithNames(String[] firstLineInfo) {
        int namesLength = firstLineInfo.length - 1;
        String[] names = new String[namesLength];

        for (int i = 1; i < firstLineInfo.length; i++) {
            String currentName = firstLineInfo[i];
            names[i - 1] = currentName;
        }
        return names;
    }
}
