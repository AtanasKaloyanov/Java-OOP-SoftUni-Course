package T04InterfacesAndAbstraction.Lab.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> list = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] array = input.split(" ");
            if (array.length == 2) {
                String model = array[0];
                String id = array[1];

                Identifiable robot = new Robot(model, id);
                list.add(robot);
            } else {
                String name = array[0];
                int age = Integer.parseInt(array[1]);
                String id = array[2];

                Identifiable human = new Citizen(name, age, id);
                list.add(human);
            }

            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        for (Identifiable identifiable : list) {
           if (identifiable.getId().endsWith(fakeId)) {
               System.out.println(identifiable.getId());
            }
        }

    }
}
