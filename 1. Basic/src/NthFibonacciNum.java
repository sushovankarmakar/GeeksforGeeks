import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class NthFibonacciNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c = new BigInteger("0");
			for (int i = 2; i < n; i++) {
				c = (a.add(b)).remainder(new BigInteger("1000000007"));
				a = b;
				b = c;
			}
			System.out.println(b.remainder(new BigInteger("1000000007")));
		}
	}
}
