import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/

public class SubarrayWithGivenSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String NS[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(NS[0]);
			int s = Integer.parseInt(NS[1]);
			
			int ip[] = new int[n];
			String input[] = br.readLine().trim().split("\\s+");
			for(int i=0; i< n; i++) {
				ip[i] = Integer.parseInt(input[i]);
			}
			getSubArraysWithGivenSum(ip, n, s);
		}
	}
	
	private static void getSubArraysWithGivenSum(int ip[], int n, int expectedSum) {
		
		int start = 0;
		int windowSum = 0;
		
		
		for(int end= 0; end < n; end++) {	// while loop gives time limit exceeded error
			
			if(windowSum < expectedSum) {
				windowSum += ip[end];
			}
			
			while(windowSum > expectedSum ) {     // && start < end-1    --- not required, cause sometimes one element == expectedSum
				windowSum -= ip[start];
				start++;
			}
			
			if( windowSum == expectedSum) {
				System.out.println((start+1) + " " + (end+1));
				return;
			}
		}
		System.out.println("-1");
	}
}
