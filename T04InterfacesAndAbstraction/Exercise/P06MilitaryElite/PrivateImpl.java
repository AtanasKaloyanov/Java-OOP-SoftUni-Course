package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private, Comparable<PrivateImpl> {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + " Salary: " + String.format("%.2f", this.getSalary());
    }

    @Override
    public int compareTo(PrivateImpl second) {
        return Integer.compare(second.getId(), super.getId());
    }
}
