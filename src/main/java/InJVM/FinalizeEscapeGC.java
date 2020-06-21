package InJVM;

/**
 * @description: 此代码演示了2点：
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多被系统执行一次
 * @author: xwy
 * @create: 6:34 AM 2020/6/10
 **/

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_hook = null;

    public void isAlive() {
        System.out.println("yes ,iam still alive;");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_hook = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_hook = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_hook = null;
        System.gc();
        // 因为finalize方法优先级很低，使用暂停0.5s
        Thread.sleep(500);
        if (SAVE_hook != null) {
            SAVE_hook.isAlive();
        } else {
            System.out.println("no , im dead");
        }

        //下面这段代码与上面完全相同， 但是这次自救失败
        SAVE_hook = null;
        System.gc();
        // 因为finalize方法优先级很低，使用暂停0.5s
        Thread.sleep(500);
        if (SAVE_hook != null) {
            SAVE_hook.isAlive();
        } else {
            System.out.println("no , im dead");
        }
    }
}