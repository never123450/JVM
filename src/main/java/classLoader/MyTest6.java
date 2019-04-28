package classLoader;

/*



 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);
    }
}

class Singleton {
    public static int counter1 = 1;
//    public static int counter2 = 0;//位置换到下面

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;

        System.out.println("counter1111:" + counter1);
        System.out.println("counter2222:" + counter2);
    }

    public static int counter2 = 0;//从上面的位置换到这

    public static Singleton getInstance() {
        return singleton;
    }
}