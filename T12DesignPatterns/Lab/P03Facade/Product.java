package T12DesignPatterns.Lab.P03Facade;

public class Product {
    private String name;
    private Manufacturer manufacturer;
     private Distributor distributor;

     public Product(String name, Manufacturer manufacturer, Distributor distributor) {
         this.name = name;
         this.manufacturer = manufacturer;
         this.distributor = distributor;
     }

     public String info() {
         String manufacturer = this.manufacturer.getName();
         String distributor = this.distributor.getName();
         return this.name + " - " + manufacturer + " - " + distributor;
     }
}
