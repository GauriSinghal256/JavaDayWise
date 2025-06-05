package day3;
public class Day3BSQues {

    // ceiling of a number 
    public static int ceiling(int arr[] , int key){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
           int mid = (start+end)/2;

            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return end+1;
    }
    // floor of a number 
    public static int floor(int arr[] , int key){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
           int mid = (start+end)/2;

            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }

    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static char nextGreatestLetter(char[] letters , char target){
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
           int mid = (start+end)/2;

            if(target >= letters[mid]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return letters[start % letters.length];

    }

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    // Facebook interview Question
    public static int[] searchRange(int nums[] , int target){
        int ans[] = {-1 , -1};
        // chack for the first occurance if target first 
        int start = search(nums , target , true);
        int end = search(nums , target , false);
        
        ans[0] = start;
        ans[1] = end;
        return ans;

    }

    // this function just return the value of the target 
    public static int search(int[] arr, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                // potential answer found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1; // move left
                } else {
                    start = mid + 1; // move right
                }
            }
        }

        return ans;
    }


    // Amazon Interview Question 
    // Find position of an element in a sorted array of infinite numbers
    // here basically we csn assume that we cannot  use length function as the array is infinite

     public static int ans(int[] arr , int target){
        // first find the range 
        // first start with with a box size of 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range 
        while(target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1)*2;
            start = newStart;
        }
         return BinarySearchInfinite(arr ,target , start , end );
     }

     public static int BinarySearchInfinite(int arr[] , int key, int start , int end){
        while(start<=end){
           int mid = (start+end)/2;

            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

      public static int peakIndeexInMountainArray(int arr[]){
        int start =0;
        int end = arr.length -1;

        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                // you are in the dec part of the array 
                // this may be the answer but look at left 
                // this is why end ! = mid -1;
                end = mid;
            }else{
                // you are in des part of array 
                start = mid+1; //because we know taht mid+1 element is greater than mid element

            }
        }
        // in the end start will going to be equal to end and poiinting to the largest number of the array
        // start and end are always trying to find max element in the above 2 checks 
        // so when they are pointing to just one element , that is the maximum one because that is what the checks says 
        return start;
      }


    //   https://leetcode.com/problems/find-in-mountain-array/description/
   



    // Searcch in Rotated Sorted array 
    // google and amazon interview question 
    // https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    





    
    public static void main(String[] args){
        int arr[] = {2,3,4,7,8,9,12,15};
        // System.out.println(ceiling(arr , 13));
        // System.out.println(floor(arr , 10));


        // infinite binary Search 
        int arr2[] = {3,5 , 7,9 ,10,90,100,130,140,160,170};
        System.out.println(ans(arr2 , 10));
        

    }
}
