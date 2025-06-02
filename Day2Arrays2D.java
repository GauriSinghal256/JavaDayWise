import java.util.*;
public class Day2Arrays2D {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];     //number of rows are mandatory, number of columns are not mendatory
        // int[][] arr2 = {
        //     {1,2,3},
        //     {4,5,6,1},
        //     {7,8,9}
        // }; 
        
        // If we perform sysop(arr2.length) it will give us the number of rows 
        // input
        for(int row = 0 ; row <arr.length ; row++ ){
            for(int col=0 ; col<arr[row].length ; col++){
                arr[row][col] = sc.nextInt();
            }
        }
        // output
        for(int row = 0 ; row <arr.length ; row++ ){
            for(int col=0 ; col<arr[row].length ; col++){
                System.out.print(arr[row][col] + " "); 
            }
            System.out.println();
        }

        // output using .toString() method 
        for(int row = 0 ; row <arr.length ; row++ ){
            System.out.println(Arrays.toString(arr[row]));
        }

        // enhance for loop 
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }

    }
}
