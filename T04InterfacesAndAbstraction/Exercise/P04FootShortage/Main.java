package T04InterfacesAndAbstraction.Exercise.P04FootShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyerMap = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            if (data.length == 4) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                String birthDay = data[3];

                Buyer slave = new Citizen(name, age, id, birthDay);
                buyerMap.put(name, slave);
            } else {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String group = data[2];

                Buyer freeMan = new Rebel(name, age, group);
                buyerMap.put(name, freeMan);
            }


        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            if (buyerMap.containsKey(input)) {
                buyerMap.get(input).buyFood();
            }

            input = scanner.nextLine();
        }

        int allFood = 0;
        for (Map.Entry<String, Buyer> entry : buyerMap.entrySet()) {
           allFood +=  entry.getValue().getFood();
        }

        System.out.println(allFood);
    }
}

