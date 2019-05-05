package classLoader;

/*

    关于命名空间的重要说明：
        子加载器所加载的类能够访问父加载器所加载的类
        父加载器所加载的类无法访问子加载器所加载的类

 */
public class MyTest17_1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/xuwenyan/Downloads/study/");

        Class<?> clazz = loader1.loadClass("classLoader.MySample");
        System.out.println("class: " + clazz.hashCode());

        //如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就会加载MyCat .class

        Object object = clazz.newInstance();

    }

}