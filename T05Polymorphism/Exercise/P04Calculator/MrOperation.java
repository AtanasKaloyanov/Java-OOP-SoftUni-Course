package T05Polymorphism.Exercise.P04Calculator;

import java.util.ArrayList;
import java.util.List;

public class MrOperation implements Operation {
    private List<Integer> operands;
    private int result;

    public MrOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 1;
    }

}
