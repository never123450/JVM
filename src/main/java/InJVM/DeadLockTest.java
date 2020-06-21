package InJVM;

/**
 *
 * @description: 死锁等待
 *
 * @author: xwy
 *
 * @create: 10:30 AM 2020/6/12
**/

public class DeadLockTest {
    static class SynaddRunnable implements Runnable{

        int a,b;

        public SynaddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynaddRunnable(1,2)).start();
            Thread.sleep(50);
            new Thread(new SynaddRunnable(2,1)).start();
        }
    }
}