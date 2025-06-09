package recursion;

public class rec {

    // print num from 1 to 10 
    public static void printNum(int n){
        // base case
        if(n==10){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNum(n+1);
    }

    // print num from 10 to 1 
    public static void PrintNumOpp(int n){
        if(n==10){
            System.out.println("10");
            return;
        }
        PrintNumOpp(n+1);
        System.out.println(n);
    }

    // fibonacchi series - give the nth fibonacchi number 
    public static int fibo(int n){
        if(n<2){
            return n ;
        }

        return fibo(n-1) + fibo(n-2);
    }
     
    // Binary Search using recursion 
    public static int binarySearch(int arr[], int target, int start, int end) {
    // Base case: target not found
    if (start > end) {
        return -1;
    }

    int mid = start + (end - start) / 2;

    if (arr[mid] == target) {
        return mid;
    }

    if (arr[mid] > target) {
        return binarySearch(arr, target, start, mid - 1);
    } else {
        return binarySearch(arr, target, mid + 1, end);
    }
}




    public static void main(String[] args) {
        // print num from 1 to 10 using rec
        // printNum(1);

        // print num from 10 to 1 using rec
        // PrintNumOpp(1);

        // fibonacchi series 
        // System.out.println(fibo(5));

        // binary search using recursion 
        int arr[] = {1 , 2, 3 , 4 , 5 , 8, 10};
        System.out.println(binarySearch(arr, 11, 0, 6));



    }
}
