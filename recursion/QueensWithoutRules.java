public class QueensWithoutRules {

    public static void main(String[] args) {
        int n = 2;
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(board, 0);
    }

    public static void nQueens(char[][] board, int row) {

        // base case
        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';      // place queen
            nQueens(board, row + 1); // recursive call
            board[row][j] = '.';     // backtrack
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

