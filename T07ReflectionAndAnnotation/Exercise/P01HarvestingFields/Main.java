package T07ReflectionAndAnnotation.Exercise.P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Field> privateFields = new ArrayList<>();
    private static List<Field> protectedFields = new ArrayList<>();
    private static List<Field> publicFields = new ArrayList<>();

    private static List<Field> allFields = new ArrayList<>();

    public static void main(String[] args) {
        // 1. Obtain the class and all its methods, then all its private, protected and public methods:
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        Field[] fields = richSoilLandClass.getDeclaredFields();
        allFields = Arrays.stream(fields)
                .collect(Collectors.toList());

        filterMethodsByModifiers(allFields);

        // 2. Printing methods via while cycle algorithm:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("HARVEST")) {
            switch (line) {
                case "private":
                    printMethods(privateFields);
                    break;
                case "protected":
                    printMethods(protectedFields);
                    break;
                case "public":
                    printMethods(publicFields);
                    break;
                case "all":
                    printMethods(allFields);
                    break;
            }

            line = scanner.nextLine();
        }
    }

    private static void filterMethodsByModifiers(List<Field> allFields) {
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            } else if (Modifier.isProtected(field.getModifiers())) {
                protectedFields.add(field);
            } else if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field);
            }
        }
    }

    private static void printMethods(List<Field> fields) {
        for (Field field : fields) {
            int modifier = field.getModifiers();
            String modifierSimpleName = getSimpleName(modifier);
            String type = field.getType().getSimpleName();
            String name = field.getName();
            System.out.printf("%s %s %s\n", modifierSimpleName, type, name);
        }
    }

    private static String getSimpleName(int modifier) {
        return switch (modifier) {
            case 1 -> "public";
            case 2 -> "private";
            case 4 -> "protected";
            default -> "default";
        };
    }
}

// 1 - public
// 2 - private
// 0 - default
// 4 - protected
