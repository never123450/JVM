package annotationTest;

import java.util.function.IntBinaryOperator;

public class Bar {
  @Adapt(IntBinaryOperator.class)
  public static int add(int a, int b) {
    return a + b;
  }
}