package T07ReflectionAndAnnotation.Lab.Demos.Annotation;

import org.w3c.dom.ls.LSOutput;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    @Deprecated
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        AnnotationsExample<String> annotationsExample = new AnnotationsExample<>();

        // 1. @Deprecated - We don't have to use the method.
        annotationsExample.do1();
        // 2. @SuppressWarnings - Suppresses the warning of the compiler:
        String[] array = annotationsExample.createArray(String.class, 5);
        System.out.println(Arrays.toString(array));
        // 3. @Override - The method is comes from the super class and here becomes implementation
        // 4. @Target(Where it will be used) - Annotation for the goal of the annotation
        // 5. @Retention(When it will be used) - Annotation for the using time of the annotation
        // 6. Obtain the Annotation via .getAnnotation(AnnotationName.class):
        Annotation annotation = Warning.class.getAnnotation(Target.class);
        System.out.println(annotation);
        // 7. Obtain the annotation's array with .class.getAnnotations():
        Annotation[] annotations = Warning.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        // 8. Obtain the values of the parameter's annotations of  a method via .getParameterAnnotations().
        // It works when the annotation works on runtime (The annotation have to have its own annotation - RetentionPolicy.RUNTIME)
        Method method = AnnotationsExample.class.getMethod("do2", String.class, String.class);
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        System.out.println(Arrays.deepToString(parametersAnnotations));
        // 9. Obtain the field's or method's annotations via .declaredAnnotations():
        Field field = AnnotationsExample.class.getDeclaredField("field1");
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        System.out.println(Arrays.toString(fieldAnnotations));

        Annotation[] methodAnnotations = method.getDeclaredAnnotations();
        System.out.println(Arrays.toString(methodAnnotations));
        // 10.
    }

}
