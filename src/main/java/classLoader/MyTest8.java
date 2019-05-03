package classLoader;

import java.util.Random;

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest{
    //有final的结果为：3
    //无final的结果为 FinalTest static block     //3
    //3
    //改成x为调用random方法时 结果为 FinalTest static block     //3
    public static final int x = 3;

    public static final int y = new Random().nextInt(2);

    static {
        System.out.println("FinalTest static block");
    }
}