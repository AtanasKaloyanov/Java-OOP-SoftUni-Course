package T12DesignPatterns.Exercise.Behavioural.P02Strategy;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 2 object that has implement differently
        // the giveInstr method:
        Teacher teacher = new Teacher();
        FabricOwner owner = new FabricOwner();
        teacher.giveInstruction();
        owner.giveInstruction();
    }
}
