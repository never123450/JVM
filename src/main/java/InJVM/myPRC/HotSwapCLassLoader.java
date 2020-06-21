package InJVM.myPRC;

/**
 * @description: 为了多次载入执行类而加入的加载器
 * 把defineClass方法开放出来，只有调用的时候才会用到loadByte方法
 * 有虚拟机调用时，仍然按照原有的双亲委派规则使用loadClass方法进行类加载
 * @author: xwy
 * @create: 6:14 PM 2020/6/21
 **/

public class HotSwapCLassLoader extends ClassLoader {

    public HotSwapCLassLoader() {
        super(HotSwapCLassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}