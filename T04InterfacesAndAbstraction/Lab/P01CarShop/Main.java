package T04InterfacesAndAbstraction.Lab.P01CarShop;

public class Main {
    public static void main(String[] args) {
        // 1. Car object creating
        Car seat = new Seat("Leon", "gray", 110, "Spain");

        // 2. 2 lines printing:
        System.out.printf("%s is %s color and have %s horse power%n",
                seat.getModel(), seat.getColor(), seat.getHorsePower());
        System.out.println(seat);
    }
}
