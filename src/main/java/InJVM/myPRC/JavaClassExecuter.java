package InJVM.myPRC;


import java.lang.reflect.Method;

/**
 * @description: JavaClass 执行工具
 * @author: xwy
 * @create: 7:26 PM 2020/6/21
 **/

public class JavaClassExecuter {

    /**
     * 执行外部传过来的代表一个java类的byte数组
     * 将输入雷的byte数组中代表java.lang.System的CONSTANT_utf8_info 常量修改为劫持后的HackSystem 类
     * 执行方法为该类的static main(String[] args)方法，输出结果为该类向System.out/err输出的信息
     *
     * @param classBytes 代表一个java类的byte数组
     * @return执行结果
     */
    public static String execute(byte[] classBytes) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classBytes);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "InJVM/myPRC/HackSystem");
        HotSwapCLassLoader loader = new HotSwapCLassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}