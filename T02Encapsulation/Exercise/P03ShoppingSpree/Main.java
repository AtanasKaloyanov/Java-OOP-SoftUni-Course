package T02Encapsulation.Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personData = scanner.nextLine().split(";");
        List<Person> personList = new ArrayList<>();

        for (String personDatum : personData) {
            String[] personArray = personDatum.split("=");
            String name = personArray[0];
            int money = Integer.parseInt(personArray[1]);

            Person person = new Person(name, money);
            personList.add(person);
        }

        String[] productData = scanner.nextLine().split(";");
        List<Product> productList = new ArrayList<>();

        for (String currentProduct : productData) {
            String[] productArray = currentProduct.split("=");
            String name = productArray[0];
            int cost = Integer.parseInt(productArray[1]);

            Product product = new Product(name, cost);
            productList.add(product);
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] purchase = input.split(" ");
            String name = purchase[0];
            String product = purchase[1];

            for (Person person : personList) {
                if (person.getName().equals(name)) {
                    for (Product currentProduct : productList) {
                        if (currentProduct.getName().equals(product)) {
                            person.buyProduct(currentProduct);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Person person : personList) {
            System.out.println(person);
        }

    }
}
