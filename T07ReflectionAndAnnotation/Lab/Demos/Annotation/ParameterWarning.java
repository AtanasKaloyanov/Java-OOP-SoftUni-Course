package T07ReflectionAndAnnotation.Lab.Demos.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface ParameterWarning {
    String warn1() default "def";
    String warn2() default "def";
}
