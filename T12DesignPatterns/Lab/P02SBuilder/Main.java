package T12DesignPatterns.Lab.P02SBuilder;

public class Main {
    private static final String BRAND = "Opel";
    private static final String COLOR = "red";
    private static final int DOOR_NUMBER = 4;
    private static final String OWNER_NAME = "Harold";

    public static void main(String[] args) {
        // 1. Creating 4 objects
        Car car1 = buildWithBrand();
        Car car2 = buildWithBrandAndColor();
        Car car3 = buildWithBrandColorAndDoorNumber();
        Car car4 = buildWithBrandColorDoorNumberAndOwnerName();

        // 4. Printing it:
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
    }

    private static Car buildWithBrandColorDoorNumberAndOwnerName() {
        return new Car()
                .setBrand(BRAND)
                .setColor(COLOR)
                .setNumberOfDoors(DOOR_NUMBER)
                .setOwnerName(OWNER_NAME)
                .build();
    }

    private static Car buildWithBrandColorAndDoorNumber() {
        return new Car()
                .setBrand(BRAND)
                .setColor(COLOR)
                .setNumberOfDoors(DOOR_NUMBER)
                .build();
    }

    private static Car buildWithBrandAndColor() {
        return new Car()
                .setBrand(BRAND)
                .setColor(COLOR)
                .build();
    }

    private static Car buildWithBrand() {
        return new Car()
                .setBrand(BRAND)
                .build();
    }
}
