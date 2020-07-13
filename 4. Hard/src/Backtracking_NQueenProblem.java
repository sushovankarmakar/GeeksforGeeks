import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/n-queen-problem/0
// https://www.youtube.com/watch?v=0DeznFqrgAI (Best video explanation)
// https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
// https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
// https://www.youtube.com/watch?v=xFv_Hl4B83A
// https://www.youtube.com/watch?v=xouin83ebxE

public class Backtracking_NQueenProblem {
    private static int N = 0;
    private static StringBuilder output = new StringBuilder();
    private static StringBuilder printTheBoard = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            N = Integer.parseInt(br.readLine().trim());
            solveNQ();
            System.out.println((output.length() == 0) ? -1 : output);
            output.setLength(0);
            System.out.println(printTheBoard);
            printTheBoard.setLength(0);
        }
    }

    private static void solveNQ() {
        int[][] board = new int[N][N];
        solveNQUtil(board, 0);
    }

    private static void solveNQUtil(int[][] board, int col) {
        if(col >= N) {
            printOutput(board);
            return;
        }

        for (int row = 0; row < N; row++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 1;
                solveNQUtil(board, col+1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        // check left side of that row
        for (int j = 0; j < col; j++) {
            if(board[row][j] == 1) return false;
        }
        // check left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) return false;
        }
        // check left lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if(board[i][j] == 1) return false;
        }
        return true;
    }

    private static void printOutput(int[][] board) {

        // below code prints the whole board
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                printTheBoard.append(board[row][col]);
            }
            printTheBoard.append("\n");
        }
        printTheBoard.append("\n");

        // below code only prints the row col number of the board
        output.append("[");
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if(board[row][col] == 1) output.append(row+1).append(" ");
            }
        }
        output.append("] ");
    }
}
