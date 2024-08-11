package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// P05 Inject annotation:
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {

}
