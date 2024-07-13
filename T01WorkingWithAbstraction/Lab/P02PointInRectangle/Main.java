package T01WorkingWithAbstraction.Lab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Points of the rectangle reading and creating a rectangle
        // via them:
        Scanner scanner = new Scanner(System.in);
        int[] array = readArray(scanner);
        int xMin = array[0];
        int yMin = array[1];
        int xMax = array[2];
        int yMax = array[3];
        Rectangle rect = new Rectangle(xMin, yMin, xMax, yMax);

        // 2. Number n reading, then, n points creating via for cycle
        // and checking via the method contains if the current point is in the
        // rectangle:
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] coordinates = readArray(scanner);
            int xCoord = coordinates[0];
            int yCoord = coordinates[1];
            Point point = new Point(xCoord, yCoord);
            boolean isInTheRect = rect.contains(point);
            System.out.println(isInTheRect);
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
