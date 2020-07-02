
// https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
// https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/

public class Backtracking_NQueenProblem {

    static int N = 1;
    static String output = "";
    public static void main(String[] args) {
        solveNQ();
    }

    private static void printSolution(int[][] board) {

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                //System.out.print(" " + board[row][col] + " ");
                output += board[row][col];
            }
            output += "\n";

            //System.out.println();
        }
    }

    private static void solveNQ() {
        int[][] board = new int[N][N];

        solveNQUtil(board, 0);

        if(output != "") System.out.println(output);
        else System.out.println("No Solution Exists");

            //System.out.println("No Solution Exists");
        //printSolution(board);
    }

    private static void solveNQUtil(int[][] board, int col) {
        if(col >= N) {
            printSolution(board);
            return;
        }

        for (int row = 0; row < N; row++) {

            if(isSafe(board, row, col)) {
                board[row][col] = 1;

                solveNQUtil(board, col + 1);

                board[row][col] = 0;    // backtracking
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        // check for left side of that row
        for (int j = 0 ; j < col; j++) {
            if(board[row][j] == 1) return false;
        }

        // check for upper diagonal left side
        for (int i = row, j = col;  i >= 0 && j >= 0;  i--, j--) {
            if(board[i][j] == 1) return false;
        }

        // check for lower diagonal left side
        for (int i = row, j = col; i < N && j >= 0;  i++, j--) {
            if(board[i][j] == 1) return false;
        }
        return true;
    }
}

