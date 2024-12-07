package T12DesignPatterns.Exercise.Behavioural.P01Command;

public class Teacher implements Holder {

    @Override
    public void command() {
        System.out.println("Learn more!");
    }
}
