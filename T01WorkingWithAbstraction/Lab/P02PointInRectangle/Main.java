package T01WorkingWithAbstraction.Lab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bottomLeffX = array[0];
        int bottomLeffY = array[1];

        Point bottomLeft = new Point(bottomLeffX, bottomLeffY);

        int topRightX = array[2];
        int topRightY = array[3];

        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {
            int[] givenCordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xCodinate = givenCordinates[0];
            int yCordinate = givenCordinates[1];

            Point currentPoint = new Point(xCodinate, yCordinate);

            System.out.println(rectangle.contains(currentPoint));
        }
    }
}
