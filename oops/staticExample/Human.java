package staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static  long population;

    public Human(int age , String name , int salary , boolean married){
        this.age=age;
        this.name = name;
        this.salary = salary;
        this.married = married;

        // this.population+=1;
        // in order to use the static variable we need the class name
        Human.population += 1 ;
    }
}
