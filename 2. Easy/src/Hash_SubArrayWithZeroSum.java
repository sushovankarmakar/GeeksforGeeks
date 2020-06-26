import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0
// https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/ (good explanation)

public class Hash_SubArrayWithZeroSum {

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
			System.out.println(checkForSubArrayWithSumZero(ip, n)? "Yes" : "No");
		}
	}
	
	private static boolean checkForSubArrayWithSumZero(int[] ip, int n){

		Set<Integer> set = new HashSet<>();
		int prefixSum = 0;

		for(int i=0; i < n; i++){
			prefixSum += ip[i];

			if (ip[i] == 0 || prefixSum == 0 || set.contains(prefixSum))
				return true;

			set.add(prefixSum);
		}
		return false;
	}
}
