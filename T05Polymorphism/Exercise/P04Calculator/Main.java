package T05Polymorphism.Exercise.P04Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if(token.equals("end")){
                break;
            }
            interpreter.interpret(token);
        }

        System.out.println(engine.getCurrentResult());
        System.out.println(engine.getMsCommandsResults());
    }
}

/*
Input 1:

CalculationEngine engine = new CalculationEngine()

int result = 0;
Operation currentOperation = null;
ArrayDeque<Integer> numberFromMS = new ArrayDeque<>();

1.   1    ->  result = 1;
              currentOperation = null;
              numberFromMS = {}

2.   *    ->  result = 1;
              currentOperation = *
              numberFromMS = {}

3.   2    -> result = 2;
             currentOperation = null
             numberFromMS = {}

4.   *    -> result = 2;
             currentOperation = *
             numberFromMS = {}

5.   3    -> result = 6;
             currentOperation = null
             numberFromMS = {}

6.   ms   -> result = 6;
             currentOperation = null
             numberFromMS = {6}

7.   *


8.   4


9.   *


10.  mr


11.  /


12.  2

 */
