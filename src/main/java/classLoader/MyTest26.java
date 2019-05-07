package classLoader;

import com.sun.tools.javac.util.ServiceLoader;

import java.sql.Driver;
import java.util.Iterator;

/*

    线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();//获取

    try{
        Thread.currentThread().setContextClassLoader(targetTccl);
        myMethod();//使用
    }finally{
        Thread.currentThread().setContextClassLoader(classLoader);//还原
    }

    myMethod里面调用了 Thread.currentThread().getContextClassLoader() ，获取当前线程的上下文类加载器做某些事情。

    如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载的话）

    ContextCLassLoader的作用就是为了破坏Java的类加载委托机制。

    当高层提供了统一的接口让低层区实现，同时又要在高层加载（或实例化）低层时，就必须要通过线程上下文类加载器来帮助高层的CLassLoader
    找到并加载该类

 */
public class MyTest26 {

    public static void main(String[] args) {

        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterable = loader.iterator();
        while (iterable.hasNext()) {
            Driver driver = iterable.next();

            System.out.println("driver: " + driver.getClass() + ",loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器： " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }
}