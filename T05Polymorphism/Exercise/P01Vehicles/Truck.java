package T05Polymorphism.Exercise.P01Vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }



    @Override
    public void drive(double km) {
        double totalConsumption = super.getFuelConsumption() + 1.6;
        double fuelOutcome = km * totalConsumption;

        if (fuelOutcome > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            double fuelAfterTravelling = super.getFuelQuantity() - fuelOutcome;
            super.setFuelQuantity(fuelAfterTravelling);
            String kmMessage = super.formatKm(km);
            System.out.printf("Truck travelled %s km\n", kmMessage);
        }
    }

    @Override
    public void refuel(double liters) {
        double fuelAfterRefueling = super.getFuelQuantity() + 0.95 * liters;
        super.setFuelQuantity(fuelAfterRefueling);
    }
}
