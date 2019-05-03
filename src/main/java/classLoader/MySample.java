package classLoader;

public class MySample {
    public MySample() {
        System.out.println("MySample is laoded by:" + this.getClass().getClassLoader());

        new MyCat();

    }
}