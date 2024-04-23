// Singleton Design Pattern

// Creational Design Pattern
// One Instance
// Centralized point of access to the single instance

public class Singleton {

    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        synchronized(Singleton.class){
            if(!instance){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
