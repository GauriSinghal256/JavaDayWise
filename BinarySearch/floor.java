public class floor {
    public static int Floor(int arr[] , int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                 end = mid -1;
            }else{
                start= mid+1;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,8,16,23,45};
        System.out.println(Floor(arr, 23)); 
        System.out.println(Floor(arr, 24)); 
    }
}
