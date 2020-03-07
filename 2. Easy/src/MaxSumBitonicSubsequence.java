import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/maximum-sum-bi-tonic-sub-sequence/

class MaxSumBitonicSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n], lis[] = new int[n], lds[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
				lis[i] = lds[i] = ip[i];
			}
			
			// find lis sum from left to right
			for (int i = 1; i < n; i++) {
				int val = ip[i];
				for (int j = 0; j < i; j++) {
					if(ip[j] < val) {
						lis[i] = Math.max(lis[i], lis[j]+val);
					}
				}
			}
			
			// find lis sum from right to left
			for (int i = n-2; i >= 0; i--) {
				int val = ip[i];
				for (int j = n-1; j > i; j--) {
					if(ip[j] < val) {
						lds[i] = Math.max(lds[i], lds[j]+val);
					}
				}
			}
			
			
			int maxBitonicSum = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int val = lis[i]+lds[i]-ip[i];
				
				if( maxBitonicSum < val ) {
					maxBitonicSum = val;
				}
			}
			
			System.out.println(maxBitonicSum);
		}
	}
}
