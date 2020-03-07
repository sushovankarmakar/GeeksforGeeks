import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/nth-even-fibonacci-number/

class NthEvenFibonacciNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int mod = 1000000007;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			long op1 = 0;
			long op2 = 2;
			
			while(n--> 1) {
				long temp = op2 ;
				op2 = (op2*4 + op1)%mod;
				op1 = temp;
			}
			System.out.println(op2);
		}
	}
}
