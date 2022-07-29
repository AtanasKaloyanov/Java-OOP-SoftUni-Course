package T07ReflectionAndAnnotation.Exercise.P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "HARVEST";
    private static final String PRIVATE_FIELD = "private";
    private static final String PUBLIC_FIELD = "public";
    private static final String PROTECTED_FIELD = "protected";


    public static void main(String[] args) {
        Class clazz = RichSoilLand.class;
        Field[] allFileds = clazz.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (!END_COMMAND.equals(input = scanner.nextLine())) {
            switch (input) {
                case PRIVATE_FIELD:
                  print(allFileds, PRIVATE_FIELD);
                    break;

                case "protected":
                 print(allFileds, PROTECTED_FIELD);
                    break;

                case "public":
                    print(allFileds, PUBLIC_FIELD);
                    break;

                case "all":
                    Arrays.stream(allFileds)
                            .forEach(field -> {
                                if (Modifier.isPublic(field.getModifiers())) {
                                    System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName());
                                } else if (Modifier.isPrivate(field.getModifiers())) {
                                    System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName());
                                } else if (Modifier.isProtected(field.getModifiers())) {
                                    System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName());
                                }
                            });

                    break;
            }

            input = scanner.nextLine();
        }

        scanner.close();
    }

    public static void print(Field[] fields, String modifier) {
        Arrays.stream(fields)
                .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                .forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
    }

}
