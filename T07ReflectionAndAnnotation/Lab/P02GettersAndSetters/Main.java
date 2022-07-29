package T07ReflectionAndAnnotation.Lab.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;
        Method[] allMethods = reflection.getDeclaredMethods();

        List<Method> gettersList = new ArrayList<>();
        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterTypes().length == 0)
                .forEach(gettersList::add);

        gettersList.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType().getName()));

        List<Method> setterList = new ArrayList<>();
        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .forEach(setterList::add);

        setterList.stream()
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s%n", method.getName(), method.getParameterTypes()[0].getName()));


    }
}
