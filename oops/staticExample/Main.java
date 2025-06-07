package staticExample;

public class Main {
    public static void main(String[] args) {
        Human Gauri = new Human(20 , "Gauri Singhal" ,100000 , false);
        Human Rahul = new Human(29 , "Rahul Grover" ,110000 , true);

        System.out.println(Gauri.name);
        System.out.println(Rahul.age);
        // here both the humans must show 2 because there are two humans but both of them are showing 1 because the population is a different instanse variable for both of them 
        // so here is a need of static arrises 
        // the property that are not really related to the object but are common to all the objects of the object are to be made static
        System.out.println(Gauri.population);
        System.out.println(Rahul.population);

    }
}
