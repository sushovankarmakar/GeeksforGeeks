import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/

class MaxSumIncreasingSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n], op[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = op[i] = Integer.parseInt(s[i]);
			}
			
			// algorithm
			int highestSum = op[0];
			for (int i = 1; i < n; i++) {
				int val = ip[i];
				for (int j = 0; j < i; j++) {
					if( ip[j] < val) {
						op[i] = Math.max(op[i], op[j] + val);
					}
					if(highestSum < op[i]) highestSum = op[i];  
				}
			}
			System.out.println(highestSum);
		}
	}
}
