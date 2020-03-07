import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumOfTwoLargeNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			BigInteger x = new BigInteger(ip[0]), y = new BigInteger(ip[1]), op = x.add(y);
			if( op.toString().length() == x.toString().length()) {
				System.out.println(op);
			}
			else {
				System.out.println(x);
			}
			
		}
	}
}
