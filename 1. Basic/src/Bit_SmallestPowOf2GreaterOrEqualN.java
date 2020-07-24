import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/smallest-power-of-2-greater-than-or-equal-to-n/0
// https://www.javatpoint.com/binary-numbers-list
// https://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
// https://github.com/mission-peace/interview/blob/master/src/com/interview/bits/NextPowerOf2.java
// https://www.tutorialspoint.com/Java-Bitwise-Operators

// this is used in to find the array size in segment trees

class Bit_SmallestPowOf2GreaterOrEqualN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int num = Integer.parseInt(br.readLine().trim());
			System.out.println(getNexPowerOfTwoApproach2(num));		// for a large number, approach 2 is faster
		}
	}

	private static int getNexPowerOfTwoApproach1(int num) {
		if(num == 0) return 1;

		/* logic : if we do bitwise AND between a number which is the power of 2 and just previous this number
		we will always get zero.
		7 : 0111
		8 : 1000
		7 & 8 = 0000 */

		while((num & (num-1)) !=0) {
			num++;
		}
		return num;
	}

	private static int getNexPowerOfTwoApproach2(int num) {
		if(num == 0) return 1;

		if(num > 0 && (num & (num-1)) == 0)	{	// checks if the number is already a power of 2, then simply return
			return num;
		}

		// in the while loop we are decreasing the number until the number is a power of 2.

		while((num & (num-1)) > 0) {
			num = num & (num-1); // num value gradually decrease, we stop only when we get a value which is a power of 2
		}

		return (num << 1);	// left shift is same as (num * 2). it doubles the value
	}
}
