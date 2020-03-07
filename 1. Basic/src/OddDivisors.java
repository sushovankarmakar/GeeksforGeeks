import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.geeksforgeeks.org/check-if-total-number-of-divisors-are-even-or-odd/

public class OddDivisors {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim()), count = 0;
			for (int i = 1; i <= n; i++) {
				/*only the perfect square number has the odd number of factors
				  so checking all the perfect square number in the range 
				*/
				int a = (int)Math.sqrt(i);
				double b = Math.sqrt(i);
				if(a==b) count++;
			}
			System.out.println(count);
		}
	}
}
