public class BoxWeight extends Box {
    double weight;
    BoxWeight(){
        this.weight = -1;
    }        
    BoxWeight(double l, double w, double h, double weight){
        super(l, w, h); // it is used to call the constructor of the parent class
        this.weight = weight;
       // super.weight = weight; // it is used to access the weight variable of the parent class
      //  if we were having the weight variable in the parent class then we could have used super.weight to access it, but since we do not have it in the parent class, we are using this.weight to access it in the child class.

    }
}
