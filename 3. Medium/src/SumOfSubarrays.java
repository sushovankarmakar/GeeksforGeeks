import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SumOfSubarrays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int mod = 1000000007;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), sum = 0;
			String s[] =  br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				sum  = ( sum + (Integer.parseInt(s[i]))*(n-i)*(i+1) ) % mod;
			}
			System.out.println(sum);
		}
	}
}
