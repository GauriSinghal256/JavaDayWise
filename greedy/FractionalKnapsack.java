
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    // given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum totall value in the knapsack
    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int W = 50;
        
        double ratio[][] = new double[value.length][2];
        // 0th col => idx , 1st col =>ratio
        for(int i=0 ;i<value.length ; i++){
            ratio[i][0] =i;
            ratio[i][1] =  value[i]/(double)weight[i];
        }

        // ascending order
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalvalue = 0;
        for(int i=ratio.length-1 ; i>=0 ; i--){
            int idx = (int)ratio[i][0];
            if(capacity >=weight[idx]){ // include full item
                finalvalue += value[idx];
                capacity -= weight[idx];
            }else{
                finalvalue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println(finalvalue);
    }
}
