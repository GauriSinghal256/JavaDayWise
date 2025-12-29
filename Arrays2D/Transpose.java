public class Transpose {
    public static void main(String[] args) {
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
    // printing transposed matrix
        System.out.println("Transposed Matrix:");
        for(int i=0 ; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }










 }
}