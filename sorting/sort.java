import java.util.*;
public class sort{
    public static void main(String args[]){
        int arr[] = {3,5,2,1,4};
        // bubble(arr);
        //selectionSort(arr);
        // insertion(arr);
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // bubble Sort
    static void bubble(int arr[]){
        boolean swapped;
        for(int i=0 ; i<arr.length ; i++){
            swapped = false;
            for(int j=1 ; j<=arr.length-i-1 ; j++){
                // swap if the item is smaller then the previous item 
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if we did not swap for a particular value of i, it means the array is sorted 
            // so we donot need to swap or check more we can directly stop the program
            if(!swapped){
                break;
            }
        }
    }


    // selection sort 

    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            //find the max element in the remaining array and swap with correct index
            int last = arr.length- i- 1;
            int maxIndex = getMaxIndex(arr , 0 , last);
            swap(arr , maxIndex , last);
        }
    }

    public static int getMaxIndex(int arr[] , int start , int end){
        int max = start;
        for(int i=start ; i<=end ; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    public static void swap(int arr[] , int first , int sec){
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }


    // insertion Sort 
    public static void insertion(int[] arr){
        for(int i = 0 ; i< arr.length -1; i++){
            for(int j= i+1 ; j>0 ; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr , j , j-1);
                }else{
                    break;
                }
            }
        }
    }

    // Cyclic Sort 
    public static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!= arr[correct]){
                swap(arr , i , correct);
            }else{
                i++;
            }
        }
    }
}