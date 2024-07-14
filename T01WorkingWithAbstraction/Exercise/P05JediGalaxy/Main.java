package T01WorkingWithAbstraction.Exercise.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Matrix dimensions reading:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] dimensions = readIntArray(line);
        int matrixRow = dimensions[0];
        int matrixColumn = dimensions[1];

        // 2. Matrix Filling:
        int[][] matrix = new int[matrixRow][matrixColumn];
        fillMatrix(matrixRow, matrixColumn, matrix);

        // 3. While cycle alg:
        long sum = 0;
        line = scanner.nextLine();
        while (!line.equals("Let the Force be with you")) {
            // 3.1. Reading the hero and the villain coordinates
            int[] heroCoord = readIntArray(line);
            line = scanner.nextLine();
            int[] villainCoord = readIntArray(line);


            // 3.2. Giving every element which the villain reaches value 0:
            int villainRow = villainCoord[0];
            int villainColumn = villainCoord[1];
            while (villainRow >= 0 && villainColumn >= 0) {
                if (villainRow < matrixRow && villainColumn < matrixColumn) {
                    matrix[villainRow][villainColumn] = 0;
                }
                villainRow--;
                villainColumn--;
            }

            // 3.3. Adding every element which the hero reaches:
            int heroRow = heroCoord[0];
            int heroColumn = heroCoord[1];
            while (heroRow >= 0 && heroColumn < matrixColumn) {
                if (heroRow < matrixRow && heroColumn >= 0) {
                    int currentNumber = matrix[heroRow][heroColumn];
                    sum += currentNumber;
                }

                heroRow--;
                heroColumn++;
            }

            line = scanner.nextLine();
        }

        // 4. Sum printing:
        System.out.println(sum);
    }

    private static void fillMatrix(int matrixRow, int matrixColumn, int[][] matrix) {
        int number = 0;
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixColumn; j++) {
                matrix[i][j] = number;
                number++;
            }
        }
    }

    private static int[] readIntArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

/*

List<Integer> collectedNumbers
hero finalNumbers = hero diagonalNumbers - the section (hero diagonalNumbers, villain diagonalNumbers)

Input 1:

5 5
5 -1
5 5

           0  1  2  3  4

      0    0  1  2  3  4
      1    5  6  7  8  9
      2   10 11 12 13 14
      3   15 16 17 18 19
      4   20 21 22 23 24

   hero start    - 4 0 => hero diagonal numbers -    20, 16, 12, 8, 4
   villain start - 4 4 => villian diagonal numbers - 24, 18, 12, 6, 0

   The heroes number minus the section of the both lists = 20, 16, 8, 4

Output 1: 48


Input 2:

5 5
4 -1
4 5

   hero start    - 3 0 => hero diagonal numbers -    15, 11, 9, 3
   villain start - 3 4 => villian diagonal numbers - 19, 12, 9, 1

  The heroes number minus the section of the both sets = 15, 11, 3

Output 2: 29


5 5
4 -1
4 5
2 2
3 3
Let the Force be with you

 */
