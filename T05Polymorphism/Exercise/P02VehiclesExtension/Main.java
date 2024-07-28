package T05Polymorphism.Exercise.P02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        // 1.1 Car:
        String[] carInfo = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelLiters = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);
        Vehicle car = new Car(carFuelQuantity, carFuelLiters, carTankCapacity);

        // 1.2. Truck:
        String[] truckInfo = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelLiters = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);
        Vehicle truck = new Truck(truckFuelQuantity, truckFuelLiters, truckTankCapacity);

        // 1.3. Bus:
        String[] busInfo = scanner.nextLine().split(" ");
        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busFuelLiters = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);
        Bus bus = new Bus(busFuelQuantity, busFuelLiters, busTankCapacity);

        // 2. Reading n:
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            String command = info[0];
            String vehicleName = info[1];

            if (command.equals("Drive")) {
                double distance = Double.parseDouble(info[2]);
                if (vehicleName.equals("Car")) {
                    car.drive(distance);
                } else if (vehicleName.equals("Truck")) {
                    truck.drive(distance);
                } else if (vehicleName.equals("Bus")) {
                    bus.drive(distance);
                }
            }  else if (command.equals("DriveEmpty")) {
                double distance = Double.parseDouble(info[2]);
                bus.driveEmpty(distance);
            } else if (command.equals("Refuel")) {
                double liters = Double.parseDouble(info[2]);
                if (vehicleName.equals("Car")) {
                    car.refuel(liters);
                } else if (vehicleName.equals("Truck")) {
                    truck.refuel(liters);
                } else if (vehicleName.equals("Bus")) {
                    bus.refuel(liters);
                }
            }
        }

        // 3. Output printing - the remaining fuel:
        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }
}

/*
                       class Vehicle
                          1. double fuelQuantity
                          2. double fuelConsumption (lt / km)


            Car                                                    Truck


 */
