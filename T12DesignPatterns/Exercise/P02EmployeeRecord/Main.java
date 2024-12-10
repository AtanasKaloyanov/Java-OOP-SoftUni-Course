package T12DesignPatterns.Exercise.P02EmployeeRecord;

public class Main {
    private static final int ID = 1;
    private static final String NAME = "Jordan";
    private static final String DESTINATION = "Chicago";
    private static final double SALARY = 3333.33;
    private static final String ADDRESS = "Great Place";

    public static void main(String[] args) {
        try {
            // 1. Creating an object and its cloning and testing if both infos are the same
            EmployeeRecord primary = new EmployeeRecord(ID, NAME, DESTINATION, SALARY, ADDRESS);
            EmployeeRecord cloning = primary.getClone();
            infoComparing(primary, cloning);

            // 2. Same but with another constructor:
            EmployeeRecord primary2 = new EmployeeRecord(ID, NAME, DESTINATION);
            EmployeeRecord cloning2 = primary2.getClone();
            infoComparing(primary2, cloning2);
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println(cloneNotSupportedException.getMessage());
        }
    }

    private static void infoComparing(EmployeeRecord primary, EmployeeRecord cloning) {
        String mainInfo = primary.showRecord();
        String cloningInfo = cloning.showRecord();
        System.out.println(mainInfo);
        System.out.println(cloningInfo);
    }
}
