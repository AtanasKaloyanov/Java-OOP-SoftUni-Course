package T07ReflectionAndAnnotation.Lab.P05CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {

        Map<String, List<String>> annotationMap = new HashMap<>();

        Method[] allMethods = clazz.getDeclaredMethods();
        Arrays.stream(allMethods).forEach(method -> {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                annotationMap.putIfAbsent(annotation.name(), new ArrayList<>());
                annotationMap.get(annotation.name()).add(method.getName() + "()");
            }
        });

        annotationMap.forEach((key, value) -> System.out.printf("%s: %s%n", key, value.toString().replaceAll("[\\[\\]]", "")));
    }
}
