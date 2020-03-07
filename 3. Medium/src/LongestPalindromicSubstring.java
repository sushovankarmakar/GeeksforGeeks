import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LongestPalindromicSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip1 = br.readLine().trim();
			String ip2 = new String(new StringBuilder(ip1).reverse());
			
			System.out.println( lpSub(ip1,ip2) );
		}
	}

	static int lpSub(String ip1, String ip2) {
		int n = ip1.length();
		int op[][] = new int[n+1][n+1];
		
		int longestLength = Integer.MIN_VALUE;
		int I = 1,J = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(ip1.charAt(i-1)==ip2.charAt(j-1)) {
					op[i][j] = 1 + op[i-1][j-1];
					
					if( longestLength < op[i][j] ) {
						longestLength = op[i][j];
						I = i; 
						J= j;
					}
				}
			}
		}
		
		
		for (int i = 0; i < op.length; i++) {
			for (int j = 0; j < op.length; j++) {
				System.out.print(op[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(I+" "+J);
		
		String st = "";
		while(I > 0) {
			st += ip1.charAt(I-1);
			I--;
		}
		
		System.out.println(st);
		return longestLength;
	}
}
