package T12DesignPatterns.Exercise.Behavioural.P02Strategy;

public class Teacher implements Holder {

    @Override
    public void giveInstruction() {
        System.out.println("Learn more!");
    }
}
