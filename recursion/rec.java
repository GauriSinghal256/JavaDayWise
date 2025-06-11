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

// factorial of a number using recursion
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n * factorial(n-1);
    }

    // compute the sum of digits 
    public static int digitSum(int n){
        if(n<=0){
            return 0;
        }
        int rem = n%10;
        return rem+digitSum(n/10);
    }

    // compute the product of digits
     public static int digitProd(int n){
        if(n<=0){
            return 1;
        }
        int rem = n%10;
        return rem*digitSum(n/10);
    }

    // Reverse the number using recursion  just print 
    public static void reverse(int n ){
        if(n<=0){
            return;
        }

        System.out.print(n%10);
        reverse(n/10);
    }
    
    // Reverse the number using recursion 
    public static int rev1(int n , int length){
        if(n<=0){
            return 0;
        }

        return (n%10)*(int)Math.pow(10,length-1) + rev1(n/10 , length-1);
    }

    // Reverse 2nd method 
    static int sum = 0;
    static void rev2(int n){
        if(n == 0){
            return;
        }
        int rem = n%10;
        sum = sum*10+rem;
        rev2(n/10);
    }

    // reverse 3rd method 
    public static int rev3(int n){

        int digits = (int)(Math.log10(n))+1;
        return helper(n , digits);
    }
    
    public static int helper(int n , int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem * (int) Math.pow(10 , digits-1) + helper(n/10 , digits-1);
    }

    // check if the number is palindrom or not 
    public static boolean palindrom(int n){
        return n == rev3(n);
    }

    // Count the number of zeroes 
    public static int count(int n){
        int c = 0;
        return helpercount(n , c);
    }

    public static int helpercount(int n, int c){
        if(n==0){
            return c;
        }
        int rem = n%10;
        if(rem == 0){
            return helpercount(n/10 , c+1);
        }else{
            return helpercount(n/10 , c);
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
        // int arr[] = {1 , 2, 3 , 4 , 5 , 8, 10};
        // System.out.println(binarySearch(arr, 11, 0, 6));

        // factorial 
        // System.out.println(factorial(5));
        // System.out.println(digitSum(12345));
        // System.out.println(digitProd(123454));
        // reverse(12345);
        // System.out.println(rev1(123456 , 6));
        // rev2(678980);
        // System.out.println(sum);
        //    System.out.println(rev3(897654));
        // System.out.println(palindrom(1232109));
        System.out.println(count(12340));
        



    }
}
