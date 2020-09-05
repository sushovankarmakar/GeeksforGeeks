import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/is-sudoku-valid/0/
// https://leetcode.com/problems/valid-sudoku/
// https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings (I followed this solution)
// https://www.youtube.com/watch?v=Pl7mMcBm2b8 (BEST Video tutorial)
// https://www.geeksforgeeks.org/set-add-method-in-java-with-examples/ (Important to understand the set's add method.)

public class Arrays_CheckValidityOfSudoku {

    private static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];

                if(number != '.') {
                    if (    !set.add(number + " found in row " + i) ||
                            !set.add(number + " found in column " + j) ||
                            !set.add(number + " found in box " + (i / 3) + " - " + (j / 3))) {
                        return false;
                    }
                }
            }
        }

        for (String s : set) {
            System.out.println(s);
        }

        return true;
    }

    /* input :
    5 3 . . 7 . . . .
    6 . . 1 9 5 . . .
    . 9 8 . . . . 6 .
    8 . . . 6 . . . 3
    4 . . 8 . 3 . . 1
    7 . . . 2 . . . 6
    . 6 . . . . 2 8 .
    . . . 4 1 9 . . 5
    . . . . 8 . . 7 9

    output : true
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            char[][] board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                String[] rowInput = br.readLine().trim().split("\\s+");

                for (int j = 0; j < 9; j++) {
                    board[i][j] = rowInput[j].charAt(0);
                }
            }
            System.out.println(isValidSudoku(board));
        }
    }
}
