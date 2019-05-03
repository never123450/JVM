package classLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        String resourceName = "classLoader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("--------------------");

        Class<?> clazz = String.class;
        System.out.println(clazz.getClassLoader());
        //获取当前类的CLassLoader
        clazz.getClassLoader();
        //获得当前线程上下文的CLassLoader
        Thread.currentThread().getContextClassLoader();
        //获得系统的CLassLoader
        ClassLoader.getSystemClassLoader();
        //获得调用者的ClassLoader
//        DriverManager.getCallerClassLoader();
    }
}