import java.util.Arrays;
class ReverseRow{

    public static void reverse(int arr[]){
        int first = 0;
        int last = arr.length - 1;
        while(first <last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;    
            last--;
        }
    }

    public static void main(String[] args) {
        // We need to reverse all the rows of the matrix
        int matrix[][] = { {1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13, 14, 15, 16} };
        // printing original matrix
        System.out.println("Original Matrix:");
        for(int i=0 ; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Reversing each row of the matrix
        for(int i=0 ; i<matrix.length; i++){
            reverse(matrix[i]);
        }
        // printing modified matrix
        System.out.println("Matrix after reversing each row:");
        System.out.println(Arrays.deepToString(matrix));



    }
}