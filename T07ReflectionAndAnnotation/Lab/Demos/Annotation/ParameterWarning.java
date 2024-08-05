package T07ReflectionAndAnnotation.Lab.Demos.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(value = {METHOD, PARAMETER})
public @interface ParameterWarning {
    String warn1() default "def";
    String warn2() default "def";
}
