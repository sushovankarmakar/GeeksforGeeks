import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/next-permutation/0
// https://leetcode.com/problems/next-permutation/
// https://www.youtube.com/watch?v=quAS1iydq7U&ab_channel=BackToBackSWE (BEST Explanation)
// https://www.youtube.com/watch?v=LuLCLgMElus&ab_channel=takeUforward (BEST Explanation of the intuition behind the algorithm)
// https://github.com/bephrem1/backtobackswe/blob/master/Arrays%2C%20Primitives%2C%20Strings/NextPermutation/NextPermutation.java
// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/

class Arrays_NextPermutation {

	private static void getNextPermutation(int[] nums, int n) {

		int i = n - 2;	/* Grab the index of the 2nd to last element in the array */

		/* Walk backwards. Keep walking until we reach the point right before the decreasing sequence begins.
		When this while loop ends that is where i will stand */

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		/* If i is not the first element we have more work to do.
		If i IS the first element we just skip down to reverse the whole array since the WHOLE array would be decreasing
		meaning we are on our last permutation */

		if (i >= 0) {

			/* Start a pointer at the end of the array, we want to search for
			the smallest item THAT IS GREATER THAN THE ELEMENT AT i

        	Why? Why Why Why. The reason why is that we want to know the NEXT element that is to be planted where i is sitting.
        	THIS WILL ROOT THE NEXT PERMUTATION and represents the smallest change
        	we can make thus ensuring we have exactly the next permutation
      		*/

			int j = n - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}

			/* We swap those elements.

        	Now all that is left is to reverse the decreasing section (it is already sorted in reverse order)
        	to restore it to the first positionality it would be with the new value rooted at i	*/
			swap(nums, i, j);
		}

		/* Perform the reversal on the decreasing section now. We pass in i + 1 since i sits RIGHT BEFORE the
		decreasing section that is on its final permutation */
		reverse(nums, i + 1, n - 1);
	}

	/* Reverses from 'start' to the end of the array 'nums' */
	private static void reverse(int[] nums, int left, int right) {
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] input = br.readLine().trim().split("\\s+");
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(input[i]);
			}

			getNextPermutation(nums, n);

			print(nums, n);
		}
	}

	private static void print(int[] nums, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
}
