package classLoader;

/*

    常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
    本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化

    注意：这里指的是将常量存放到了MtTest2的常量池中，之后MYtest2与myParent2没有任何关系
         甚至，我们可以将MYpaernt2的class文件的类删除

    助记符：
    ldc表示将int，float或者是String类型的常量值从常量池中推送至栈顶
    bipush表示将单字节(-128 ~ 127)的常量值推送至栈顶
    sipush表示将一个短整型常量值（-32768 ~ 32767）推送至栈顶
    iconst_1表示int类型1推送中栈顶（iconst_m1 ~ iconst_5）


 */
public class MtTest2 {

    public static void main(String[] args) {
        System.out.println(MyPaernt2.m);
    }
}

class MyPaernt2 {

    //final：调用这个常量的方法所在的类的常量池当中
    //加final和不加final的区别
    public static final String strPaernt = "strPaernt";

    public static final short s = 7;

    public static final int i = 128;

    public static final int m = 1;

    static {
        System.out.println("MyParent static block");
    }

}

//class MyChild2 extends MyPaernt2 {
//
//    public static String strChild = "strChild";
//
//    static {
//        System.out.println("MyChild1 static block");
//    }
//}