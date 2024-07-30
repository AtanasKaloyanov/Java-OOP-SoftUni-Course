package T05Polymorphism.Exercise.P04Calculator;

import java.util.ArrayDeque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;

    // saving the integers by ms command
    private ArrayDeque<Integer> msCommandsResults = new ArrayDeque<>();

    // saving every data input
    private ArrayDeque<String> inputData = new ArrayDeque<>();

    public void pushNumber(int number) {
        if (this.currentOperation != null) {
            this.currentOperation.addOperand(number);

            if (this.currentOperation.isCompleted()) {
                this.result = this.currentOperation.getResult();

                // ms (1 case) and mr (3 cases) logic:
                if (this.currentOperation instanceof MsOperation) {
                    this.msCommandsResults.push(this.result);
                } else if (this.currentOperation instanceof MrOperation) {
                    int lastNumber = this.msCommandsResults.poll();
                    String lastOperation = this.inputData.peek();

                    if (lastOperation.equals("*")) {
                        this.result *= lastNumber;
                    } else if (lastOperation.equals("/")) {
                        this.result /= lastNumber;
                    } else if (isInteger(lastOperation)) {
                        this.result = lastNumber;
                    }
                }

                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
//        if(operation == null){
//            return;
//        }
        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }

    public ArrayDeque<Integer> getMsCommandsResults() {
        return msCommandsResults;
    }

    public void pushEveryInput(String input) {
        this.inputData.push(input);
    }

    private static boolean isInteger(String text) {
        try {
            int number = Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
