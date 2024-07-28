package T05Polymorphism.Exercise.P02VehiclesExtension;


public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double km) {
        double totalConsumption = super.getFuelConsumption() + 0.9;
        double fuelOutcome = km * totalConsumption;

        if (fuelOutcome > super.getFuelQuantity()) {
            System.out.println("Car needs refueling");
            return;
        }

        double fuelAfterTravelling = super.getFuelQuantity() - fuelOutcome;
        super.setFuelQuantity(fuelAfterTravelling);
        String kmMessage = formatKm(km);
        System.out.printf("Car travelled %s km\n", kmMessage);
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        double fuelAfterRefueling = super.getFuelQuantity() + liters;
        if (fuelAfterRefueling > super.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        super.setFuelQuantity(fuelAfterRefueling);
    }
}
