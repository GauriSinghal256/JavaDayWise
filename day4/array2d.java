
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

    // calculate the diagnol sum 
    // https://leetcode.com/problems/matrix-diagonal-sum/
    // this solution is having the complexity of O(n2)
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if(i==j){
                    sum = sum+mat[i][j];
                }else if(i+j == mat.length-1){
                     sum = sum+mat[i][j];
                }
            }
        }
        return sum;
    }

    // We can also optimise it like we can solve it in O(n)
    public int diagonalSum2(int[][] mat) {
        int sum = 0;
        for(int i=0 ; i<mat.length ; i++){
            // primary diagnol
            sum += mat[i][i];
            // secondary diagnol
            if(i!= mat.length-i-1){    //we know that i+j= matrix.length-1  so value of j becomes j= matrix.length-i
                sum+= mat[i][mat.length-i-1];
            }
        }
        return sum;
    }

    // https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/
     public boolean checkXMatrix(int[][] grid) {
       for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

     public boolean checkXMatrix2(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (!check(grid[i], i, n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    boolean check(int[] row, int x1, int x2) {
        for (int i = 0; i < row.length; i++) {
            if (i == x1 || i == x2) {
                if (row[i] == 0) {
                    return false;
                }
            } else {
                if (row[i] != 0) {
                    return false;
                }
            }
        }
        return true;
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
