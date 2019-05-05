package classLoader;

/*

    在运行期，一个java类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）
    和所共同决定的。
    如果同样名字（即相同的完全限定名）的类是由2个不同的加载器所加载，那么这些类就是不同的，即便.class文件的
    字节码都是一样的，并且从相同的位置加载亦如此。

 */

/*

    在oracle的HotSpot实现中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下错误信息：

    java -Dsun.boot.class.path=./ classLoader.MyTest23
    Error occurred during initialization of VM
    java/lang/NoClassDefFoundError: java/lang/Object

 */

import sun.misc.Launcher;

public class MyTest23 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));//启动类加载器
        System.out.println(System.getProperty("java.ext.dirs"));//扩展类加载器
        System.out.println(System.getProperty("java.class.path"));//系统类加载器


        /*

            内建于JVM中的启动类加载器会加载java.lang.classLoader以及其他的java平台类
            当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，这块特殊的
            机器码叫做启动类加载器（BootStrap）

            启动类加载器并不是Java类，而其他的加载器都是java类
            启动类加载器是特定于平台的机器指令，它复杂开启整个加载过程

            所有类加载器除了启动类加载器都被实现为java类。不过总归要有一个组件来加载第一个java类加载器，从而
            让整个加载过程能够顺利进行下去，加载第一个纯java类加载器就是启动类的职责

            启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的内容等等

         */

        System.out.println(ClassLoader.class.getClassLoader());//null

        //扩展类加载器与系统类加载器也是由启动类加载器所加载的
        System.out.println(Launcher.class.getClassLoader());//null

        System.out.println("-------------");

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());

    }
}