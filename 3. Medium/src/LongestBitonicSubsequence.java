import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
// https://www.youtube.com/watch?v=TWHytKnOPaQ

class LongestBitonicSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n], lis_LR[] = new int[n], lis_RL[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				lis_LR[i] = 1;
				lis_RL[i] = 1;
			}
			
			// find lis from left to right 
			for (int i = 1; i < n; i++) {
				int val = ip[i];
				for (int j = 0; j < i; j++) {
					if(ip[j] < val) {
						lis_LR[i] = Math.max(lis_LR[i], lis_LR[j]+1);
					}
				}
			}
			
			// find lis from right to left
			for (int i = n-2; i >= 1; i--) {
				int val = ip[i];
				for (int j = n-1; j > i; j--) {
					if(ip[j] < val) {
						lis_RL[i] = Math.max(lis_RL[i], lis_RL[j]+1);
					}
				}
			}
			
			int longestBitonicLength = Integer.MIN_VALUE;
			int op[] = new int[n];
			for (int i = 0; i < n; i++) {
				op[i] = lis_LR[i] + lis_RL[i] - 1;
				if(longestBitonicLength < op[i]) longestBitonicLength = op[i];
			}
			System.out.println(longestBitonicLength);
		}
	}

}
