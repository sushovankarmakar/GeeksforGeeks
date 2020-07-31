import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://practice.geeksforgeeks.org/problems/nth-fibonacci-number/0
// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/ (BEST Resource)
// https://www.geeksforgeeks.org/large-fibonacci-numbers-java/
// https://www.youtube.com/watch?v=L4Rgq8J7ZzA

// https://leetcode.com/problems/climbing-stairs/solution/ (similar problem)
// https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0 (similar problem)

class Math_NthFibonacciNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(getNthFibonacciNum1(n)); // this approach works for very large number as well.
			//System.out.println(getNthFibonacciNum2(n));
			//System.out.println(getNthFibonacciNum3(n));
		}
	}

	// APPROACH - 1
	private static int getNthFibonacciNum1(int n) {
		int modulo = 1000000007;
		int secondLastNumber = 1;
		int lastNumber = 1;
		int currentNumber = lastNumber + secondLastNumber;
		if(n <= 2) return lastNumber;

		for (int i = 3; i <= n; i++) {
			currentNumber = (lastNumber + secondLastNumber) % modulo;
			secondLastNumber = lastNumber;
			lastNumber = currentNumber;
		}
		return currentNumber;
	}

	// APPROACH - 2
	private static BigInteger getNthFibonacciNum2(int n) {
		BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c = new BigInteger("0");
		for (int i = 2; i < n; i++) {
			c = (a.add(b)).remainder(new BigInteger("1000000007"));
			a = b;
			b = c;
		}
		return b.remainder(new BigInteger("1000000007"));
	}


	/*
	APPROACH - 3 (Don't work for very large input)
	Using fibonacci Formula or Binet's Formula

	F(n) = (1/sqrt(5)) * [ ((1 + sqrt(5))/2)^(n+1) - ((1 - sqrt(5))/2)^(n+1) ]

	https://www.youtube.com/watch?v=3vbHTi6sID0
	*/
	private static int getNthFibonacciNum3(int n) {
		n = n - 1;
		double sqrt5 = Math.sqrt(5);
		double fibn = Math.pow( (1 + sqrt5)/2, (n + 1)) - Math.pow( (1 - sqrt5)/2, (n + 1));
		return (int)(fibn/sqrt5);
	}
}
