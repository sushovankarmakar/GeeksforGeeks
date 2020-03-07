import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// I didn't know the formula to calculate Catalan number
// C(n) = (2n)! / ((n + 1)!n!)

// https://www.geeksforgeeks.org/program-nth-catalan-number/

class CatalanNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			
			// approach -1 , simple one
			/*BigInteger a = BigInteger.valueOf(1), b = BigInteger.valueOf(1), c = BigInteger.valueOf(1);
			
			for (int i = 1; i <= 2*n; i++) {
				a = a.multiply(BigInteger.valueOf(i));
				if(i <= (n+1) ) {
					b = b.multiply(BigInteger.valueOf(i));
				}
				if(i <= n) {
					c = c.multiply(BigInteger.valueOf(i));
				}
			}
			System.out.println(a.divide( (b.multiply(c))));
			*/
			
			// approach -1 , dynamic approach
			BigInteger cat[] = new BigInteger[n+1];
			cat[0] = cat[1] = BigInteger.valueOf(1);
			
			for (int i = 2; i <=n; i++) {
				cat[i] = BigInteger.valueOf(0);
				for (int j = 0; j < i; j++) {
					cat[i] = cat[i].add(cat[j].multiply(cat[i-j-1]));
				}
			}
			System.out.println(cat[n]);
		}
	}
}
