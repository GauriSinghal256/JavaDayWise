public class binarysearch{

    public static int BinarySearch(int arr[] , int target){
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
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,8,16,23,45};
        System.out.println(BinarySearch(arr, 23)); // should return 5
        System.out.println(BinarySearch(arr, 24)); // should return -1
    }
}