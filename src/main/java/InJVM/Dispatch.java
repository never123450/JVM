package InJVM;

/**
 * @description:
 * @author: xwy
 * @create: 7:31 PM 2020/6/18
 **/

public class Dispatch {

    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son chooose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}