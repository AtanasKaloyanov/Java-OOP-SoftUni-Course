package T05Polymorphism.Exercise.P01Vehicles;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(double km) {
        double totalConsumption = super.getFuelConsumption() + 0.9;
        double fuelOutcome = km * totalConsumption;

        if (fuelOutcome > super.getFuelQuantity()) {
            System.out.println("Car needs refueling");
        } else {
            double fuelAfterTravelling = super.getFuelQuantity() - fuelOutcome;
            super.setFuelQuantity(fuelAfterTravelling);
            String kmMessage = formatKm(km);
            System.out.printf("Car travelled %s km\n", kmMessage);
        }
    }

    @Override
    public void refuel(double liters) {
        double fuelAfterRefueling = super.getFuelQuantity() + liters;
        super.setFuelQuantity(fuelAfterRefueling);
    }
}
