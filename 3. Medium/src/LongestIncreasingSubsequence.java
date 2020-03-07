import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/


class LongestIncreasingSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n], op[] = new int[n]; 
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				op[i] = 1;
			}
			
			// algorithm
			int longestLength = Integer.MIN_VALUE;
			for (int i = 1; i < n; i++) {
				int val = ip[i];
				for (int j = 0; j < i; j++) {
					if(ip[j] < val) {
						op[i] = Math.max(op[j]+1, op[i]);
					}
					if(longestLength < op[i]) longestLength = op[i];
				}
			}
			System.out.println(longestLength);
		}
	}
}
