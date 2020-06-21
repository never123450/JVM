package InJVM;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description:  -Xms100m -Xmx100m -XX:UseSerialGC
 *
 * @author: xwy
 *
 * @create: 10:09 AM 2020/6/12
**/

public class OomObject {

    public byte[] placeholder = new byte[64 * 1024];

    public static void main(String[] args) throws InterruptedException {
        List<OomObject> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(50);
            list.add(new OomObject());
        }
        System.gc();
    }
}