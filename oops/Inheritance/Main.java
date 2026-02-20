public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(5);
        Box box3 = new Box(2, 3, 4);
        Box box4 = new Box(box3);
        BoxWeight box5 = new BoxWeight();
        Box box6 = new BoxWeight(2, 3, 4, 5);
        // box1.information();
        // System.out.println();
        // box2.information();
        // System.out.println();
        // box3.information();
        // System.out.println();
        // box4.information();
        System.out.println(box5.h + " " + box5.w + " " + box5.l + " " + box5.weight);
        // System.out.println(box6.weight);
        // here we are not able to access the weight of box6 because it is of type Box and it does not have the weight variable. To access the weight variable, we need to cast the box6 object to BoxWeight type.
            BoxWeight box7 = (BoxWeight) box6; // downcasting - in downcasting what happens is that the 
            System.out.println(box7.weight);
        
            // BoxWeight box8 = new Box(2,3,5);
            // it gives an error because we cannot assign a parent class object to a child class reference variable. This is called upcasting and it is not allowed in Java. Upcasting is when we assign a child class object to a parent class reference variable. Downcasting is when we assign a parent class object to a child class reference variable. Upcasting is allowed in Java because it is safe, but downcasting is not allowed because it can lead to ClassCastException at runtime if the object being casted is not of the correct type.
        

    }
}   
