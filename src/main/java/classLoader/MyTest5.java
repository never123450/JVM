package classLoader;

import java.util.Random;

/*
    当一个接口在初始化时，并不要求其父接口都完成了初始化
    只有在真正使用到父接口的时候（如引用父接口中所定义的常量时），才会初始化

 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b1);
    }
}

interface MyParent5 {

    public static int a = 5;
    public static int a1 = new Random().nextInt(2);

}

interface MyChild5 extends MyParent5 {
    public static final int b = 6;

    public static final int b1 = new Random().nextInt(2);
}