import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
// https://www.youtube.com/watch?v=oaVa-9wmpns (BEST Video Explanation)
// https://leetcode.com/problems/sort-colors/
// https://www.geeksforgeeks.org/sort-array-0s-1s-2s-simple-counting/
// https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/


class Arrays_SortArrayOf0s1s2s_DutchNationalFlagAlgo {

	private static void sortArrayOf0s1s2sByDutchNationalFlagAlgo(int[] values) {
		int left = 0;
		int mid = 0;
		int right = values.length - 1;

		while(mid <= right) {

			switch (values[mid]) {
				case 0: swap(values, left, mid);
						left++; mid++;
						break;

				case 1:	mid++;
						break;

				case 2: swap(values, mid, right);
						right--;
						break;
			}
		}
	}

	private static void swap(int[] values, int a, int b) {
		int temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}

	private static void sortArrayOf0s1s2s(int[] values) {
		StringBuilder sb0 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int value : values) {
			if(value == 0) sb0.append(0 + " ");
			else if(value == 1) sb1.append(1 + " ");
			else if(value == 2) sb2.append(2 + " ");
		}

		System.out.println(sb0.append(sb1).append(sb2));
		sb0.setLength(0);
		sb1.setLength(0);
		sb2.setLength(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] input = br.readLine().trim().split("\\s+");
			int[] values = new int[n];

			for (int i = 0; i < n; i++) {
				values[i] = Integer.parseInt(input[i]);
			}

			//sortArrayOf0s1s2s(values);

			// using Dutch National Flag
			sortArrayOf0s1s2sByDutchNationalFlagAlgo(values);
			StringBuilder sb = new StringBuilder();
			for (int value : values) {
				sb.append(value + " ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
