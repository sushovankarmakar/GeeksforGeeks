import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class MinimizeSumOfProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int mod = 1000000007;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			long a[] = new long[n], b[] = new long[n];
			String ip1[] = br.readLine().trim().split("\\s+"), ip2[] = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(ip1[i]); 
				b[i] = Long.parseLong(ip2[i]) ;  
			}
			Arrays.sort(a);
			Arrays.sort(b);
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += ( (a[i]*b[n-i-1]) % mod);
			}
			System.out.println(sum % mod);
		}
	}
}
