package T12DesignPatterns.Exercise.Behavioural.P02Strategy;

public class FabricOwner implements Holder {
    @Override
    public void giveInstruction() {
        System.out.println("Work more!");
    }
}
