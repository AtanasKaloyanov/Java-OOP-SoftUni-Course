package T12DesignPatterns.Lab.P04Command;

public class PersonCommandImpl implements Command {
    private Person person;

    public PersonCommandImpl(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        double oldSalary = this.person.getSalary();
        double newSalary = 1.30 * oldSalary;
        this.person.setSalary(newSalary);
    }
}
