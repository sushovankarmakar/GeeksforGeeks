import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 19.07.2020
// https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0/

public class Graph_FindWhetherPathExists {

    private static boolean checkIfPathExists(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 1) {
                    return dfs(matrix, row, col);
                }
            }
        }
        return false;
    }

    private static boolean dfs(int[][] matrix, int row, int col) {
        matrix[row][col] = 4; // 4 represents the cell has been visited

        int[][] directions = { {0,-1}, {0,1}, {-1,0}, {1,0} };  // left, right, up, down

        for (int[] direction : directions) {
            int adjRow = row + direction[0];
            int adjCol = col + direction[1];

            if(isValid(matrix, adjRow, adjCol)) {
                if(matrix[adjRow][adjCol] == 3) {
                    if(dfs(matrix, adjRow, adjCol))
                        return true;
                }
                else if(matrix[adjRow][adjCol] == 2){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return (0 <= row && row < matrix.length) && (0 <= col && col < matrix[row].length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[][] matrix = getTheMatrix(str, n);
            System.out.println(checkIfPathExists(matrix) ? 1 : 0);
        }
    }

    private static int[][] getTheMatrix(String[] str, int n) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(str[row*n + col]);
            }
        }
        return matrix;
    }
}
