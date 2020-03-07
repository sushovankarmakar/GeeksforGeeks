import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
// I try so hard for the whole day, in the end did in 0(n^2) way but somehow I got wrong output

class TwoNumWithSumCloseTo0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(ip);
			/*for (int i = 0; i < ip.length; i++) {
				System.out.print(ip[i]+" ");
			}
			System.out.println();*/
			
			int minSum = Integer.MAX_VALUE;
			int l = 0, r = n-1;
			while(l<r) {
				int sum = ip[l]+ip[r];
				if(Math.abs(minSum) > Math.abs(sum) ) {
					minSum = sum;
				}
				if(sum < 0) {
					l++;
				}
				else {
					r--;
				}
			}
			
			// approach-1 
			/*int minSum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					int sum = ip[i]+ip[j];
					//System.out.println(sum);
					if(Math.abs(minSum) > Math.abs(sum) ) {
						minSum = sum;
					}
				}
			}*/
			System.out.println(minSum);
		}
	}
}
