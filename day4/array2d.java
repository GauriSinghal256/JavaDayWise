
import java.util.Arrays;


public class array2d {

    // print spiral matrix
    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if(startRow == endRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if(startCol == endCol) break;
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }
    }

    // https://leetcode.com/problems/spiral-matrix-ii/


     public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int count = 1;
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = count;
                count++;
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol] =count;
                count++;
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if(startRow == endRow) break;
                matrix[endRow][j] = count;
                count++;
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if(startCol == endCol) break;
                matrix[i][startCol] =count;
                count++;
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }
        return matrix;
        
    }

    public static void main(String[] args) {

        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};

        spiralMatrix(matrix); 
        
        System.out.println(Arrays.deepToString(generateMatrix(3)));
             

    }
}
