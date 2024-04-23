// Singleton Design Pattern

// Creational Design Pattern
// One Instance
// Centralized point of access to the single instance

public class Singleton {

    private static Singleton instance; // single instance
    private Singleton(){} //constructor

    public static Singleton getInstance(){
        synchronized(Singleton.class){
            if(instance == null){
                instance = new Singleton();
            }
        }
        return instance;
    }
}

public class main {
    public static void main(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if(s1 == s2){
            System.out.println("Same Objects");
        }
    }
}
