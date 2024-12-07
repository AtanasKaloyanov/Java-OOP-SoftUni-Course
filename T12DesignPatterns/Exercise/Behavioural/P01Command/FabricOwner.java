package T12DesignPatterns.Exercise.Behavioural.P01Command;

public class FabricOwner implements Holder {
    @Override
    public void command() {
        System.out.println("Work more!");
    }
}
