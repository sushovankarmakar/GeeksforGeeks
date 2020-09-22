import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
// https://www.geeksforgeeks.org/find-the-repeating-and-the-missing-number-using-two-equations/
// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ (VERY Important post)

// submitted this below solution : create a frequency array of size n and if array element is 0, then it is missing and element is >1
// then it is the repeated element.
// https://ide.geeksforgeeks.org/sMXXKQlCUc

// https://www.youtube.com/watch?v=5nMGY4VUoRY&ab_channel=takeUforward (BEST Video Solution)
// https://www.youtube.com/watch?v=OTkoJOP6m6w&ab_channel=TECHDOSE
// https://www.youtube.com/watch?v=gWhSiGETn9Y&ab_channel=CodingandSystemDesignInterviews

class Arrays_FindMissingAndRepeating {

	/* Most important and efficient approach */
	private static int[] getMissingAndRepeatingNumber1(int[] arr, int n) {
		int xor = 0;	/* will hold xor of all elements and numbers from 1 to n */

		for (int i = 0; i < n; i++) {
			xor ^= arr[i];	/* Get the xor of all array elements */
		}

		for (int i = 1; i <= n; i++) {
			xor ^= i;	/* XOR the previous result with numbers from  1 to n */
		}

		int setBitNum = xor & ~(xor - 1);	/* Get the rightmost set bit in setBitNum */


		/* Now divide elements into two sets by comparing rightmost set bit of xor1 with the bit at the same
		position in each element.
		Also, get XORs of two sets. The two XORs are the output elements.
		The following two for loops serve the purpose */

		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {

			if ((arr[i] & setBitNum) != 0)
				x ^= arr[i];
			else
				y ^= arr[i];
		}

		for (int i = 1; i <= n; i++) {
			if ((i & setBitNum) != 0)
				x ^= i;
			else
				y ^= i;
		}


		/* This method does not cause overflow, but it does not tell which one occurs twice and which one is missing.
		We can add one more step that checks which one is missing and which one is repeating.
		This can be easily done in O(n) time. */

		int missingNum = 0;
		int repeatedNum = 0;

		for (int i = 0; i < n ; i++) {
			if (arr[i] == x) {
				repeatedNum = x;
				missingNum = y;
				break;
			}
			else if (arr[i] == y) {
				repeatedNum = y;
				missingNum = x;
				break;
			}
		}

		return new int[]{repeatedNum, missingNum};
	}

	/* Below approach will produce right answer but will give TLE in GFG compiler */
	private static int[] getMissingAndRepeatingNumber2(int[] arr, int n) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int missingNum = 0, repeatedNum = 0;
		for (int i = 1; i <= n; i++) {
			if (map.get(i) == null) {
				missingNum = i;
			} else if (map.get(i) > 1) {
				repeatedNum = i;
			}
		}

		return new int[]{repeatedNum, missingNum};
	}

	/* Below two approaches won't work in case of numbers are very big */
	private static int[] getMissingAndRepeatingNumber3(int[] arr, int n) {

		int sumOfN = n * (n + 1) / 2;
		int sumOfNSquare = (n * (n + 1) * (2 * n + 1))/6;

		for(int i = 0; i < n; i++) {
			sumOfN -= arr[i];
			sumOfNSquare -= (arr[i] * arr[i]);
		}

		int missingNum = (sumOfN + (sumOfNSquare / sumOfN) ) / 2;
		int repeatedNum = missingNum - sumOfN;

		return new int[]{repeatedNum, missingNum};
	}

	private static int[] getMissingAndRepeatingNumber4(int[] arr, int n) {

		int sumOfArray = 0;
		int sumOfN = n * (n + 1) / 2;
		int sumOfArraySquare = 0;
		int sumOfNSquare = (n * (n + 1) * (2 * n + 1))/6;

		for(int i = 0; i < n; i++) {
			sumOfArray += arr[i];
			sumOfArraySquare += (arr[i] * arr[i]);
		}

		int missingNum = ((sumOfN - sumOfArray)  + (sumOfNSquare - sumOfArraySquare) / (sumOfN - sumOfArray)) / 2;
		int repeatedNum = missingNum - (sumOfN - sumOfArray);

		return new int[]{repeatedNum, missingNum};
	}

	/* MAIN METHOD starts here */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] ip = br.readLine().trim().split("\\s+");
			int[] arr = new int[n];
			for(int i = 0; i< n; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}

			int[] output1 = getMissingAndRepeatingNumber1(arr, n);
			System.out.println(output1[0] + " " + output1[1]);

			int[] output2 = getMissingAndRepeatingNumber2(arr, n);
			System.out.println(output2[0] + " " + output2[1]);

			int[] output3 = getMissingAndRepeatingNumber3(arr, n);
			System.out.println(output3[0] + " " + output3[1]);

			int[] output4 = getMissingAndRepeatingNumber4(arr, n);
			System.out.println(output4[0] + " " + output4[1]);
		}
	}
}