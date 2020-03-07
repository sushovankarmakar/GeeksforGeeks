import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LCSof3strings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(s1[0]), n = Integer.parseInt(s1[1]), o = Integer.parseInt(s1[2]);
			String x = s2[0], y = s2[1], z = s2[2];
			
			int mat[][][] = new int[m+1][n+1][o+1];

			for (int i = 1; i <= m; i++) {
	
				for (int j = 1; j <= n; j++) {
					
					for (int k = 1; k <= o; k++) {
						if(x.charAt(i-1) == y.charAt(j-1)  && y.charAt(j-1) == z.charAt(k-1)) {
							mat[i][j][k] = mat[i-1][j-1][k-1] + 1;
						}
						else {
							mat[i][j][k] = Math.max(mat[i-1][j][k], Math.max(mat[i][j-1][k], mat[i][j][k-1]));
						}
					}
				}
			}
			System.out.println(mat[m][n][o]);
		}
	}
	
	// i tried to print 
	
	/*public static String findLCS(String x, String y, int n, int m) {
		
		int mat[][] = new int[m+1][n+1];

		for (int i = 1; i <= m; i++) {
			char ch = y.charAt(i-1);
			
			for (int j = 1; j <= n; j++) {
				char ch1 = x.charAt(j-1);
				
				if(ch == ch1) {
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		
		// printing purpose 
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		String op = "";
		for (int i = m, j = n; i >= 1 && j >= 1 ; j--) {
			
			if(mat[i][j] == mat[i-1][j-1]+1 ) {
				op = op + x.charAt(i);
				i--;
			}
		}
		System.out.println("op "+ op);
		return op;
	}*/
}
