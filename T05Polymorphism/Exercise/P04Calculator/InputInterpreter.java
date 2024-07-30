package T05Polymorphism.Exercise.P04Calculator;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            int number = Integer.parseInt(input);
            this.engine.pushNumber(number);
        } catch (Exception ex) {
            Operation operation = this.getOperation(input);
            this.engine.pushOperation(operation);
        } finally {
            // saving every input with this method
            this.engine.pushEveryInput(input);
        }
        return true;
    }

    public Operation getOperation(String operation) {
        return switch (operation) {
            case "*" -> new MultiplicationOperation();
            case "/" -> new DivisionOperation();
            case "ms" -> new MsOperation();
            case "mr" -> new MrOperation();
            default -> null;
        };
    }
}
