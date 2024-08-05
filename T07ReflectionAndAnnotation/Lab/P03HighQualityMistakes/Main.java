package T07ReflectionAndAnnotation.Lab.P03HighQualityMistakes;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 1. Obtain the class, all the fields and methods:
        Class<Reflection> reflectionClass = Reflection.class;
        Field[] allFields = reflectionClass.getDeclaredFields();
        Method[] allMethods = reflectionClass.getDeclaredMethods();

        // 2. Adding the getters and the setter into a list:
        Comparator<Method> methodsComp = Comparator.comparing(Method::getName);
        Set<Method> notPublicGetters = new TreeSet<>(methodsComp);
        Set<Method> notPrivateSetters = new TreeSet<>(methodsComp);
        fillingGettersAndSetters(allMethods, notPublicGetters, notPrivateSetters);

        // 3. Output printing:
        printNotPrivateFieldsAlph(allFields);
        printGetters(notPublicGetters);
        printSetters(notPrivateSetters);
    }

    private static void printSetters(Set<Method> publicSetters) {
        publicSetters.forEach( (setter) -> {
            String setterName = setter.getName();
            System.out.printf("%s have to be private!\n", setterName);
        });
    }

    private static void printGetters(Set<Method> privateGetters) {
        privateGetters.forEach( (getter) -> {
            String getterName = getter.getName();
            System.out.printf("%s have to be public!\n", getterName);
        });
    }

    private static void printNotPrivateFieldsAlph(Field[] allFields) {
        Arrays.stream(allFields)
                .filter(Main::isNotPrivateField)
                .sorted(Comparator.comparing(Field::getName))
                .forEach( (field) -> System.out.printf("%s must be private!\n", field.getName()));
    }

    private static boolean isNotPrivateField(Field field) {
        return !Modifier.isPrivate(field.getModifiers());
    }

    private static void fillingGettersAndSetters(Method[] allMethods, Set<Method> privateGetters, Set<Method> publicSetters) {
        for (Method method : allMethods) {
            if (isNotPublicGetter(method)) {
                privateGetters.add(method);
            } else if (isNotPrivateSetter(method)) {
                publicSetters.add(method);
            }
        }
    }

    private static boolean isNotPrivateSetter(Method method) {
        return method.getName().startsWith("set") &&
                !Modifier.isPrivate(method.getModifiers());
    }

    private static boolean isNotPublicGetter(Method method) {
        return method.getName().startsWith("get") &&
                !Modifier.isPublic(method.getModifiers());
    }
}

