package singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        // both 2 reference variable are pointing to just one object

    }
}
