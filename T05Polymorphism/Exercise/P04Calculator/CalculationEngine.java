package T05Polymorphism.Exercise.P04Calculator;

import java.util.ArrayDeque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private Operation lastOperation;
    private ArrayDeque<Integer> msCommandsResults = new ArrayDeque<>();

    public void pushNumber(int number) {
        if (this.currentOperation != null) {
            this.currentOperation.addOperand(number);

            if (this.currentOperation.isCompleted()) {
                this.result = this.currentOperation.getResult();

                //
                if (this.currentOperation instanceof MsOperation) {
                    this.msCommandsResults.offer(this.result);
                } else if (this.currentOperation instanceof MrOperation) {
                    int lastNumber = this.msCommandsResults.poll();

                    if (this.lastOperation instanceof MultiplicationOperation) {
                        this.result *= lastNumber;
                    } else if (this.lastOperation instanceof DivisionOperation) {
                        this.result /= lastNumber;
                    }
                }
                //
                this.lastOperation = this.currentOperation;
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
}
