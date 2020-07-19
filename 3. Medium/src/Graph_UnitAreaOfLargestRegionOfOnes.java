import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 19.07.2020
// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s/0
// https://leetcode.com/problems/max-area-of-island/ (Similar problem)
// https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/

public class Graph_UnitAreaOfLargestRegionOfOnes {

    private static int largestRegion = 0;

    private static int getUnitAreaOfLargestRegion(int[][] matrix) {

        for(int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 1) {
                    int currentRegion = dfs(matrix, row, col, 1);
                    largestRegion = Math.max(largestRegion, currentRegion);
                }
            }
        }
        return largestRegion;
    }

    private static int dfs (int[][] matrix, int row, int col, int region) {
        matrix[row][col] = 2; // 2 indicates that this cell has been visited

        int[][] directions = {{0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}};

        for (int[] direction : directions) {
            int adjRow = row + direction[0];
            int adjCol = col + direction[1];

            if(isValidAndConnected(matrix, adjRow, adjCol)) {
                region = dfs(matrix, adjRow, adjCol, region + 1);
            }
        }
        return region;
    }

    private static boolean isValidAndConnected(int[][] matrix, int row, int col) {
        return  (0 <= row && row < matrix.length) &&
                (0 <= col && col < matrix[row].length) &&
                (matrix[row][col] == 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            String[] nm = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] str = br.readLine().trim().split("\\s+");
            int[][] matrix = getTheMatrix(str, n, m);
            System.out.println(getUnitAreaOfLargestRegion(matrix));
            largestRegion = 0;
        }
    }

    private static int[][] getTheMatrix(String[] str, int n, int m) {
        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = Integer.parseInt(str[row*m + col]);
            }
        }
        return matrix;
    }
}
