package bo.com.ahosfot.patterns.creation.singleton.nonThreadSafe;

public class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
