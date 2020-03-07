import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class PowerOfNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int mod = 100000007;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer(String.valueOf(n)).reverse();
			int r = Integer.parseInt(String.valueOf(sb));
			//System.out.println(r);
			long op = 1;
			while(r-->0) {
				op = (op*n)%mod;
			}
			System.out.println(op%mod);
		}
	}
}
