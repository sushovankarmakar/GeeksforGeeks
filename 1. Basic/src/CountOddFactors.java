import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/number-elements-odd-factors-given-range/

class CountOddFactors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()); //, count = 0;
			/* APPROACH-1 (this approach works within a limited range, approach-2's range is greater )
			 * only the perfect square number has the odd number of factors
			   so checking all the perfect square number in the range
			 * 
			 * for (int i = 1; i <= n; i++) {
				int a = (int)Math.sqrt(i);
				double b = Math.sqrt(i);
				if(a==b) count++;
			}*/
			
			// APPROACH-2
			System.out.println((int)Math.sqrt(n));
		}
	}
}
