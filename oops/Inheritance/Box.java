public class Box{
    double l;
    double w;
    double h;
    Box(){
        this.h = -1;
        this.w = -1;
        this.l = -1;
    }

    // cube
    Box(double side){
        this.h = side;
        this.w = side;
        this.l = side;
    }

    Box(double l, double w, double h){
        this.h = h;
        this.w = w;
        this.l = l;
    }
    // copy constructor - it is a technique to create a new object as a copy of an existing object
    Box(Box old){
        this.h = old.h;
        this.w = old.w;
        this.l = old.l;
    }

    public void information(){
        System.out.print("the length is " + this.l + " the width is " + this.w + " the height is " + this.h);
    }
}