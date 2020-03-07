import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/
// https://www.includehelp.com/algorithms/compute-sum-of-digits-in-all-numbers-from-1-to-n-for-a-given-n.aspx


class SumOfDigitsInAllNumbers1toN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println(sumOfDigits(n));
		}
	}
	
	static int calculateSum(int d) {
		int sum = 45;
		for (int i = 2; i <= d; i++) {
			
			// sum(10^(d-1)) = sum(10^(d-1) -1)*10 + 45*(10^(d-1))
			sum = sum*10 + 45*(int)Math.pow(10, i-1);
		}
		return sum;
	}
	
	static int sumOfDigits(int n) {
		
		//base condition : if N less than 10, return sum of first N numbers
		if(n < 10) {
			return (n*(n+1)/2);
		}	
		
		int d = (int) Math.log10(n);
		int sum = calculateSum(d);
		
		int t = (int)Math.pow(10, d); //store the value of 10^d
		
		int msd = n / t; // getting the most significant digit of input
		
		return msd*sum + (msd*(msd-1)/2)*t + msd*(1 + n%t) + sumOfDigits(n%t);
	}
}
