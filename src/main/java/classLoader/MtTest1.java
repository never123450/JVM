package classLoader;

/*
     System.out.println(MyPaernt1.strPaernt);表明-->
        对于静态字段来说，只有直接定义了该字段的类才会被初始化
     System.out.println(MyChild1.strChild);表名-->
        当一个类在初始化时，要求其父类全部都初始化完毕了
     -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来

     -XX:+<option>, 表示开启option选项
     -XX:-<option>, 表示关闭option选项
     -XX:-<option>=<value>,表示将option选项的值设置为value




 */
public class MtTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.strChild);
//        System.out.println(MyPaernt1.strPaernt);
    }
}

class MyPaernt1 {

    public static String strPaernt = "strPaernt";

    static {
        System.out.println("MyParent static block");
    }

}

class MyChild1 extends MyPaernt1 {

    public static String strChild = "strChild";

    static {
        System.out.println("MyChild1 static block");
    }
}

