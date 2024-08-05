package T07ReflectionAndAnnotation.Lab.Demos.Annotation;

import java.lang.reflect.Array;

public class AnnotationsExample<T> {
    @Deprecated
    @Warning(warn1 = "a", warn2 = "b")
    private String field1;

    @Deprecated
    public void do1() {

    }

    @SuppressWarnings(value = "unchecked")
    public T[] createArray(Class<T> clazz, int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

    @Warning(warn1 = "Solve problems", warn2 = "Be smart")
    public void do2(
            @ParameterWarning(warn1 = "a", warn2 = "a")
            String text1,
            @ParameterWarning(warn1 = "b", warn2 = "b")
            String text2) {
    }

}
