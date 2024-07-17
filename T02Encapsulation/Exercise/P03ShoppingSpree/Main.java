package T02Encapsulation.Exercise.P03ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading - people and products:
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        // 2. Adding the people and the products into 2 maps
        Map<String, Person> personByName = new LinkedHashMap<>();
        for (String person : people) {
            String[] personInfo = person.split("=");
            String name = personInfo[0];
            double money = Double.parseDouble(personInfo[1]);
            Person currentPerson = new Person(name, money);
            personByName.put(name, currentPerson);
        }

        Map<String, Product> productByName = new HashMap<>();
        for (String product : products) {
            String[] productInfo = product.split("=");
            String productName = productInfo[0];
            double cost = Double.parseDouble(productInfo[1]);
            Product currentProduct = new Product(productName, cost);
            productByName.put(productName, currentProduct);
        }

        // 3. While cycle:
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            // 3.1. Reading the current person and the current product:
            String[] array = line.split(" ");
            String personName = array[0];
            String productName = array[1];
            Person person = personByName.get(personName);
            Product product = productByName.get(productName);
            // 3.2. If the person and the product exist =>
            // buying the product via buyProduct
            if (person != null && product != null) {
                person.buyProduct(product);
            }
            line = scanner.nextLine();
        }

        // 4. People printing:
        personByName.values()
                .forEach(System.out::println);
    }
}