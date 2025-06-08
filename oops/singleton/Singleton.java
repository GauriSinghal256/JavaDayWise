package singleton;

// we want that only one instance can be there 
// So we must not allow anyone to call the constructor 
// if we allow to call the constructer then new instanses will be formed
// so we can make it private so no can be able to make the instance out of the class
public class Singleton {

    private Singleton() {

    }

    private static Singleton instance;

    public static Singleton getInstance(){
        // check whether 1 obj only is created or not 
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
      
}