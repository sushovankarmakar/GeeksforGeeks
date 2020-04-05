import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
// https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1/

public class TripletSumInArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			String NX[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(NX[0]);
			int x = Integer.parseInt(NX[1]);
			int ip[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			Arrays.sort(ip);
			System.out.println(getTripletSumInArray(ip, n, x) ? "1" : "0" );
		}
	}
	
	private static boolean getTripletSumInArray(int ip[], int n, int expectedSum) {
		
		for (int i = 0; i < n-2; i++) {
			int l = i+1;
			int r = n-1;
			
			while(l < r) {
				
				int tripletSum = ip[i] + ip[l] + ip[r];
				 
				if( tripletSum == expectedSum ) { return true; }
				 
				if( tripletSum > expectedSum ) { r--; }
				 
				if( tripletSum < expectedSum ) { l++; } 
			}
		}
		
		return false;
	}
}