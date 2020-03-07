import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Spirall_traversal_of_Matrix {

	public static void main(String[] args) throws IOException {
		/*int mat[][] = {  {1,2,3,4},
						 {5,6,7,8},
						 {9,10,11,12},
						 {13,14,15,16}
					  };*/
		int mat[][] = {  {1,2,3,4},
				 {5,6,7,8},
				 {9,10,11,12}
			  };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			/*int mat[][] = new int[4][4]; 
			for (int i = 0; i < 4; i++) {
				String s[] = br.readLine().trim().split("\\s+");
				
				for (int j = 0; j < 4; j++) {
					mat[i][j] = Integer.parseInt(s[j]);
				}
			}*/
			
			int m = mat.length;     // row length of the matrix , here 4
			int n = mat[0].length;  // column length of the matrix , here 4
			spiralPrint(m,n,mat);
	
			/*for (int i = 0; i < m; i++) {
				System.out.print(mat[0][i]+" ");
				}
			for (int i = 1; i < n; i++) {
				System.out.print(mat[i][m-1]+" ");
				}
			for (int i = n-2; i >= 0; i--) {
				System.out.print(mat[m-1][i]+" ");
				}
			for (int i = n-2; i >=1 ; i--) {
				System.out.print(mat[i][0]+" ");
				}
			for (int i = 1; i <= 2; i++) {
				System.out.print(mat[1][i]+" ");
				}
			for (int i = 2; i >=1 ; i--) {
				System.out.print(mat[2][i]+" ");
				}
			System.out.println();*/
		}
	}
	
	static void spiralPrint(int m,int n,int mat[][]) {
		int k=0,l=0;
		/*
		k = starting row index;
		m = ending row index;
		l = starting column index;
		n = ending column index;
		*/
		while( k < m && l < n) {
			
			for (int i = l; i < n; i++) {
				System.out.print(mat[k][i]+" ");
			}
			k++;  // reducing the size of the array
			System.out.println();
			
			for (int i = k; i < m; i++) {
				System.out.print(mat[i][n-1]+" ");
			}
			n--; // reducing the size of the array
			System.out.println();
			
			if(k < m)  // this condition is required if the matrix is not a square matrix. 
			{
				for (int i = n-1; i >= l; i--) {
					System.out.print(mat[m-1][i]+" ");
				}
				m--;
				System.out.println();
			}
			
			if( l < n ) // this condition is required if the matrix is not a square matrix.
			{
				for (int i = m-1; i >= k; i--) {
					System.out.print(mat[i][l]+" ");
				}
				l++;
				System.out.println();
			}
		}
		System.out.println();
	}
}
