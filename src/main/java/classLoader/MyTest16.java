package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public MyTest16(String classLoaderName) {
        super();//将系统类加载器当做该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super();//显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) {

        //只要class在本工程的classes目录下就不执行
        //如果把class文件放到别的路径下面就会执行

        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");

        try {
//            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("/Users/xuwenyan/Downloads/study/jvm/target/classes");
        loader1.setPath("/Users/xuwenyan/Downloads/study/");

        Class<?> clazz = loader1.loadClass("classLoader.MyTest7");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("------------------------------");


//        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("/Users/xuwenyan/Downloads/study/");
//        Class<?> clazz2 = loader2.loadClass("classLoader.MyTest7");
//        System.out.println("class: " + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//        System.out.println("------------------------------");


        //loader1作为loader2的父加载器
        //loader1已经加载过了，不会再加载一遍，所以，不会输出findClass的内容
//        MyTest16 loader2 = new MyTest16(loader1, "loader2");
//        loader2.setPath("/Users/xuwenyan/Downloads/study/");
//        Class<?> clazz2 = loader2.loadClass("classLoader.MyTest7");
//        System.out.println("class: " + clazz2.hashCode());
//        Object object22 = clazz2.newInstance();
//        System.out.println(object22);
//        System.out.println("------------------------------");


//        MyTest16 loader3 = new MyTest16(loader2, "loader3");
//        loader3.setPath("/Users/xuwenyan/Downloads/study/");
//        Class<?> clazz3 = loader2.loadClass("classLoader.MyTest7");
//        System.out.println("class: " + clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);
//        System.out.println("------------------------------");


        loader1 = null;
        clazz = null;
        object = null;

        System.gc();
        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/xuwenyan/Downloads/study/");

        clazz = loader1.loadClass("classLoader.MyTest7");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
        System.out.println("------------------------------");

    }

}