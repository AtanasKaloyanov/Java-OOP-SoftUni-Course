package T12DesignPatterns.Exercise.Behavioural.P01Command;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 2 object that has implement differently
        // the command method:
        Teacher teacher = new Teacher();
        FabricOwner owner = new FabricOwner();
        teacher.command();
        owner.command();
    }
}
