import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Geek_TrickySeries {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int mod = 1000000007;
			int base = 7, op=7;
			for (int i = 2; i <= n; i++) {
				op = ( (base * 2) + (i-1)) % mod;
				base = op;
			}
			System.out.println(op);
		}
	}
}
