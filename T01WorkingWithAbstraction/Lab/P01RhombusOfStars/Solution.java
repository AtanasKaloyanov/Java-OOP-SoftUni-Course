package T01WorkingWithAbstraction.Lab.P01RhombusOfStars;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Printing:
        // 2.1. First half printing:
        topHalfPrinting(n);

        // 2.2. Second half printing:
        downHalfPrinting(n);
    }

    private static void downHalfPrinting(int n) {
        for (int i = n - 1; i >= 1; i--) {
            printRow(n, i);
        }
    }

    private static void topHalfPrinting(int n) {
        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        // Intro Printing
        for (int k = 1; k <= n - i; k++) {
            System.out.print(" ");
        }

        // Star and space printing
        for (int j = 1; j <= i; j++) {
            System.out.print("*" + " ");
        }
        System.out.println();
    }
}

/*
Input 1:
n = 1

Output 1:
*

0scace * space

Input 2:
n = 2

Output 2:

 *
* *
 *

1space * space
* space * space
1space * space


Input 3:
n = 3

Output 3:

  *
 * *
* * *
 * *
  *

2space * space
1space * space * space
0space * space * space * space
1space * space * space
2space * space

Input 4:

n = 4

   *
  * *
 * * *
* * * *
 * * *
  * *
   *

3space * space
2space * space * space
1space * space * space * space
0space * space * space * space * space
1space * space * space * space
2space * space * space
3space * space
 */
