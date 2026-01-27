public class NQueens {

    static int N = 4;
    static int[][] board = new int[N][N];

    public static void main(String[] args) {
        nQueens(0);
    }

    static void nQueens(int row) {
        if (row == N) {
            printBoard();
            System.out.println("--------");
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canPlace(row, col)) {
                board[row][col] = 1;
                nQueens(row + 1);
                board[row][col] = 0; // backtrack
            }
        }
    }

    static boolean canPlace(int row, int col) {

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


