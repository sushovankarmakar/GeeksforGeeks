import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
// https://leetcode.com/problems/maximum-subarray/
// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// https://www.youtube.com/watch?v=2MmGzdiKR9Y (BEST VIDEO EXPLANATION)
// https://www.youtube.com/watch?v=86CQq3pKSUw (Good video explanation)
// https://www.youtube.com/watch?v=w_KEocd__20&ab_channel=takeUforward (Good video explanation)
// https://github.com/bephrem1/backtobackswe/tree/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/MaxContiguousSubarraySum
// https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1 (Similar question)
// https://leetcode.com/problems/maximum-product-subarray/ (Similar question)

class DP_ContiguousSubArrayMaxSumKadaneAlgo {

	/*look at each index and we gonna ask ourselves what is the maximum sub array ending at this index.
	it can be
 	1. maximumSubArraySumTillPreviousIndex + elementAtThisIndex	 (do I need to extend the )
 	2. elementAtThisIndex
	and take the maximum of 1, 2
	*/

	static int getContiguousSubArrMaxSum(int[] arr, int size) {
		int localMaxSubArraySum  = arr[0];
		int globalMaxSubArraySum = arr[0];

		for (int i = 1; i < size; i++) {
			localMaxSubArraySum  = Math.max(localMaxSubArraySum + arr[i], arr[i]);
			globalMaxSubArraySum = Math.max(localMaxSubArraySum, globalMaxSubArraySum);
		}
		return globalMaxSubArraySum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int size = Integer.parseInt(br.readLine().trim());
			String[] ip = br.readLine().trim().split("\\s+");
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}
			System.out.println(getContiguousSubArrMaxSum(arr, size));
		}
	}
}
