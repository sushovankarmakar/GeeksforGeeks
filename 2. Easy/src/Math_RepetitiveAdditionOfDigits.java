import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// this problem has two variants - one in GFG and other one in HackerRank
// Both the variant's solution is here.

// https://practice.geeksforgeeks.org/problems/repetitive-addition-of-digits/0
// https://www.geeksforgeeks.org/finding-sum-of-digits-of-a-number-until-sum-becomes-single-digit/
// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
// https://www.hackerrank.com/challenges/recursive-digit-sum/forum/comments/523856 (BEST solution using Java 8)
// http://applet-magic.com/digitsummod9.htm (a good read)
// https://www.youtube.com/watch?v=kHzcrbKHFbw

class Math_RepetitiveAdditionOfDigits {

	// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
	// below is the solution of above problem
	static int superDigit(String n, int k) {
		BigInteger sum = BigInteger.valueOf(k).multiply(new BigInteger(n));
		return digitSum(sum).intValue();
	}

	static BigInteger digitSum(BigInteger n) {
		if(n.equals(BigInteger.ZERO)) return BigInteger.ZERO;

		return (n.mod(BigInteger.valueOf(9)).equals(BigInteger.ZERO))
				? BigInteger.valueOf(9) : n.mod(BigInteger.valueOf(9));
	}

	// https://www.hackerrank.com/challenges/recursive-digit-sum/forum/comments/523856

	static int superDigitUsingJava8 (String n, int k) {
		n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";

		return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));
	}


	//-------------------------------------------------------------------------------------

	// logic is If N is multiple of 9 then the answer is 9 else answer is N mod 9
	private static int getDigitSum(int n) {
		if(n == 0) return 0;
		return (n % 9 == 0) ? 9 : (n % 9);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(getDigitSum(n));
		}
	}

	/*public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int d = 0;
			while(n!=0) {
				d = n % 10;
				sum += d;
				n /= 10;
				
				if((sum > 9) & (n==0)) {
					n = sum;
					sum = 0;
				}
			}
			System.out.println(sum);
		}
	}*/
}


//one line solution
// If N is multiple of 9 then the answer is 9 else answer is N mod 9 
/*
if (n == 0) 
    return 0;
    return (n % 9 == 0) ? 9 : (n % 9);
 */
    