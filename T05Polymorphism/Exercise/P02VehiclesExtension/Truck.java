package T05Polymorphism.Exercise.P02VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double km) {
        double totalConsumption = super.getFuelConsumption() + 1.6;
        double fuelOutcome = km * totalConsumption;

        if (fuelOutcome > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
            return;
        }

        double fuelAfterTravelling = super.getFuelQuantity() - fuelOutcome;
        super.setFuelQuantity(fuelAfterTravelling);
        String kmMessage = super.formatKm(km);
        System.out.printf("Truck travelled %s km\n", kmMessage);
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double fuelAfterRefueling = super.getFuelQuantity() + 0.95 * liters;
        if (fuelAfterRefueling > super.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        super.setFuelQuantity(fuelAfterRefueling);
    }
}
