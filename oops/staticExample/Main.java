package staticExample;

public class Main {
    public static void main(String[] args) {
        // Human Gauri = new Human(20 , "Gauri Singhal" ,100000 , false);
        // Human Rahul = new Human(29 , "Rahul Grover" ,110000 , true);
        // Human Ravi = new Human(29 , "Ravi Grover" ,130000 , true);

        // System.out.println(Gauri.name);
        // System.out.println(Rahul.age);
        // // here both the humans must show 2 because there are two humans but both of them are showing 1 because the population is a different instanse variable for both of them 
        // // so here is a need of static arrises 
        // // the property that are not really related to the object but are common to all the objects of the object are to be made static
        // System.out.println(Gauri.population);
        // // System.out.println(Rahul.population);
        // // here we can access population by this there will be no error but by convention the name of the class is used instead of teh name of the object
        // System.out.println(Human.population);


    }
    // here if greeting is not static so it can not be referenced to a static constant
    // A static method can only access static data
    // we know that something that is not static belongs to an object
    void greeting(){
        System.out.println("Hello World");
    }


    public static void fun(){
    Main obj = new Main();
    obj.greeting();

    }
}

// we can access greeting by making an obj for example 



// agr hum kisi variable ko static banate hai then we can use it without making the objects
// for example we have public static void main --- it is the first thing that is loaded in the java program 
// if it was not static then we firstly have to create an object to run it but it is static so we can easily be able to run it without making any object
// one more thing we cannot have a non sttic member inside a static one but we can have a static member inside a non static one 
