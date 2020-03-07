import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/

public class PythagoreanTriplet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i])*Integer.parseInt(s[i]);
			}
			Arrays.sort(ip);
			boolean b = false;
			outer: for (int i = ip.length-1; i >=2 ; i--) {
				int a = ip[i];
				int l = 0;
				int r = i-1;
				while(l<r) {
					if(ip[l]+ip[r]==a) {
						b = true;
						break outer;
					}
					else if (ip[l]+ip[r] < a) l++;
					else r--;
				}
			}
			
			
			
			/* time complexity = O(n^3)
			 * 
			 * boolean b = false;
			outer: for (int i = 0; i < ip.length-2; i++) {
				int a = ip[i];
				for (int j = i+1; j < ip.length; j++) {
					int sum = a + ip[j];
					for (int k = i+2; k < ip.length; k++) {
						if(sum==ip[k]) {
							b = true;
							break outer;
						}
					}
					
				}
			}
			*
			*/
			System.out.println((b)?"Yes":"No");
		}
	}
}
