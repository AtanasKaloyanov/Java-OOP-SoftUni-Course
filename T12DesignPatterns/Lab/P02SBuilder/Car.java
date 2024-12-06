package T12DesignPatterns.Lab.P02SBuilder;

public class Car {
     private String brand;
     private String color;
     private int numberOfDoors;
     private String ownerName;

     public Car setBrand(String brand) {
          this.brand = brand;
          return this;
     }

     public Car setColor(String color) {
          this.color = color;
          return this;
     }

     public Car setNumberOfDoors(int numberOfDoors) {
          this.numberOfDoors = numberOfDoors;
          return this;
     }

     public Car setOwnerName(String name) {
          this.ownerName = name;
          return this;
     }

     public Car build() {
          return this;
     }

     @Override
     public String toString() {
          return this.brand + " - "
                  + this.color + " - "
                  + this.numberOfDoors + " - "
                  + this.ownerName;
     }
}
