package day2;

import java.util.*;
public class Day2Arrays2D {    
    // Linear Search in 2D array 
    public static int[] search(int arr[][], int key){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; j++){
               if(arr[i][j] == key){
                return new int[]{i , j};
               }
            }
        }
        return new int[]{-1 , -1};
    }

    // maximum in 2d array 
    public static int maximum(int arr[][]){
        int max = Integer.MIN_VALUE;
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] > max) {
                    max = arr1[j];
                }
            }
        }
        return max;
    }

    // https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

    // Shortcut to find number of digits 
    public static int digits2(int num){
        if(num < 0){
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        return (int)(Math.log10(num))+1;
    }

    public static int digits(int num){
        int count = 0;
        if(num < 0){
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        while(num>0){
            count++;
            num= num/10;
        }
        return count;
    }
    public static boolean even(int num){
        int numberOfDigits = digits(num);
        return numberOfDigits % 2 == 0;

    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }

    // another method to solve this problem 
    public static int findNumbers2(int[] nums) {
        int count = 0;
        for(int num : nums){
            String str = String.valueOf(num);
            int digits = str.length();
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }
    
    // https://leetcode.com/problems/richest-customer-wealth/description/

    public static int maximumWealth(int[][] accounts){
        int max = 0;
        for(int i=0 ; i<accounts.length ; i++){
            int sum = 0;
            for(int j=0 ; j<accounts[i].length ; j++){
               sum = sum+accounts[i][j];
            }
            if(sum >max){
                max = sum;
            }
        }
        return max;
    }

    // Order-Acorstic Binary Search 
    public static int OABinarySearch(int arr[] , int key){
        int start = 0;
        int end = arr.length-1;
       
        // find whether this array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start<=end){
           int mid = start+(end - start)/2;

            if(key == arr[mid]){
                return mid;
            }
            if (isAsc){
                if(key > arr[mid]){
                    start = mid + 1;
                }else{
                    end = mid-1;
               }
            } else{
                if(key > arr[mid]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
            
        }
        return -1;
    }




    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];     //number of rows are mandatory, number of columns are not mendatory
        
        // If we perform sysop(arr2.length) it will give us the number of rows 
        // input
        // for(int row = 0 ; row <arr.length ; row++ ){
        //     for(int col=0 ; col<arr[row].length ; col++){
        //         arr[row][col] = sc.nextInt();
        //     }
        // }
        // // output
        // for(int row = 0 ; row <arr.length ; row++ ){
        //     for(int col=0 ; col<arr[row].length ; col++){
        //         System.out.print(arr[row][col] + " "); 
        //     }
        //     System.out.println();
        // }

        // // output using .toString() method 
        // for(int row = 0 ; row <arr.length ; row++ ){
        //     System.out.println(Arrays.toString(arr[row]));
        // }

        // // enhance for loop 
        // for(int[] a : arr){
        //     System.out.println(Arrays.toString(a));
        // }

         int[][] arr2 = {
            {1,2,3},
            {4,5,6,1},
            {7,8,9}
        }; 
        // int target = 6;
        // int ans[] = search(arr2 , target);
        // System.out.println(Arrays.toString(ans));

        // System.out.println(maximum(arr2));

        int nums[] = {1 , 22 , 3,45 , 5 , 67};
        System.out.println(findNumbers2(nums));


    }
}
