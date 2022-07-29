package T07ReflectionAndAnnotation.Exercise.P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class clazz = RichSoilLand.class;
        Field[] allFileds = clazz.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {
            switch (input) {
                case "private":
                    Arrays.stream(allFileds)
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName()));
                    break;

                case "protected":
                    Arrays.stream(allFileds)
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName()));
                    break;

                case "public":
                    Arrays.stream(allFileds)
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName()));
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
    }

}
