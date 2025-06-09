import java.util.*;
public class bubbleSort{
    public static void main(String args[]){
        int arr[] = {5,4,3,2,1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void bubble(int arr[]){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=1 ; j<=arr.length-i-1 ; j++){
                // swap if the item is smaller then the previous item 
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}