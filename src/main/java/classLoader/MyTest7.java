package classLoader;

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());//nul

        Class<?> clazz2 = Class.forName("classLoader.C");
        System.out.println(clazz2.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2

    }

    public MyTest7(){

    }
}

class C{

}