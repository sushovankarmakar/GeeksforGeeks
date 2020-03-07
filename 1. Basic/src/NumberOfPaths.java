import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/

class NumberOfPaths {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
			int mat[][] = new int[m][n];
			 
			//filling the first row with 1
			for (int i = 0; i < m; i++) {
				mat[i][0] = 1;
			}
			//filling the first column with 1
			for (int i = 0; i < n; i++) {
				mat[0][i] = 1;
			}
			
			for (int i = 1; i < m ; i++) {
				for (int j = 1; j < n; j++) {
					mat[i][j] = mat[i-1][j] + mat[i][j-1];
				}
			}
			
			//printing
			/*for (int i = 0; i < m ; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}*/
			System.out.println(mat[m-1][n-1]);
		}
	}

}
