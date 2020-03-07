import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialsOfLargeNo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()),val = 1;
			BigInteger res = BigInteger.ONE;
			for (int i = 0; i < n; i++) {
				res = res.multiply(BigInteger.valueOf(val++));
			}
			System.out.println(res);
		}
	}
}
