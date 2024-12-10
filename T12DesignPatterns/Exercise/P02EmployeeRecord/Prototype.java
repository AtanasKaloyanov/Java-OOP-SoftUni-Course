package T12DesignPatterns.Exercise.P02EmployeeRecord;

public interface Prototype extends Cloneable {
    EmployeeRecord getClone() throws CloneNotSupportedException;
}
