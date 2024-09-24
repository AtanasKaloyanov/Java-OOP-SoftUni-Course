package P04BubbleSortTest;

public class Bubble {
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i < n - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}

/*

// 1. int array = {6, 10, 5, 4, 3}
      int length = 5
      outer cycle from 0 to 4     (non-inclusive). The current variable - k
      inner cycle from 0 to 4 - k (non-inclusive). The current variable - i

      1. k = 0, i = 0 -> until 4 (non inclusive) (4 - 0 = 4)
         {6, 10, 5, 4, 3}
         6 < 10 => iteration

      2. k = 0, i = 1 -> until (non-inclusive) (4 - 0 = 4)
         {6, 10, 5, 4, 3}
         10 > 5 => change
         {6, 5, 10, 4, 3}
         iteration

       3. k = 0, i = 2 -> until (non-inclusive) (4 - 0 = 4)
          {6, 5, 10, 4, 3}
          10 > 4 => change
          {6, 5, 4, 10, 3}
          iteration

       4. k = 0, i = 3 -> until (non-inclusive) (4 - 0 = 4)
          {6, 5, 4, 10, 3}
          10 > 3 => change
          {6, 5, 4, 3, 10}
          iteration

          {6, 5, 4, 3, 10}
          {5, 4, 3, 6, 10}
          {4, 3, 5, 6, 10}
          {3, 4, 5, 6, 10}


*/