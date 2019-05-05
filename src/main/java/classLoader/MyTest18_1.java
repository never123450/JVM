package classLoader;

public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/xuwenyan/Downloads/study/");

        Class<?> clazz = loader1.loadClass("classLoader.MyTest7");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());
    }

}