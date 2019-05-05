package classLoader;

public class MyTest18 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));//启动类加载器
        System.out.println(System.getProperty("java.ext.dirs"));//扩展类加载器
        System.out.println(System.getProperty("java.class.path"));//系统类加载器
    }
}