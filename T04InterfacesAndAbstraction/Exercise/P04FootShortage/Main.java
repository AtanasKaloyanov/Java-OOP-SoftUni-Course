package T04InterfacesAndAbstraction.Exercise.P04FootShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading n times, then byers creating via while cycle and
        // adding them into a map:
        Map<String, Buyer> buyersByName = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] buyerInfo = scanner.nextLine().split(" ");
            String name = null;
            Buyer buyer = null;
            int age;
            if (buyerInfo.length == 3) {
                name = buyerInfo[0];
                age = Integer.parseInt(buyerInfo[1]);
                String group = buyerInfo[2];
                buyer = new Rebel(name, age, group);
            } else if (buyerInfo.length == 4) {
                name = buyerInfo[0];
                age = Integer.parseInt(buyerInfo[1]);
                String id = buyerInfo[2];
                String birthday = buyerInfo[3];
                buyer = new Citizen(name, age, id, birthday);
            }

            buyersByName.put(name, buyer);
        }

        // 2. Reading via while cycle until a command names,
        // then by this names getting the byers and then buying food
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String name = line;
            Buyer buyer = buyersByName.get(name);
            if (buyer != null) {
                buyer.buyFood();
            }
            line = scanner.nextLine();
        }

        // 3. Finding the total food and printing it:
        int totalSum = buyersByName.values().stream()
                .mapToInt(Buyer::getFood).sum();
        System.out.println(totalSum);
    }
}

