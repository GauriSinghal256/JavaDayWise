package properties.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();

        System.out.println(box.l + " " + box.w + " " + box.h);

        Box box2 = new Box(4);
        System.out.println(box2.l + " " + box2.w + " " + box2.h);

        Box box3 = new Box(box2);
        System.out.println(box3.l + " " + box3.w + " " + box3.h);

        // BoxWeight box4 = new BoxWeight();
        // System.out.println(box4.l + " " + box4.weight + " " + box4.h);
        // BoxWeight box5 = new BoxWeight(2,3,4,8);
        // System.out.println(box5.l + " " + box5.weight + " " + box5.h + " "+ box5.w);

        // Box box6 = new BoxWeight(2,3,4,8);
        // here we cannot access weight 
        // it is important to understand that it is actually the type of reference variable not the types of the object that determine what properties it will have

        // BoxWeight box7 = new Box(2,3,4);
        // the above line is giving error 
        // there are many variables in both parent and child classes
        // you are given access to var that are in the ref type hence you should hava ref to weight variable 
        // this also means that ones you are trying to aCCESS should be initialised
        // but here when object itself is of type parent class , how will you call the constructor of child class
    }
}
