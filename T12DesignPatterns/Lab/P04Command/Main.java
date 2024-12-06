package T12DesignPatterns.Lab.P04Command;

public class Main {
    private static final String PRODUCT_NAME = "juice";
    private static final double PRICE = 2.00;
    private static final String PERSON_NAME = "George";
    private static final double SALARY = 1000;

    public static void main(String[] args) {
        // 1. Creating 2 objects and 2 commands implementations:
        Product product = new Product(PRODUCT_NAME, PRICE);
        ProductCommandImpl productCommand = new ProductCommandImpl(product);

        Person person = new Person(PERSON_NAME, SALARY);
        PersonCommandImpl personCommand = new PersonCommandImpl(person);

        // 2. Invoking the method execute from the object implementation:
        productCommand.execute();
        personCommand.execute();

        // 3. Checking if the different commands are implemented:
        double newPrice = product.getPrice();
        double newSalary = person.getSalary();
        System.out.println(newPrice);
        System.out.println(newSalary);
    }
}
