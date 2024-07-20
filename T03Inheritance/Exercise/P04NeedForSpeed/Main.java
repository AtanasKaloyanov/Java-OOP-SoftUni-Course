package T03Inheritance.Exercise.P04NeedForSpeed;



public class Main {
    public static void main(String[] args) {
        // 1. Creating objects of the classes from the hierarchy and
        // for every object drive method invocation:

        // 1.1. Vehicle:
        Vehicle vehicle = new Vehicle(150, 1);
        vehicle.drive(60);
        System.out.println(vehicle.getFuel()); // 75
        vehicle.drive(60);
        System.out.println(vehicle.getFuel()); // 0

        System.out.println();
        // 1.2. Motorcycle:
        Motorcycle motorcycle = new Motorcycle(150, 1);
        motorcycle.drive(60);
        System.out.println(motorcycle.getFuel()); // 75
        motorcycle.drive(60);
        System.out.println(motorcycle.getFuel()); // 0

        // 1.3. RaceMotorcycle
        System.out.println();
        RaceMotorcycle raceMotorCycle = new RaceMotorcycle(800, 1);
        raceMotorCycle.drive(50);
        System.out.println(raceMotorCycle.getFuel()); // 400
        raceMotorCycle.drive(50);
        System.out.println(raceMotorCycle.getFuel()); // 0

        System.out.println();
        // 1.4. CrossMotorcycle:
        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(150, 1);
        crossMotorcycle.drive(60);
        System.out.println(crossMotorcycle.getFuel()); // 75
        crossMotorcycle.drive(60);
        System.out.println(crossMotorcycle.getFuel()); // 0

        System.out.println();
        // 1.5. Car:
        Car car = new Car(600, 1);
        car.drive(100);
        System.out.println(car.getFuel()); // 300
        car.drive(100);
        System.out.println(car.getFuel()); // 0

        System.out.println();
        // 1.6. FamilyCar:
        FamilyCar familyCar = new FamilyCar(600, 1);
        familyCar.drive(100);
        System.out.println(familyCar.getFuel()); // 300
        familyCar.drive(100);
        System.out.println(familyCar.getFuel()); // 0

        System.out.println();
        // 1.7. Car:
        SportCar sportCar = new SportCar(800, 1);
        sportCar.drive(40);
        System.out.println(sportCar.getFuel()); // 400
        sportCar.drive(40);
        System.out.println(sportCar.getFuel()); // 0
    }
}
