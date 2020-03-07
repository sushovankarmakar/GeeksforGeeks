import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

//Longest Palindromic Subsequence
class LongestPalindromicSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			
			//reverse the input string and use the same algorithm for longest common subsequence
			String ip1 = br.readLine().trim();
			//String ip2 = new String(new StringBuilder(ip1).reverse());
			//System.out.println(lps(ip1,ip2));
			
			System.out.println(lps(ip1));
		}
	}
	
	static int lps(String ip1) {
		int n = ip1.length();
		
		int op[][] = new int[n][n];
		for (int i = 0; i < op.length; i++) {
			op[i][i] = 1;
		}
		
		// cl = character length
		int i,j;
		for (int cl = 2; cl <= n; cl++) {
			for (i = 0; i < n-cl+1; i++) {
				j = i+cl-1;
				if(ip1.charAt(i)==ip1.charAt(j) && cl==2) {
					op[i][j] = 2;
				}
				else if( ip1.charAt(i)==ip1.charAt(j) ) {
					op[i][j] = 2 + op[i+1][j-1];
				}
				else {
					op[i][j] = Math.max(op[i][j-1], op[i+1][j]);
				}
			}
		}
		
		return op[0][n-1];
	}
	
	/*static int lps(String ip1, String ip2) {
		int n = ip1.length();
		
		int op[][] = new int[n+1][n+1];
		
		for (int i = 1; i < op.length; i++) {
			for (int j = 1; j < op[i].length ; j++) {
				if(ip1.charAt(i-1)==ip2.charAt(j-1)) {
					op[i][j] = op[i-1][j-1]+1;
				}
				else {
					op[i][j] = Math.max(op[i-1][j], op[i][j-1]);
				}
			}
		}
		return op[n][n];
	}*/
}
