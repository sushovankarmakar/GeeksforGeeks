import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents/0
// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
// https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
// https://practice.geeksforgeeks.org/problems/stickler-theif/0 (Same question)
// https://leetcode.com/problems/house-robber/ (Same question)
// https://www.youtube.com/results?search_query=198.+House+Robber


class DP_MaxSumWithoutAdjacents {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			// input taking part
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().trim().split("\\s+");
			int[] ip = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			// algorithm part
			int include = ip[0], exclude = 0;
			for (int i = 1; i < n; i++) {
				int old_include = include;
				include = Math.max(include, exclude+ip[i]);
				exclude = Math.max(exclude, old_include);
			}
			System.out.println(Math.max(include, exclude));
		}
	}
}
