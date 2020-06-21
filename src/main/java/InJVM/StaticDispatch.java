package InJVM;

/**
 *
 * @description:  重载 ： 静态分派
 *
 * @author: xwy
 *
 * @create: 6:48 PM 2020/6/18
**/

public class StaticDispatch {

    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy){
        System.out.println("hello guy");
    }

    public void sayHello(Man guy){
        System.out.println("hello gentleMan");
    }

    public void sqyHello(Woman huy){
        System.out.println("hello,lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}