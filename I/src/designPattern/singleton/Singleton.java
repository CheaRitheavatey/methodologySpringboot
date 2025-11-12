package designPattern.singleton;

public class Singleton {
    // create private static var that is the ONLY instance of the class
    private static Singleton instance;

    // create a private constrctor (its private cuz to make sure that client cannot access it)
    private Singleton() {}

    // create public access point to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
