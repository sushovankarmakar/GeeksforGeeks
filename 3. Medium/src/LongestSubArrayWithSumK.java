import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0
// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1	(similar question)

public class LongestSubArrayWithSumK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while( t-- > 0) {
			String[] NK = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(NK[0]);
			int k = Integer.parseInt(NK[1]);
			int ip[] = new int[n];
			
			String s[] = br.readLine().trim().split("\\s+");
			for(int i=0; i< n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			System.out.println( getLongestSubArrayWithSumK(ip,k) );
		} 
	}

	private static int getLongestSubArrayWithSumK(int[] ip, int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int prefixSum = 0, maxLen = 0;
		
		for(int i = 0; i < ip.length; i++) {
			
			/*
			 * prefix_sum += ip[i];
			 * 
			 * if(ip[i] == k && max_len == 0) { max_len = 1; }
			 * 
			 * if(prefix_sum == k) { max_len = i + 1; }
			 * 
			 * Integer prev_i = map.get(prefix_sum - k);
			 * 
			 * if(prev_i != null) { max_len = Math.max(max_len, i-prev_i); } else {
			 * map.put(prefix_sum, i); System.out.println(map); }
			 */
			
			prefixSum += ip[i]; 
       		
			if(ip[i] == k && maxLen == 0) { maxLen = 1; }
            
			if (prefixSum == k) 
                maxLen = i + 1; 

            if (!map.containsKey(prefixSum)) { 
                map.put(prefixSum, i); 
            } 
            
            Integer prev_i = map.get(prefixSum - k);
 
            if (prev_i != null) { 
            	maxLen = Math.max(maxLen, i - prev_i); 
            }
            
		}
		return maxLen;
	}
}
