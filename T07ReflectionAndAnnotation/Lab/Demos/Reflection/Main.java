package T07ReflectionAndAnnotation.Lab.Demos.Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 0. There is a class RefExample and:
        // 1. Obtain the class variable via .class:
        Class<RefExample> refExample = RefExample.class;
        System.out.println(refExample);
        // 2. The same but with Class.for("classNameWithPackageNotation")
        Class<?> refExample2 = Class.forName("T07ReflectionAndAnnotation.Lab.Demos.Reflection.RefExample");
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
        // 20. Obtain an array of the return types of the params of the method via .getParamTypes():
        Class<?>[] paramTypes = method.getParameterTypes();
        System.out.println(Arrays.toString(paramTypes));
        // 21. Obtain the return type of method via .getReturnType():
        Class<?> returnType = method.getReturnType();
        System.out.println(returnType);
        // 22. Obtain the value of the returnType (Object) of method via .invoke(classObject, args...)
        Method methodDo4 = RefExample.class.getDeclaredMethod("do4", String.class);
        RefExample refExample3 = new RefExample();
        Object returnType2 = methodDo4.invoke(refExample3, "a");
        System.out.println(returnType2);
        // 23. Obtain  class, field or method access modifier via .gerModifiers().
        // 1 - public
        // 2 - private
        // 0 - default
        // 4 - protected
        Method do4Y = RefExample.class.getDeclaredMethod("do4", String.class);
        int modifier = do4Y.getModifiers();
        System.out.println(modifier);
        // Modifier.isPrivate(modifier),
        // Modifier.isProtected(modifier),
        // Modifier.isPublic(modifier),
        // Modifier.isStatic(modifier)
        // - returns true or false if the
        // class, field or method is private, protected, public or static:
        System.out.println(Modifier.isPrivate(do4Y.getModifiers()));
        // 24. Creating an array with reflection via Array.newInstance(
        // elementType.class, numberElement) and casting:
        int[] array = (int[]) Array.newInstance(int.class, 3);
        System.out.println(Arrays.toString(array));
        // 25. Setting a value of an element in the array via Array.set(array, index, value):
        Array.set(array, 1, 5);
        System.out.println(Arrays.toString(array));
        // 26. Obtain the array's elements class (component type) of an array:
        String[] names = new String[5];
        Class<?> componentType = names.getClass().getComponentType();
        System.out.println(componentType);
    }
}
