package T12DesignPatterns.Exercise.P02EmployeeRecord;

public class EmployeeRecord implements Prototype {
    private int id;
    private String name;
    private String destination;
    private double salary;
    private String address;

    public EmployeeRecord(int id, String name,
                          String destination, double salary,
                          String address) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.salary = salary;
        this.address = address;
    }

    public EmployeeRecord(int id, String name, String destination) {
        this.id = id;
        this.name = name;
        this.destination = destination;
    }

    public String showRecord() {
        String id = this.id == 0 ? "Please, insert your name." : String.valueOf(this.id);
        String name = this.name == null ? "Please, insert your name." : this.name;
        String destination = this.destination == null ? "Please, insert your destination." : this.destination;
        String salary = this.salary == 0.0 ? "Please, insert your salary." : String.valueOf(this.salary);
        String address = this.address == null ? "Please, insert your address." : this.address;

        return id + " - " + name + " - " + destination + " - " + salary + " - " + address;
    }

    @Override
    public EmployeeRecord getClone() throws CloneNotSupportedException {
        return (EmployeeRecord) super.clone();
    }
}
