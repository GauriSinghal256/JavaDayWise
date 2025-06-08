package properties.inheritance;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight(){
       this.weight = -1;
    }

    public BoxWeight(double l, double h, double w , double weight){
        super(l , w, h);
        // what is the above line saying ?? call the parent class constructor
        // used to initialize values in parent class
        this.weight = weight;
    }
}
