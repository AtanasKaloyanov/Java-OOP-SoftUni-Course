package T02Encapsulation.Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaData = scanner.nextLine().split(" ");

        String pizzaName = pizzaData[1];
        int numberToppings = Integer.parseInt(pizzaData[2]);
        Pizza pizza = new Pizza(pizzaName, numberToppings);

        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        int doughWeight = Integer.parseInt(doughData[3]);
        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

        pizza.setDough(dough);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] toppingData = input.split(" ");
            String toppingName = toppingData[1];
            int toppingWeight = Integer.parseInt(toppingData[2]);
            Topping topping = new Topping(toppingName, toppingWeight);

            pizza.addTopping(topping);

            input = scanner.nextLine();
        }

        System.out.println(pizza);
    }
}
