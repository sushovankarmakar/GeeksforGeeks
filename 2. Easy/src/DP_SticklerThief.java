import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/stickler-theif/0
// https://leetcode.com/problems/house-robber/
// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents/0 (Similar Problem)
// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
// https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
// https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems. (BEST Resource)
// https://www.youtube.com/watch?v=xlvhyfcoQa4 (Good video explanation)

class DP_SticklerThief {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().trim().split("\\s+");
			int[] ip = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			//System.out.println(getMaximumMoney1(ip));
			//System.out.println(getMaximumMoney2(ip));
			System.out.println(getMaximumMoney3(ip));	// BEST approach. Easy to understand.
		}
	}

	private static int getMaximumMoney1(int[] ip) {
		int include = ip[0];
		int exclude = 0;

		for (int i = 1; i < ip.length; i++) {

			int oldInclude = include;
			include = Math.max(include, exclude+ip[i]);
			exclude = Math.max(exclude, oldInclude);
		}
		return Math.max(include, exclude);
	}

	// APPROACH 2 : Using dynamic programming
	// time complexity : O(n), space complexity : O(1)
	private static int getMaximumMoney2(int[] house) {
		int n = house.length;
		if(n == 1) return house[0];
		if(n == 2) return Math.max(house[0], house[1]);

		int[] maxMoney = new int[n];
		maxMoney[0] = house[0];
		maxMoney[1] = Math.max(house[0], house[1]);

		/* on every ith position,
		* a robber has two options : 1. rob this current house 2. don't rob this house
		* if he robs current ith house, then total money he gets is :  (house[i] + maxMoney[i - 2])
		* if he don't rob current ith house, then total money he gets is : maxMoney[i - 1]
		* now we have to take the max between these two options on each ith position
		* to get the maximum amount of money at the end of the array
		* */
		for (int i = 2; i < n; i++) {
			maxMoney[i] = Math.max(house[i] + maxMoney[i - 2], maxMoney[i - 1]);
		}

		/*each step we choose the max money we can rob,
		so at the last index we'll have the max money we can make from whole array*/
		return maxMoney[n-1];
	}

	// APPROACH 2 : Using dynamic programming
	// time complexity : O(n), space complexity : O(1)
	private static int getMaximumMoney3(int[] house) {
		int n = house.length;
		if(n == 1) return house[0];
		if(n == 2) return Math.max(house[0], house[1]);

		int moneyRobbedFromSecondLastHouse = house[0];
		int moneyRobbedFromLastHouse = Math.max(house[0], house[1]);
		int moneyRobbedFromCurrentHouse = 0;

		/* We can notice that in the method 2 we use only maxMoney[i-2] and maxMoney[i-1],
		* so going just 2 steps back. We can hold them in 2 variables instead.
		* This optimization is met in Fibonacci sequence creation
		* */

		for (int i = 2; i < n; i++) {
			moneyRobbedFromCurrentHouse = Math.max(house[i] + moneyRobbedFromSecondLastHouse, moneyRobbedFromLastHouse);
			moneyRobbedFromSecondLastHouse = moneyRobbedFromLastHouse;
			moneyRobbedFromLastHouse = moneyRobbedFromCurrentHouse;
		}

		return moneyRobbedFromCurrentHouse;
	}
}
