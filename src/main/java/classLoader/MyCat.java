package classLoader;

public class MyCat {
    public MyCat() {
        System.out.println("Mycat is loaded by :" + this.getClass().getClassLoader());
    }
}