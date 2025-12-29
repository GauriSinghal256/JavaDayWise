public class RotateBy90 {
    public static void main(String[] args) {
        // rotate matrix by 90 degree clockwise is a easy question in which we have to perform two operations
        // transpose of matrix and then reverse each row of the matrix
        int matrix[][] = { {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9} };
        // printing original matrix
        System.out.println("Original Matrix:");
        for(int i=0 ; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Transposing
        for(int i=1 ; i<matrix.length; i++){
            for(int j=0 ; j<i ; j++){
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reversing each row of the transposed matrix
        for(int i=0 ; i<matrix.length; i++){
            int first = 0;
            int last = matrix[i].length - 1;
            while(first < last){
                int temp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = temp;
                first++;    
                last--;
            }
        }

        // printing rotated matrix
        System.out.println("Matrix after rotating by 90 degree clockwise:");
        for(int i=0 ; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
