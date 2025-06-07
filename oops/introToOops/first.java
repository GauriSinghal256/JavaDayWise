package introToOops;

public class first{
    public static void main(String[] args) {


        // object is a physical reality - actually occuping space
        // Student[] students  = new Student[5];

        Student gauri = new Student();

        // here everything we were doimg manually insted we can do it in the class only with the help of 
        // a special function called constructor . Constructor tells us that what to do when the object is being created
        gauri.name = "Gauri Singhal";
        gauri.rno = 11232628;
        gauri.marks = 91.17f;

        
        gauri.changeName("Art Lover");
        gauri.greeting();
        System.out.println(gauri.name);
        System.out.println(gauri.rno);
        System.out.println(gauri.marks);
        //System.out.println(Arrays.toString(students));

        Student alpha = new Student(15 , "alpha" , 56);
        System.out.println(alpha.name);


        Student random = new Student(gauri);

        System.out.println(random.name);
    }

}
     // defining a class 
    // it is like a template - logical construct
    class Student {
        int rno;
        String name ;
        float marks = 90;
        // we need a way to add the values of properties object by object
        // so we need one word to access every object
        // constructor

        void greeting() {
            System.out.println("Hello my name is " + name);
        }
        void changeName(String newName){
            name = newName;
        }
        
        Student (Student other){
            this.name = other.name;
            this.rno = other.rno;
            this.marks = other.marks;
        }


        // Student (){
        //   this.rno = 13;
        //   this.name = "Gauri";
        // }

        Student(){
            //this is how you can call one constructor from another constructor
            // internally it something like Student(13, "default" , 100)
            this (13, "default" , 100);
        }

        Student (int rno ,String name , int marks){
            this.rno = rno;
            this.name = name;
            this.marks = marks;
        }
    }