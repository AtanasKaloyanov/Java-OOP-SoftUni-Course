package T08ExceptionAndErrorHandling;

import java.util.*;

public class P03EnterNumbers {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque();

        int startNumber = 1;
        int endNumber = 100;

        while (stack.size() != 10) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number > startNumber && number < endNumber) {
                    if (stack.isEmpty()) {
                        stack.push(number);
                    } else {
                        if (number > stack.peek()) {
                            stack.push(number);
                        } else {
                            System.out.printf("Your number is not in range %d - 100!%n", stack.peek());
                        }
                    }
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("Your number is not in range 1 - 100!");
                    } else {
                        System.out.printf("Your number is not in range %d - 100!%n", stack.peek());
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid Number!");
            }

            if (!stack.isEmpty()) {
                startNumber = stack.peek();
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        Collections.reverse(list);
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}

