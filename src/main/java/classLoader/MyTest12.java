package classLoader;


/*

    调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
    class.forName是对类的主动使用，会导致类的初始化

 */
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("classLoader.CL");//不会导致CL初始化
        System.out.println(clazz);

        System.out.println("------------");

        clazz = Class.forName("classLoader.CL");//会导致CL初始化
        System.out.println(clazz);
    }
}


class CL{
    static {
        System.out.println("Class CL");
    }
}