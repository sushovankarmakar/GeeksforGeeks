import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/index-of-first-1-in-a-sorted-array-of-0s-and-1s/0/
// https://www.geeksforgeeks.org/find-index-first-1-sorted-array-0s-1s/
// https://www.careercup.com/question?id=17316686

public class IndexOfFirstOneInSortedArrayOfZeroOne {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while( t-->0 ) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(findFirstOne(ip, n));
		}
	}
	
	private static int findFirstOne(int ip[], int n) {
		
		int l = 0, r = n-1;
		while( l <= r ) {
			
			int mid = l + (r - l)/2;
			
			if(	ip[mid] == 1  && ( mid == 0 || ip[ mid-1 ] == 0) ) return mid;
			else if( ip[mid] == 0 ) l = mid+1;
			else if( ip[mid] == 1 ) r = mid-1; 
		}
		return -1;
	}
}
