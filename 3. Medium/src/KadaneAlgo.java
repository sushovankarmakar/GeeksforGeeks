import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//everything is fine, but online IDE gives runtime error.
// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// submitted c# code

class KadaneAlgo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int size = Integer.parseInt(br.readLine().trim());
			String[] ip = br.readLine().trim().split("\\s+");
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}
			
			System.out.println(getContiguousSubArrMaxSum(arr,size));
		}
	}
	
	static int getContiguousSubArrMaxSum(int[] arr, int size) {
		int localMaxSum = arr[0], globalMaxSum = arr[0];
		for (int i = 1; i < size; i++) {
			localMaxSum = Math.max(localMaxSum + arr[i], arr[i]);
			globalMaxSum = Math.max(localMaxSum, globalMaxSum);
		}
		return globalMaxSum;
	}
}
