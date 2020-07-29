import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/majority-element/0
// https://leetcode.com/problems/majority-element/
// https://www.geeksforgeeks.org/majority-element/
// https://www.youtube.com/watch?v=bg6r_fgtpMQ (BEST video tutorial)
// https://www.youtube.com/watch?v=0s3zqYaDInE (Using Bit masking)

class Arrays_MajorityElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split("\\s+");
			int[] input = new int[n];
			for (int i = 0; i < input.length; i++) {
				input[i] = Integer.parseInt(str[i]);
			}
			//System.out.println(getMajorityElement1(input)); // time complexity : O(n), space complexity : O(n)
			System.out.println(getMajorityElement2(input)); // time complexity : O(n), space complexity : O(1)
		}
	}

	// METHOD-1
	private static int getMajorityElement1(int[] input) {
		int majority = input.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : input) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if(map.get(num) > majority) return num;
		}
		return -1;
	}

	// METHOD-2 (Boyer-Moore Voting Algorithm)
	private static int getMajorityElement2(int[] input) {
		int probableMajorityCandidate = findProbableMajorityCandidate(input);
		return isMajority(probableMajorityCandidate, input) ? probableMajorityCandidate : -1;
	}

	private static int findProbableMajorityCandidate(int[] input) {
		int count = 1;
		int currentMajorityCandidate = input[0];

		for(int i = 1; i < input.length; i++) {
			if(count == 0) currentMajorityCandidate = input[i];
			count += (currentMajorityCandidate == input[i]) ? 1 : -1;
		}
		return currentMajorityCandidate;
	}

	private static boolean isMajority(int probableMajorityCandidate, int[] input) {
		int majority = input.length / 2;
		int count = 0;
		for (int num : input) {
			if(num == probableMajorityCandidate) count++;
		}
		return (count > majority);
	}
}
