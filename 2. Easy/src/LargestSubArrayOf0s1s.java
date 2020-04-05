import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

// https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/

public class LargestSubArrayOf0s1s {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while( t--> 0 ) {
			int n = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for(int i=0; i < n ; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(getLargestSubArrayOf0s1s(ip, n));
		}
	}
	
	private static int getLargestSubArrayOf0s1s(int ip[], int n) {
		replaceZeroByMinusOne(ip, n);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int maxLen = 0, prefixSum = 0;
		
		for(int i=0; i< n; i++) {
			prefixSum += ip[i];
			
			if(prefixSum == 0) maxLen = i + 1;
			
			Integer	prev_i = map.get(prefixSum);
			
			if(prev_i != null) {
				maxLen = Math.max(maxLen, i-prev_i);
			}
			else {
				map.put(prefixSum, i);
			}
		}
		return maxLen;
	}
	
	private static void replaceZeroByMinusOne(int ip[], int n){
		for(int i=0; i< n; i++) {
			if(ip[i]==0) ip[i] = -1;
		}
	}

}
