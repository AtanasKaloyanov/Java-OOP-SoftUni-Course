package T05Polymorphism.Exercise.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption; // liters per km
    private double tankCapacity;

    private DecimalFormat df = new DecimalFormat("0.##");

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public abstract void drive(double km);

    public abstract void refuel(double liters);

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public String formatKm(double km) {
        return this.df.format(km);
    }
}
