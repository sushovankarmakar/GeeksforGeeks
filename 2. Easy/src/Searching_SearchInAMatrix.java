import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.youtube.com/watch?v=FOa55B9Ikfg (BEST VIDEO EXPLANATION)
// https://practice.geeksforgeeks.org/problems/search-in-a-matrix/0

public class Searching_SearchInAMatrix {

    // time complexity : O(log(m*n))
    // below solution works if "The first integer of each row is greater than the last integer of the previous row."
    // solution for : // https://leetcode.com/problems/search-a-2d-matrix/
    // https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
    /*private static boolean searchInMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows*cols - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int row = mid / cols;
            int col = mid % cols;

            if(matrix[row][col] == target) {
                return true;
            }
            else if(target < matrix[row][col]) {
                high = mid - 1; //go to left side
            }
            else {
                low = mid + 1; //go to right side
            }
        }
        return false;
    }*/

    // time complexity : O(m+n)
    // Here matrix is more strictly sorted as first element of a row is greater than last element of previous row.
    // solution : https://leetcode.com/problems/search-a-2d-matrix-ii/
    // https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
    // https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
    private static boolean searchInMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // initially we start from left bottom cell, we could have start from top right cell also.
        int i = rows - 1;
        int j = 0;

        while(0 <= i && j < cols) {
            if(matrix[i][j] == target) {
                return true;
            }
            else if(target < matrix[i][j]) {
                --i;    // go up, we will get smaller values
            }
            else {
                ++j;    // go right, we will get bigger values
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] mn = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
            String[] str = br.readLine().trim().split("\\s+");
            int target = Integer.parseInt(br.readLine().trim());
            int[][] mat = buildMatrix(str, m, n);
            //printMatrix(mat, m, n);
            System.out.println(searchInMatrix(mat, target) ? 1 : 0);
        }
    }

    private static int[][] buildMatrix(String[] str, int m, int n) {
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(str[(i*n)+j]);
            }
        }
        return mat;
    }

    private static void printMatrix(int[][] mat, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
