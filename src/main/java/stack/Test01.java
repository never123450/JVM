package stack;

// 栈溢出
public class Test01 {
    private static  int COUNT;

    public static void count(){
        try {
            COUNT++;
            count();
        }catch (Throwable e){
            System.out.println("最大深度："+COUNT);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        count();
    }

}