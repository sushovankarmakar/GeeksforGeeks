import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 26.08.2020
// https://practice.geeksforgeeks.org/problems/boolean-matrix-problem/0
// https://leetcode.com/problems/set-matrix-zeroes/	(Similar question)
// https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution/223761 (The BEST Solution)
// https://www.geeksforgeeks.org/a-boolean-matrix-question/ (A good article)
// https://www.youtube.com/watch?v=M65xBewcqcI&t=591s (A good video but tricky to understand)

class Arrays_BooleanSetMatrixZerosOnes {

	/* below code is long but easy to understand
	 * time complexity : O(M*N)
	 * space complexity : O(1)
	 * */
	private static void setMatrixOnes(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		boolean rowFlag = false;
		boolean colFlag = false;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				/* next two if conditions take special care for first row and first column */

				/* Scan the first row and set a variable rowFlag to indicate whether we need to set all 1s in first row or not. */
				if (i == 0 && matrix[i][j] == 1) {	/* if any values in first row is 1, set rowFlag true */
					rowFlag = true;
				}

				/* Scan the first column and set a variable colFlag to indicate whether we need to set all 1s in first column or not. */
				if (j == 0 && matrix[i][j] == 1) {	/* if any values in first col is 1, set colFlag true */
					colFlag = true;
				}

				/* Use first row and first column as the auxiliary arrays row[] and col[] respectively,
				 * consider the matrix as sub matrix starting from second row and second column
				 * */
				if (matrix[i][j] == 1) {
					matrix[0][j] = 1;
					matrix[i][0] = 1;
				}
			}
		}

		/* Modify the given input matrix using the first row and first column of this matrix itself */
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[0][j] == 1 || matrix[i][0] == 1) {
					matrix[i][j] = 1;
				}
			}
		}

		/* modify first row if there was any 1 */
		if (rowFlag) {
			for (int j = 0; j < col; j++) {
				matrix[0][j] = 1;
			}
		}

		/* modify first col if there was any 1 */
		if (colFlag) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 1;
			}
		}

		printTheMatrix(matrix);
	}

	private static void printTheMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sb.setLength(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String[] rc = br.readLine().trim().split("\\s+");
			int row = Integer.parseInt(rc[0]);
			int col = Integer.parseInt(rc[1]);

			int[][] matrix = new int[row][col];

			for (int i = 0; i < row; i++) {
				String[] rowValues = br.readLine().trim().split("\\s+");
				for (int j = 0; j < col; j++) {
					matrix[i][j] = Integer.parseInt(rowValues[j]);
				}
			}

			setMatrixOnes(matrix);
		}
	}
}