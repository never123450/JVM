package classLoader;

public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = 3;

    static void doSomething() {
        System.out.println("do something");
    }

    static {
        System.out.println("Parent3 static block");
    }
}

class Child3 extends Parent3 {

    static {
        System.out.println("Child3 static block");
    }
}