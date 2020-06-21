package InJVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 线程长时间停顿的主要原因有：等待外部资源（数据库连接，网络资源，设备资源等）
 * 死循环、锁等待（活锁，死锁）
 * @author: xwy
 * @create: 10:20 AM 2020/6/12
 **/

public class CreateBustThreadTest {

    // 线程死循环演示
    public static void chreteBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) ;//
        }, "testBusyThread");

        thread.start();
    }

    // 线程锁等待演示
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testLockThread");

        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        chreteBusyThread();
        br.readLine();

        Object o = new Object();
        createLockThread(o);
    }

}