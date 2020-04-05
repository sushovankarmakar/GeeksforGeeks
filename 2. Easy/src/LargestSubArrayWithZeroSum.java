import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// // https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0 (Similar one)

public class LargestSubArrayWithZeroSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for(int i=0; i< n; i++){
			    ip[i] = Integer.parseInt(s[i]);
			}
			
			System.out.println(largestSubArrayWithSumZero(ip, ip.length));
		}
	}

	private static int largestSubArrayWithSumZero(int[] ip, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int prefix_sum = 0;
		int max_len = 0;
		
		for (int i = 0; i < n; i++) {
			
			prefix_sum += ip[i];
			
			if(ip[i] == 0 && max_len == 0)
				max_len = 1;
			
			if(prefix_sum == 0) 
				max_len = i + 1;
			
			Integer prev_i = map.get(prefix_sum);
			
			if(prev_i != null) {
				max_len = Math.max(max_len, i - prev_i);
			}
			else {
				map.put(prefix_sum, i);
			}
		}
		return max_len;
	}
}



/*
 * The following is an explanation.
 * 
 * If no maximum zero-sum sub-array has been identified yet and there’s a 0
 * element, the maximum zero-sum array is trivially composed of the 0 number
 * itself 
 * 
 * If the running sum reaches zero from the beginning of the array, the
 * longest zero-sum sub-array consists of the entire array till the index we
 * reached 
 * 
 * If a previous intermediate sum is found, it means that between the
 * previous sum XX and the current sum XX there must have been an interval of
 * values which sum to zero. Check for the maximum between the current maximum
 * length and the length of this intermediate interval
 */

