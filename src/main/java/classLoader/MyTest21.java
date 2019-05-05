package classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*

    类加载器的双亲委托机制模型的好处：

        1、可以确保Java核心类库的类型安全：所有的java应用都至少会引用java.lang.Object类，也就是在运行期，java.lang.Object
            会被加载到java虚拟机中；如果这个加载过程是由java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的
            java.lang.Object类，而且这个些类之间还是不兼容的，互相不可见的（正是命名空间在发挥着作用）
            借助于双亲委托机制，java核心类库中的类的加载工作都是由启动类加载器来统一完成加载工作，从而确保了java应用所使用的都是同一版本的核心类库，
            他们之间是相互兼容的
        2、可以确保java核心类库所提供的类不会被自定义的类所替代
        3、不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间，相同名称的类可以并存在java虚拟机中，只要用到不同的类加载器来加载他们即可
            不同类加载所加载的类之间是不兼容的，这就相当于在java虚拟机额内部创建了一个又一个相互隔离的java类空间，这类技术在很多框架中否得到了实际应用

 */
public class MyTest21 {

    //把classloader目录下的MyParent.lcass文件移动到/Users/xuwenyan/Downloads/study/

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/xuwenyan/Downloads/study/");
        loader2.setPath("/Users/xuwenyan/Downloads/study/");

        Class<?> clazz1 = loader1.loadClass("classLoader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("classLoader.MyPerson");

        //输出为false
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(object1,object2);

    }

}