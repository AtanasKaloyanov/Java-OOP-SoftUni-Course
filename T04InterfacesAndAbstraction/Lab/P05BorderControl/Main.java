package T04InterfacesAndAbstraction.Lab.P05BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading and Set initialization:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Set<Identifiable> identifiables = new LinkedHashSet<>();

        // 2. While cycle:
        while (!line.equals("End")) {
            String id;
            Identifiable identifiable = null;
            String[] array = line.split(" ");
            if (array.length == 3) {
                String name = array[0];
                int age = Integer.parseInt(array[1]);
                id = array[2];

                identifiable = new Citizen(name, age, id);
            } else if (array.length == 2) {
                String model = array[0];
                id = array[1];

                identifiable = new Robot(model, id);
            }

            identifiables.add(identifiable);
            line = scanner.nextLine();
        }

        // 3. SearchedId reading, filtering and printing:
        String searchedId = scanner.nextLine();
        identifiables.stream().filter( (ident) -> ident.getId().endsWith(searchedId))
                .forEach( (ident) -> System.out.println(ident.getId()));
    }
}
