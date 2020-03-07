import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ab[] = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			
			int op[][] = new int[a+1][b+1];
			
			for (int i = 1; i < op.length; i++) {
				for (int j = 1; j < op[i].length; j++) {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						op[i][j] = op[i-1][j-1] + 1;
					}
					else {
						op[i][j] = Math.max(op[i-1][j], op[i][j-1]);
					}
				}
			}
			
			System.out.println(op[a][b]);
			
			// printing the longest common subsequence
			String s = "";
			int i = a, j= b;
			while(i > 0 && j > 0) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					s = s1.charAt(i-1) + s; 
					i--; j--;
				}
				else if(op[i-1][j] > op[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
			System.out.println(s);
		}
	}
}
