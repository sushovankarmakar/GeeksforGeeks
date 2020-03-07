import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.math.BigInteger;


class TrailingZerosFactorial {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			
			/*//one method - figure out the factorial, make that string and count the no of trailing zeros
			int val = 1; 
			BigInteger factorial = BigInteger.ONE;
			for (int i = 0; i < n; i++) {
				factorial = factorial.multiply(BigInteger.valueOf(val++));
			}
			
			String op = String.valueOf(factorial);
			int countTrailingZero = 0;
			for (int i = op.length()-1; i >=0 ; i--) {
				if(op.charAt(i)=='0') {
					countTrailingZero++;
				}
				else break;
			}
			System.out.println(countTrailingZero);*/
			
			//another method : A trailing zero is always produced by prime factors 2 and 5. count the no of 5s in a number
			int countTrailingZero = 0;
			for (int i = 5; n/i > 0; i *= 5) {
				countTrailingZero += n/i;
			}
			System.out.println(countTrailingZero);
		}
	}
}
