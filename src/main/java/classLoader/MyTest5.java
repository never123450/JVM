package classLoader;

import java.util.Random;

/*
    当一个接口在初始化时，并不要求其父接口都完成了初始化
    只有在真正使用到父接口的时候（如引用父接口中所定义的常量时），才会初始化

 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyGrandpa.thread);
    }
}

interface MyParent5 {

    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };

}

interface MyGrandpa{
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}

interface MyChild5 extends MyGrandpa {
    public static int b = 5;
}

