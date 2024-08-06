package T07ReflectionAndAnnotation.Lab.P05CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    private static Map<String, List<Method>> methodsByName = new LinkedHashMap<>();

    @Author(name = "Atanas")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        putMethodsByAuthorToMap(methods);
        methodsByName.forEach( (authorName, methodsL) -> {
            System.out.printf("%s -> %s\n", authorName, methodsL);
        });
    }

    @Author(name = "Atanas")
    private static void putMethodsByAuthorToMap(Method[] methods) {
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                String authorName = annotation.name();
                methodsByName.putIfAbsent(authorName, new ArrayList<>());
                methodsByName.get(authorName).add(method);
            }
        }
    }

    @Author(name = "Atanas")
    public void do1() {
    }

    @Author(name = "Pesho")
    public void do2() {
    }

    @Author(name = "Gosho")
    public void do3() {
    }

}
