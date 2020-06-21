package byteCode;

/*
 * 1.使用javap -verbose命令分析一个字节码文件时，将会分析该字节码文件的魔数、版本号、常量池、类信息、构造方法、类中的方法信息、
 * 类变量与成员变量等信息
 *
 * 2.魔数：所有的.class字节码文件的前4个节点都是魔数，魔数值为固定值:0xCAFEBABE  （咖啡宝贝）
 *
 * 3.魔数之后的4个字节为版本信息，前两个字节表示minor version（次版本号），后两个字节major version
 * （主版本号），这里 00000031 换算成十进制，表示版本号为0，主版本号为49  （16*3+1）。所以该文件的版本号为
 * 1.8.0_161  ？？？？？？不知道怎么算。可以通过java -version命令来验证这一点
 *
 * 4.常量池（constant pool）：紧接着主版本号之后就是常量池入口。一个java类定义的很多信息都是由常量池维护和描述的。
 * 可以将常量池看作class文件的资源仓库。比如说java类中定义方法与变量信息，都是存储在常量池中，常量池中主要存储2类常量：
 * 字面量与符号引用。字面量如文本字符串，java中声明为final的常量等，而符号引用如类和全局限定名，字段的名称和描述符，
 * 方法的名称和描述符。
 *
 * 5.常量池的总体结构：java类所对应的常量池主要由常量池数量与常量池数组这2部分共同组成。常量池数量紧跟在主版本后面，占据
 * 2个字节；常量池数组紧跟在常量池数量之后。常量池数组与一般的数组不同的是，常量池数组中的元素的类型结构都是不同的，长度当然不同；
 * 但是，每一种元素的第一个数据都是一个u1类型，该字节是个标志位，占据1个字节。JVM在解析常量时，会根据这个u1类型来获取元素的具体类型
 * 值得注意的是：常量池数组中元素的个数 = 常量池数-1（其中0暂时不使用）。目的是满足某些常量池索引值的数据在特定情况下需要表达
 * 「不引用任何一个常量池」的含义，根本原因在于索引为0也是一个常量（保留常量），只不过它不位于常量表中，这个常量就对于null值，
 * 所以，常量池的索引从1开始而非0开始。
 *

    在JVM规范中，每个变量/字段都有描述信息，描述信息主要的作用是描述字段的数据类型、方法的参数列表（包括数量、类型与顺序）与
    返回值，根据描述符规则，基本数据类型和代表无返回值的void类型都用一个大写字符来表示，而对象类型则使用字符L加对象的全限定
    名称来表示。为了压缩字节码文件的体积，对于基本数据类型，JVM都只使用一个大写字母来表示，如下所示：
    B - byte, C - char, D - double, F - float, I - int , L - long , S - shot , Z - boolean , V - void,
    L - 对象类型 如：Ljava/lang/Stirng;


    7.对于数组类型来说，每一个维度使用的一个前置的[来表示，如int[] 被记录为[I,String[][]被记录为[[Ljava/lang/String;

        8.用描述符描述方法的时候，按照先参数列表，后返回值的顺序来描述的。参数列表按照参数的严格顺序放在一组()之内，如方法
    String getRealnamebyIdAndNickname(int id,String name)的描述符为 (I,Ljava/lang/Stirng;) Ljava/lang/String;


    Class字节码结构：
        Class字节码中有2种数据类型
            自己数据直接量：这是基本的数据类型。共细分为u1、u2、u4、u8四种，分别代表连续的1个字节、2个字节、4个字节和8个字节
            组成的整体数据。
            表（数组）：表是由多个基本数据或其他表按照既定的顺序组成的大的数据集合。表是有结构的，它的结构体现在：组成表的成分
            所在的位置和顺序都是已经严格定义好的。
    java1.7以前只有11种数据类型的结构，在jdk1.7之后又增加了3种

    Access_Flag访问标志
        访问标志信息包括Class文件是类还是接口，是否被定义成public，是否是abstract，如果是类，是否被声明成final。

    字段表集合
        字段表用于类和接口中声明的变量。这里的字段包含了类级别变量以及实例变量，但是不包括方法内部声明的局部变量。




 *
 *
 */
public class MyTest1 {
    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
/*
执行命令：
javap -c classes.byteCode.MyTest1
结果：
警告: 二进制文件classes.byteCode.MyTest1包含byteCode.MyTest1
Compiled from "MyTest1.java"
public class byteCode.MyTest1 {
  public byteCode.MyTest1();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_1
       6: putfield      #2                  // Field a:I
       9: return

  public int getA();
    Code:
       0: aload_0
       1: getfield      #2                  // Field a:I
       4: ireturn

  public void setA(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #2                  // Field a:I
       5: return
}
 */

/*

javap -c classes.byteCode.MyTest1
警告: 二进制文件classes.byteCode.MyTest1包含byteCode.MyTest1
Compiled from "MyTest1.java"
public class byteCode.MyTest1 {
  public byteCode.MyTest1();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_1
       6: putfield      #2                  // Field a:I
       9: return

  public int getA();
    Code:
       0: aload_0
       1: getfield      #2                  // Field a:I
       4: ireturn

  public void setA(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #2                  // Field a:I
       5: return
}

javap -verbose classes.byteCode.MyTest1

警告: 二进制文件classes.byteCode.MyTest1包含byteCode.MyTest1
Classfile /Users/xuwenyan/Downloads/study/jvm/target/classes/byteCode/MyTest1.class
  Last modified 2019-5-9; size 463 bytes
  MD5 checksum 377a0cbb11cbe77f4e7b77dd86a6725a
  Compiled from "MyTest1.java"
public class byteCode.MyTest1
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#21         // byteCode/MyTest1.a:I
   #3 = Class              #22            // byteCode/MyTest1
   #4 = Class              #23            // java/lang/Object
   #5 = Utf8               a
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               LbyteCode/MyTest1;
  #14 = Utf8               getA
  #15 = Utf8               ()I
  #16 = Utf8               setA
  #17 = Utf8               (I)V
  #18 = Utf8               SourceFile
  #19 = Utf8               MyTest1.java
  #20 = NameAndType        #7:#8          // "<init>":()V
  #21 = NameAndType        #5:#6          // a:I
  #22 = Utf8               byteCode/MyTest1
  #23 = Utf8               java/lang/Object
{
  public byteCode.MyTest1();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #2                  // Field a:I
         9: return
      LineNumberTable:
        line 3: 0
        line 4: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  this   LbyteCode/MyTest1;

  public int getA();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: getfield      #2                  // Field a:I
         4: ireturn
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LbyteCode/MyTest1;

  public void setA(int);
    descriptor: (I)V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: iload_1
         2: putfield      #2                  // Field a:I
         5: return
      LineNumberTable:
        line 11: 0
        line 12: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       6     0  this   LbyteCode/MyTest1;
            0       6     1     a   I
}
SourceFile: "MyTest1.java"


 */