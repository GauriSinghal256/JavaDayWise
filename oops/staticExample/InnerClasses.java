package staticExample;

class Test{
       static String name;

       public Test(String name){
        this.name = name;
       }
    }
// here is a point that we need to note it is that the outermost class cant be static because they itself cannot be dependent on any class
// like InnerClasses cant be static if we made it static it will give error
//inner classes can be static
public class InnerClasses {
    public static void main(String[] args) {
        Test a = new Test("Gauri");
        Test b = new Test("Rahul ");
        System.out.println(a.name);
        System.out.println(b.name);
    }
}
