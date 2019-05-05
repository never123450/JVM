package classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest20 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("classLoader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("classLoader.MyPerson");

        //第一次已经加载过了，第一次不会再加载，所以输出为true
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(object1,object2);

    }

}