package T07ReflectionAndAnnotation.Exercise.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
       // 1. Object creating of  type BlackBoxInt
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass
                .getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        // 2. Obtain of the methods add, subtract, multiply, divide, leftShift, rightShift and setting it access to true:
        // 2.1. Obtaining:
        Method add = blackBoxIntClass.getDeclaredMethod("add", int.class);
        Method subtract = blackBoxIntClass.getDeclaredMethod("subtract", int.class);
        Method multiply = blackBoxIntClass.getDeclaredMethod("multiply", int.class);
        Method divide = blackBoxIntClass.getDeclaredMethod("divide", int.class);
        Method leftShift = blackBoxIntClass.getDeclaredMethod("leftShift", int.class);
        Method rightShift = blackBoxIntClass.getDeclaredMethod("rightShift", int.class);

        //2.2. Access setting:
        add.setAccessible(true);
        subtract.setAccessible(true);
        multiply.setAccessible(true);
        divide.setAccessible(true);
        divide.setAccessible(true);
        leftShift.setAccessible(true);
        rightShift.setAccessible(true);

        // 3. Obtain the field from the class:
        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        // 4. Reading the data via while cycle,
        // invocation of the method by name and printing the value:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] array = line.split("_");
            String methodName = array[0];
            int parameter = Integer.parseInt(array[1]);

            switch (methodName) {
                 case "add" -> add.invoke(blackBoxInt, parameter);
                 case "subtract" -> subtract.invoke(blackBoxInt, parameter);
                 case "multiply" -> multiply.invoke(blackBoxInt, parameter);
                 case "divide" -> divide.invoke(blackBoxInt, parameter);
                 case "leftShift" -> leftShift.invoke(blackBoxInt, parameter);
                 case "rightShift" -> rightShift.invoke(blackBoxInt, parameter);
            }

            int currentFieldValue = (int) innerValue.get(blackBoxInt);
            System.out.println(currentFieldValue);
            line = scanner.nextLine();
        }

    }
}
