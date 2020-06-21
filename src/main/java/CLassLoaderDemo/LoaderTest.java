package CLassLoaderDemo;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 指定class 进行加载e
 */
public class LoaderTest {
    public static void main(String[] args) throws Exception {
        URL classUrl = new URL("file:D:\\");//jvm 类放在位置

        URLClassLoader parentLoader = new URLClassLoader(new URL[]{classUrl});

        while (true) {
            // 创建一个新的类加载器  加上parent，parent是同一个热部署效果会失效，这就是双亲委派的效果
            URLClassLoader loader = new URLClassLoader(new URL[]{classUrl},parentLoader);

            // 因为都是不同的CLassLoader来加载类，所以热部署效果是有的，像tomcat加载jsp就是这种原理，还有其他的热部署框架
//            URLClassLoader loader = new URLClassLoader(new URL[]{classUrl});

            // 问题：静态块触发
            Class clazz = loader.loadClass("HelloService");
            System.out.println("HelloService所使用的类加载器：" + clazz.getClassLoader());

            Object newInstance = clazz.newInstance();
            Object value = clazz.getMethod("test").invoke(newInstance);
            System.out.println("调用getValue获得的返回值为：" + value);

            Thread.sleep(3000L); // 3秒执行一次
            System.out.println();

            //  help gc  -verbose:class
            newInstance = null;
            loader = null;

        }

        // System.gc();
    }
}
