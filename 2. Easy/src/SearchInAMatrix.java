import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.youtube.com/watch?v=FOa55B9Ikfg (best explanation)
// https://practice.geeksforgeeks.org/problems/search-in-a-matrix/0
// https://leetcode.com/problems/search-a-2d-matrix/
// https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list

public class SearchInAMatrix {

    private static boolean searchInMatrix(int[][] matrix, int target) {
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
}
