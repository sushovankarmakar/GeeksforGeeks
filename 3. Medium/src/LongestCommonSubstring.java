import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



class LongestCommonSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"); 
			int m = Integer.parseInt(s1[0]), n = Integer.parseInt(s1[1]);
			
			String x = br.readLine().trim(), y = br.readLine().trim();
			int mat[][] = new int[m+1][n+1];
			
			int longestlength = 0;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if(x.charAt(i-1)==y.charAt(j-1)) {
						mat[i][j] = mat[i-1][j-1] + 1;
						longestlength = Math.max(mat[i][j], longestlength);
					}
				}
			}
			
			// printing the matrix
			/*for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}*/
			System.out.println(longestlength);
		}
	}
}
