import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1 (Solved by me in one go, quite similar to NQueen Problem)
// https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/ (this rat can only move in two direction)
// https://www.youtube.com/watch?v=W9F8fDQj7Ok&t=1s (BEST Video explanation and visualization)
// https://www.youtube.com/watch?v=PwxGTHraMNg&feature=emb_logo
// https://www.youtube.com/watch?v=jFksL23Z4g4


public class Backtracking_RatInAMaze {

    private static List<String> getAllPaths(int[][] matrix, int n) {
        List<String> paths = new ArrayList<>();

        if(matrix[n - 1][n - 1] == 0) return paths;

        int row = 0;    /* starting from row 0, col 0 */
        int col = 0;
        String currentPath = "";    /* initial path is empty */
        getAllPathsUtil(matrix, row, col,  n, currentPath, paths);
        return paths;
    }

    private static void getAllPathsUtil(int[][] matrix, int row, int col, int n,
                                        String currentPath, List<String> paths) {

        if(row == n - 1 && col == n - 1) {
            /* if we reach the last cell, then we have reached the destination, store the current path to the path list */
            paths.add(currentPath);
            return;
        }

        // Visit DOWN side
        if (isValidMove(matrix, row, col, n)) {
            matrix[row][col] = 0;   /* marking this cell as visited */
            getAllPathsUtil(matrix, row + 1, col, n, currentPath + "D", paths);
            matrix[row][col] = 1;   /* marking this cell as un-visited so that we can explore later */
        }
        // Visit LEFT side
        if (isValidMove(matrix, row, col, n)) {
            matrix[row][col] = 0;   /* marking this cell as visited */
            getAllPathsUtil(matrix, row, col - 1, n, currentPath + "L", paths);
            matrix[row][col] = 1;   /* marking this cell as un-visited so that we can explore later */
        }
        // Visit RIGHT side
        if (isValidMove(matrix, row, col, n)) {
            matrix[row][col] = 0;   /* marking this cell as visited */
            getAllPathsUtil(matrix, row, col + 1, n, currentPath + "R", paths);
            matrix[row][col] = 1;   /* marking this cell as un-visited so that we can explore later */
        }
        // Visit UP side
        if (isValidMove(matrix, row, col, n)) {
            matrix[row][col] = 0;   /* marking this cell as visited */
            getAllPathsUtil(matrix, row - 1, col, n, currentPath + "U", paths);
            matrix[row][col] = 1;   /* marking this cell as un-visited so that we can explore later */
        }
    }

    private static boolean isValidMove(int[][] matrix, int row, int col, int n) {
        return  (0 <= row && row < n) &&
                (0 <= col && col < n) &&
                (matrix[row][col] == 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowInput = br.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowInput[j]);
                }
            }

            List<String> paths = getAllPaths(matrix, n);
            printAllPaths(paths);
        }
    }

    private static void printAllPaths(List<String> paths) {

        if(paths.isEmpty()) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String path : paths) {
            sb.append(path).append(" ");
        }
        System.out.println(sb);
        sb.setLength(0);
    }
}
