import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

/*  Let the size of input array be n. We can simply count number of 0's.  
    Let the count be "c".  We can first print c 0's, then n-c 1's  */

class Segregate0sAnd1s {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),l=0,r=n-1;
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			/*while(l<r) {   // this swapping method's Execution Time: 1.33
				if( ip[l]==0) {
					l++;
					continue;
				}
				if( ip[r]==1) {
					r--;
					continue;
				}
				if( ip[l]==1 && ip[r]==0 ) {
					swap(ip,l,r);
					l++; r--;
				}
			}*/
			Arrays.sort(ip);   // this sorting method Execution Time:1.28
			for (int i = 0; i < n; i++) {
				sb.append(ip[i]+" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	/*static void swap(int ip[],int l,int r) {
		int temp = ip[l];
		ip[l] = ip[r];
		ip[r] = temp;
	}*/
}
