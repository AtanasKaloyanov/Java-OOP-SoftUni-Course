package T02Encapsulation.Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading
        // 1.1. Pizza object creating:
        Scanner scanner = new Scanner(System.in);
        String[] pizzaInfo = scanner.nextLine().split(" ");
        String pizzaName = pizzaInfo[1];
        int numberToppings = Integer.parseInt(pizzaInfo[2]);
        Pizza pizza = new Pizza(pizzaName, numberToppings);

        // 1.2. Dough object creating. Then adding the dough
        // to the pizza:
        String[] doughInfo = scanner.nextLine().split(" ");
        String doughType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double doughWeight = Double.parseDouble(doughInfo[3]);
        Dough dough = new Dough(doughType, bakingTechnique, doughWeight);
        pizza.setDough(dough);

        // 2. Creating topping objects until a command and adding
        // them to the pizza via addTopping method:
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] toppingInfo = line.split(" ");
            String toppingName = toppingInfo[1];
            double toppingWeight = Double.parseDouble(toppingInfo[2]);
            Topping topping = new Topping(toppingName, toppingWeight);
            pizza.addTopping(topping);
            line = scanner.nextLine();
        }

        // 3. Output printing:
        System.out.println(pizza);
    }
}

/*
Type:
1.White - 1.5;
2.Wholegrain - 1.0;

Technique:
1. Crispy - 0.9;
2. Chewy - 1.1;
3. Homemade - 1.0;

DoughCalories = 2 * weight * typeModifier * techniqueModifier

1. Meat - 1.2;
2. Veggies - 0.8;
3. Cheese - 1.1;
4. Sauce - 0.9;

ToppingCalories = 2 * weight * toppingModifier


AllCalories = DoughCalories + AllToppingCalories

// Input 1:
totalCalories = 0;

1. Pizza Meatless 2
2. Dough Wholegrain Crispy 100
doughCalories = 2 * 100 * 1 * 0.9 = 180
totalCalories = 0 + 180 = 180

3. Topping Veggies 50
topingCalories = 2 * 50 * 0.8 = 80
totalCalories = 180 + 80 = 260

4. Topping Cheese 50
topingCalories = 2 * 50 * 1.1 = 110
totalCalories = 260 + 110 = 370

Output 2: 370

 */