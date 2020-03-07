import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibmaths.html#section1.1
// Fact: after 300th Fibonacci number last two digits starts repeating.

class Last2DigitsOfFibonacci {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			int lasttwo[] = new int[300];
			BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
			lasttwo[0] = a.intValue(); 
			lasttwo[1] = b.intValue();
			
			for (int i = 2; i < 300; i++) {
				BigInteger temp = a.add(b);
				a = b;
				b = temp;
				lasttwo[i] = temp.mod(BigInteger.valueOf(100)).intValue();
			}
			System.out.println(lasttwo[n%300]);
		}
	}
}
