import java.util.Arrays;

public class Day1Array {

    // just remember a method Arrays.toString()




    // linear Search 
    public static int Linearsearch(int arr[] , int key){
        if(arr.length == 0){
            return -1;
        }
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    // largest number 
    public static int Largest(int arr[]){
        int Max = Integer.MIN_VALUE;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]>Max){
                Max = arr[i];
            }
        }
        return Max;
    }

    // Binary Search 
    public static int BinarySearch(int arr[] , int key){
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
        return -1;
    }

    // Reserve an array 
    public static void Reverse(int arr[]){
        int n = arr.length;
        int mid = (0+ arr.length)/2;
        for(int i=0 ; i<=mid ; i++){
            int temp;
            int start = i;
            int end = n-i-1;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        } 
    }

    // Pairs in an array 
    public static void PrintPairs(int arr[]){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=i+1 ; j<arr.length ; j++){
                System.out.print("(" + arr[i] + ", " +arr[j] + ")");
            }
        }
    }

    // Print Subarrays 
    public static void PrintSubarray(int arr[]){
        for(int i=0 ; i<arr.length ; i++){
            int start = i;
            for(int j=i ; j<arr.length ; j++){
                int end = j;
                for(int k=start ; k<=end ; k++){
                    System.out.print(arr[k] +" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Maximum Subarray Sum 
    public static int MaxSubarraysum(int arr[]){
        int max = Integer.MIN_VALUE;
        int CurrSum = 0;
        for(int i=0 ; i<arr.length ; i++){
            int start = i;
            for(int j=i ; j<arr.length ; j++){
                int end = j;
                CurrSum = 0;
                for(int k=start ; k<=end ; k++){
                    CurrSum = CurrSum+arr[k];
                }
                // System.out.print(CurrSum + " ");
                if(max<CurrSum){
                    max=CurrSum;
                }
            }
            // System.out.println();
        }
        return max;
    }

    // Prefix sum - 2nd method 
    public static int prefixSum(int arr[]){
        int max = Integer.MIN_VALUE;
        int CurrSum = 0;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0 ; i<arr.length ; i++){
            int start = i;
            for(int j=i ; j<arr.length ; j++){
                int end = j;
                CurrSum = start == 0 ? prefix[end] : prefix[end]-prefix[start];
                // System.out.print(CurrSum + " ");
                if(max<CurrSum){
                    max=CurrSum;
                }
            }
            // System.out.println();
        }
        return max;
    }

    // Kadan's Algorithm 
    public static int kadanAlgo(int arr[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for(int i=0 ; i<arr.length ; i++){
            cs = cs+ arr[i];
            if(cs<0){
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        return ms ;
    }

    // Trapping Rainwater
    public static int TrappingRainwater(int height[]){
        // calculate the left max boundary 
        int n = height.length;
        int LeftMax[] = new int[n];
        LeftMax[0] = height[0];
        for(int i=1 ; i<n ; i++){
            LeftMax[i] = Math.max(LeftMax[i-1] , height[i]);
        }
        // calculate the right max boundary
        int RightMax[] = new int[n];
        RightMax[n-1] = height[n-1];
        for(int i = n -2 ; i>=0 ; i--){
            RightMax[i] = Math.max(height[i] , RightMax[i+1]);
        }
        int trappedWater = 0;
        for(int i=0 ; i<n ; i++){
            int waterLevel = Math.min(LeftMax[i],RightMax[i]);
            trappedWater += waterLevel -height[i];
        } 
        return trappedWater;
    }

    // Buying and Selling stocks 
    public static int BuyAndSell(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0 ; i<prices.length ;i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit , profit); 
            }else{
                buyPrice  = prices[i];
            }
        }
        return maxProfit;
    }

    // Sorted And Rotated Array 

    // search in a string 
    public static boolean searchStr(String str , char target){
        if(str.length() == 0){
            return false;
        }

        for(int i=0 ; i<str.length() ; i++){
            if(target == str.charAt(i)){
                return true;
            }
        }
        return false;
    }
    // search in a string 
    // using a for each loop 
    public static boolean searchStr2(String str , char target){
        if(str.length() == 0){
            return false;
        }

        for(char ch : str.toCharArray()){
            if(ch == target){
                return true;
            }
        }
        return false;
    }
    
    // Search in range 
    // its just the simple linear search just we are given the range of index where we need to find the element 
    // so here instead of running the loop for all elements we will run the loop in the desired range
    public static int searchInRange(int arr[] , int key , int start , int end){
        if(arr.length == 0){
            return -1;
        }
        for(int i=start ; i<end ; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }




    // Given an integer array arr, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static boolean ContainDuplicate(int arr[]){
        Arrays.sort(arr); // O(n log n)
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) return true;
        }
        return false;
    }





    public static void main(String[] args) {
    //    creating an array
        // int arr[] = new int[5];
        // arr[0] = 5;
        // System.out.println(arr[0]);

        // String fruits[] = {"apple" , "mango" , "banana"};
        // for(int i = 0 ; i<fruits.length ; i++){
        //     System.out.println(fruits[i]);
        // }

        // linear Search
        int arr[] = {2 , -4, 6 , 8 , -9 ,5 , 6};
        // System.out.println(Linearsearch(arr, 62));
        // System.out.println(Largest(arr));
        //  System.out.println(BinarySearch(arr, 62));
        //   Reverse(arr);
        //   for(int i=0 ; i<arr.length ; i++){
        //     System.out.print(arr[i]+", ");
        //   }
        // PrintPairs(arr);
        // PrintSubarray(arr);
        // System.out.println(MaxSubarraysum(arr));
        // System.out.println(prefixSum(arr));
        // System.out.println(kadanAlgo(arr));
        // int height[] = {4,2,0,6,3,2,5};
        // System.out.println(TrappingRainwater(height));
        // System.out.println(ContainDuplicate(arr));
        // String name = "gauri";
        // char target = 'u';
        // System.out.println(searchStr( name , target));

        // System.out.println(Arrays.toString(name.toCharArray()));

  


        

    }
}
