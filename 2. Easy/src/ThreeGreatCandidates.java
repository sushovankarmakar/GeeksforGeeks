import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/

class ThreeGreatCandidates {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			long ip[] = new long[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Long.parseLong(s[i]);
			}
			Arrays.sort(ip);
			long a = ip[0]*ip[1]*ip[n-1],
				b = ip[n-3]*ip[n-2]*ip[n-1];
			System.out.println((a>=b)?a:b);
		}
	}
}
