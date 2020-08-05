import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/number-of-coins/0
// https://leetcode.com/problems/coin-change/
// https://www.youtube.com/watch?v=jgiZlGzXMBw (BEST VIDEO EXPLANATION : I followed this)
// https://www.youtube.com/watch?v=Y0ZqKpToTic

// https://practice.geeksforgeeks.org/problems/coin-change/0/ (Similar problem)
// https://leetcode.com/problems/coin-change-2/ (Similar problem)

public class DP_MinNumOfCoinChange {

    /* We will solve this using bottom up approach.
    * So at each cell of the dp array represents an amount.( which is basically a sub problem to the main problem)
    * So to fulfill this amount, we have options to use all the coins each time
    * So at each cell we'll use that coin and check that if I use this coin then
    * What is the remaining amount and what is the minimum number of coins need to fulfill the remaining amount.
    * (minimum number of coins required is already calculated, so go to that  cell and take that amount)
    * So presentValue = min(presentValue, 1 + value of remainingAmount)
    * */

    /*
    * if number of coins = C, and amount = A
    * time complexity : O(A * C)
    * space complexity : O(A)
    * */
    private static int minNumOfCoinChange(int[] coins, int amount) {
        int max = amount + 1;           /* We use this to fill the dp table with default values */
        int[] dp = new int[amount + 1]; /* This table will store the answer to our sub problems */
        Arrays.fill(dp, max);           /* Initialize the dp table */

        /* The answer to making change with minimum coins for 0
         * will always be 0 coins no matter what the coins we are given are */
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {                   /* Solve every sub-problem from 1 to amount */
            for (int coin : coins) {                           /* For each coin we are given */
                if (i >= coin) {                               /* If it is less than or equal to the sub problem amount */
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); /* Try it. See if it gives us a more optimal solution */
                }
            }
        }

        /* dp[amount] has our answer. If we do not have an answer then dp[amount]
         * will be amount + 1 and hence dp[amount] > amount will be true. We then return -1.
         * Otherwise, dp[amount] holds the answer
         * */

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String[] details = br.readLine().trim().split("\\s+");
            int amount = Integer.parseInt(details[0]);
            int numOfCoins = Integer.parseInt(details[1]);

            String[] input = br.readLine().trim().split("\\s+");
            int[] coins = new int[numOfCoins];
            for(int i = 0; i < input.length; i++) {
                coins[i] = Integer.parseInt(input[i]);
            }
            System.out.println(minNumOfCoinChange(coins, amount));
        }
    }
}
