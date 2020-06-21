package byteCode;


/**
 * @description:
 * @author: xwy
 * @create: 9:27 PM 2019/5/27
 **/


/**
 * 方法的静态分派
 * Grandpa g1 = new Fahther();
 * <p>
 * 以上代码，g1的静态类型是Grande，而g1的实际类型（真正指向的类型）是Father
 * <p>
 * 我们可以得出这样一个结论：变量的静态类型是不会发生变化的，而变量的实际类型是可以发生变化的（多态的体现）
 * 实际上类型是在运行期方可确定的
 */
public class MyTest5 {

    //方法的重载，是一种静态的行为，编译器完全可以确定

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Fahther fahther) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Fahther();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();

        myTest5.test(g1);
        myTest5.test(g2);
    }

}

class Grandpa {

}

class Fahther extends Grandpa {

}

class Son extends Fahther {

}