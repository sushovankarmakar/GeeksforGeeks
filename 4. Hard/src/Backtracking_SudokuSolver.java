import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/solve-the-sudoku/0
// https://leetcode.com/problems/sudoku-solver/
// https://www.youtube.com/watch?v=JzONv5kaPJM
// https://www.geeksforgeeks.org/sudoku-backtracking-7/
// https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking/15800 (Most optimal solution)

public class Backtracking_SudokuSolver {

    private static void sudokuSolver(int[][] board) {
        if(board == null || board.length == 0) return;

        sudokuSolverUtil(board, 0, 0);  /* start solving the sudoku from 0th row and 0th column */
    }

    private static boolean sudokuSolverUtil(int[][] board, int row, int col) {

        for (int i = row; i < board.length; i++, col = 0) { /* col must be reset here */
            for (int j = col; j < board[0].length; j++) {
                if (board[i][j] == 0) {

                    for (int number = 1; number <= 9; number++) {
                        if (isValid(board, i, j, number)) {
                            board[i][j] = number;

                            if (sudokuSolverUtil(board, row, col + 1)) {
                                return true;    /* if this is the solution return true */
                            }

                            board[i][j] = 0;
                        }
                    }
                    return false;   /* this cell was empty but we couldn't place any number from 0 - 9, so return false */
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int number) {
        int regionRow = 3 * (row / 3);  /* region start row */
        int regionCol = 3 * (col / 3);  /* region start col */

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) return false;  /* check row */
            if (board[row][i] == number) return false;  /* check column */
            if (board[regionRow + (i / 3)][regionCol + (i % 3)] == number) return false;    /* check 3*3 block */
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int[][] board = new int[9][9];
            String[] values = br.readLine().trim().split("\\s+");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(values[(i * 9) + j]);
                }
            }
            sudokuSolver(board);
            printSudoku(board); /* print the solved sudoku */
        }
    }

    private static void printSudoku(int[][] board) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        sb.setLength(0);
    }
}
