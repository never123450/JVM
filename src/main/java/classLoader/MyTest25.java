package classLoader;

public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("CLass : " + classLoader.getClass());
        System.out.println("Parent : " + classLoader.getParent().getClass());
        //CLass : class sun.misc.Launcher$AppClassLoader
        //Parent : class sun.misc.Launcher$ExtClassLoader
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}