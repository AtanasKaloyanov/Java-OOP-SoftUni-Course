package T08ExceptionAndErrorHandling;

public class P04Fixing {
    public static void main(String[] args) {
        // 1. Array filling:
        String[] weekdays = new String[7];
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";
        weekdays[5] = "Saturday";
        weekdays[6] = "Sunday";

        // 2. Try-catch-finally construction:
        for (int i = 0; i <= weekdays.length; i++) {
            String message = "";
            try {
                message = weekdays[i];
            } catch (ArrayIndexOutOfBoundsException out) {
                message = "There week ends.";
            } finally {
                System.out.println(message);
            }
        }
    }
}
