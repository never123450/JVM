package annotationTest;

import java.lang.annotation.*;
 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapt {
  Class<?> value();
}