package introToOops;

public class WrapperExample{
    public static void main(String[] args){
        // a is primitive
        // int a = 10;
        // int b = 20;
        // num is object
        // we have so many functions with the objects that we can use to easy our work
        // Integer num = 45;

        // swap(a,b);
        // System.out.println(a + " " + b);
        Integer a = 10;
        Integer b = 20;
        swap2(a,b);
        System.out.println(a+" "+b);

        // final int bonus = 2;
        // bonus = 3;
        // it is giving error because we cannot modify it 

    }

    // java pass the reference by value  so if we want that a nad b must be swap so we cannot do it like
    // but when we passes objects then references values are passed 
    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    // still not swapping
    // because Integer uses final keyword 
    // if we use final keyword than we cannot modify the value of the variable
    // It is basically the case of primitives 
    static void swap2(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;

       final A gauri = new A("Gauri");
       // we can do it like this that we can change the name 
       gauri.name = "Gauri Singhal";
       //  we cant do it like - when a non primitive is final you cannot re assign it we can change the valuee but we cannot re initialize it
       // gauri = new A("new object");
    }
}

// always initialise the final variable while declaring because we cannot modify it so we need to tell the value
class A {
    final int num = 10;
    String name ;
    public A(String name){
        this.name = name;
    }
}