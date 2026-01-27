import java.util.*;
class QueensWay2{

    List<List<String>> result = new ArrayList<>();
    int[] queen;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        queen = new int[n];
        nQueens(0);
        return result;
    }

    void nQueens(int row) {
        if (row == N) {
            result.add(buildBoard());
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canPlace(row, col)) {
                queen[row] = col;
                nQueens(row + 1);
            }
        }
    }

    boolean canPlace(int row, int col) {
        for (int prev = 0; prev < row; prev++) {

            // same column
            if (queen[prev] == col) return false;

            // diagonal
            if (Math.abs(queen[prev] - col) == row - prev) return false;
        }
        return true;
    }

    List<String> buildBoard() {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] row = new char[N];
            Arrays.fill(row, '.');
            row[queen[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}
