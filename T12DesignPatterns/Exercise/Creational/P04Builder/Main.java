package T12DesignPatterns.Exercise.Creational.P04Builder;

public class Main {
    private static final String NAME = "rise";
    private static final int ID = 100;
    private static final String PROD_DATE = "10.10.10";
    private static final String CONSUME_BEFORE = "11.11.11";

    public static void main(String[] args) {
        // 1. Creating an object declarative:
        Product product = new Product()
                .withName(NAME)
                .withId(ID)
                .withProdDate(PROD_DATE)
                .withConsumeBefore(CONSUME_BEFORE)
                .build();

       //  2. Checking if the fields are initialized:
        String name = product.getName();
        int id = product.getId();
        String date = product.getProdDate();
        String bestBefore = product.getConsumeBefore();

        System.out.println(name);
        System.out.println(id);
        System.out.println(date);
        System.out.println(bestBefore);
    }
}
