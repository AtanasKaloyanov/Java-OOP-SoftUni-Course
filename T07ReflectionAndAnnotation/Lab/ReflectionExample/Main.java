package T07ReflectionAndAnnotation.Lab.ReflectionExample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 0. There is a class RefExample and:
        // 1. Obtain the class variable via .class:
        Class<RefExample> refExample = RefExample.class;
        System.out.println(refExample);
        // 2. The same but with Class.for("classNameWithPackageNotation")
        Class<?> refExample2 = Class.forName("T07ReflectionAndAnnotation.Lab.ReflectionExample.RefExample");
        System.out.println(refExample2);
        // 3. Obtain the class name via .class.className
        String className = RefExample.class.getName();
        System.out.println(className);
        // 4. Obtain the class name but without the package notation via .class.className:
        String classNameWithoutThePackageNotation = RefExample.class.getSimpleName();
        System.out.println(classNameWithoutThePackageNotation);
        // 5. Obtain the parent class via .getSuperClass
        Class<?> refFather = RefExample.class.getSuperclass();
        System.out.println(refFather);
        // 6. Obtain an array of the implemented interfaces via .class.fetInterFaces:
        Class<?>[] interFaces = RefExample.class.getInterfaces();
        System.out.println(Arrays.toString(interFaces));
        // 7. Obtain an array of the public constructor via .class.gerConstructors();
        Constructor<?>[] publicConst = RefExample.class.getConstructors();
        System.out.println(Arrays.toString(publicConst));
        // 8. Obtain an array of all constructors via .class.gerDeclaredConstructors():
        Constructor<?>[] allConstructors = RefExample.class.getDeclaredConstructors();
        System.out.println(Arrays.toString(allConstructors));
        // 9. Obtain a constructor by passing a parameter via .class.getDeclaredConstructor:
        Constructor<?> constructor = RefExample.class.getDeclaredConstructor(String.class, String.class, int.class);
        System.out.println(constructor);
        // 10. Obtain the parameters of a constructor via .getParameterTypes():
        Class<?>[] constructorParameters = constructor.getParameterTypes();
        System.out.println(Arrays.toString(constructorParameters));
        // 11. Instantiating an object using a constructor via .newInstance(arg1, arg2...) and casting:
        RefExample refExample1 = (RefExample) constructor.newInstance("a", "b", 1);
        System.out.println(refExample1);
        // 12. Obtain a public field via .class.getField("publicFieldName"):
        Field field = RefExample.class.getField("publicField");
        System.out.println(field);
        // 13. Obtain an array of the public fields via getFields():
        Field[] publicFields = RefExample.class.getFields();
        System.out.println(Arrays.toString(publicFields));
        // 14. Obtain all fields regardless of its access modifier via .class.getDeclaredFields:
        Field[] allFields = RefExample.class.getDeclaredFields();
        System.out.println(Arrays.toString(allFields));
        // 15. Obtain the name of a field via .getName():
        String fieldName =  field.getName();
        System.out.println(fieldName);
        // 16. Obtain type of a field getType():
        Class<?> fieldType = field.getType();
        System.out.println(fieldType);
        // 17. Creating an object of the class, getting a field from the class and setting a field value
        // to the object via field.set(object, "value"):
        Class<?> refClass = RefExample.class;
        Constructor<?> constr = refClass.getDeclaredConstructor();
        constr.setAccessible(true);
        Object refObj = constr.newInstance();
        Field nameField = refClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(refObj, "a");
        System.out.println(refObj);
        // 18. Obtain a public method vid getMethod("methodName", varargs of the param. types):
        Method method = RefExample.class.getMethod("do1");
        System.out.println(method);
        // 19. Obtain an array of the public methods via .class.getMethods()
        Method[] methods = RefExample.class.getMethods();
        System.out.println(Arrays.toString(methods));
        // 20. 
    }
}
