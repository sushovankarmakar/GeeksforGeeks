import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/longest-subarray-non-negative-integers/s

class LenOfLongestSubArr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String arr[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(arr[i]);
			}
			
			int maxCount = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if(ip[i] >= 0) count++;
				else count = 0;
				
				maxCount = Math.max(maxCount, count);
			}
			System.out.println(maxCount);
		}
	}
}
