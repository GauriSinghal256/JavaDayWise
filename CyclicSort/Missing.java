public class Missing {
    public static void main(String[] args) {
        
    }
    public static int missingNumber(int[] arr){
       int i =0;
        while(i < arr.length){
           int correct = arr[i];
           if(arr[i] <arr.length && arr[i] != arr[correct]){
            swap(arr , i , correct);
           } else{
            i++;
           }
        } 
        // search for first missing number
        for(int index=0 ; index< arr.length ; index++){
            if(arr[index] != index){
                return arr[index];
            }
        }
        return arr.length;
    }

    static void swap(int arr[] , int first  , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
