package T07ReflectionAndAnnotation.Lab.P01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. Obtain the:
        //1.1. class type
        Class<Reflection> reflectionClass = Reflection.class;
        // 1.2. super class type
        Class<?> parentClass = reflectionClass.getSuperclass();
        // 1.3. all interfaces that the class implements
        Class<?>[] interfaces = reflectionClass.getInterfaces();
        // 1.4. New Object of a class
        Constructor<?> constructor = reflectionClass.getDeclaredConstructor();
        Reflection refObject = (Reflection) constructor.newInstance();

        // 2. Output printing:
        System.out.println(reflectionClass);
        System.out.println(parentClass);
        for (Class<?> iinterface : interfaces) {
            System.out.println(iinterface);
        }
        System.out.println(refObject);
    }
}
