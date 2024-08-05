package T07ReflectionAndAnnotation.Lab.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 1. Obtain the reflection class and all its methods:
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] methods = reflectionClass.getDeclaredMethods();

        // 2. Creating 2 trees for the getters and setters, adding
        // them a comparator and filling them
        Comparator<Method> nameComparator = Comparator.comparing(Method::getName);
        TreeSet<Method> getters = new TreeSet<>(nameComparator);
        TreeSet<Method> setters = new TreeSet<>(nameComparator);
        fillingGettersAndSetters(methods, getters, setters);

        // 3. Output printing:
        gettersPrinting(getters);
        setterPrinting(setters);
    }

    private static void setterPrinting(TreeSet<Method> setters) {
        setters.forEach( (setter) -> {
            String setterName = setter.getName();
            String setterParamType = setter.getParameterTypes()[0].getName();
            System.out.printf("%s and will set field of class %s\n", setterName, setterParamType);
        });
    }

    private static void gettersPrinting(TreeSet<Method> getters) {
        getters.forEach( (getter) -> {
            String getterName = getter.getName();
            String getterReturnType = getter.getReturnType().getName();
            System.out.printf("%s will return class %s\n", getterName, getterReturnType);
        });
    }

    private static void fillingGettersAndSetters(Method[] methods, TreeSet<Method> getters, TreeSet<Method> setters) {
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
    }
}