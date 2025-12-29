import java.util.ArrayList;
import java.util.List;

public class AllMissing {
     static void swap (int arr[] , int first, int second){
        int temp =arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int i =0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!= arr[correct]){
                 swap(arr , i , correct);
            }else{
                i++;
            } 
        }
        for(int index=0 ; index< arr.length ; index++){
            if(arr[index] != index+1){
                ans.add(index+1);
            }
        }
        return ans;
    }
}
