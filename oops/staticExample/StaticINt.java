package staticExample;

// this is a demo to show initialization of static variables
public class StaticINt{
    static int a =4;
    static int b;

    static{
        System.out.println("I am in static block");
        b = a*5;
    }

    public static void main(String[] args) {
        StaticINt obj = new StaticINt();
        System.out.println(StaticINt.a + " " + StaticINt.b);

        StaticINt.b += 3;
        System.out.println(StaticINt.a + " " + StaticINt.b);


        StaticINt obj2 =new StaticINt();

    }
}