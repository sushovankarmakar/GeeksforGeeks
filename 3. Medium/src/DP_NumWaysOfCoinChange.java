import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/coin-change/0/
// https://leetcode.com/problems/coin-change-2/
// https://www.youtube.com/watch?v=DJ4a7cmjZY0 (BEST VIDEO EXPLANATION <- I followed this)
// https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem2/ChangeMakingProblem2.java
// https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space

// https://practice.geeksforgeeks.org/problems/number-of-coins/0 (Similar problem)
// https://leetcode.com/problems/coin-change/ (Similar problem)

public class DP_NumWaysOfCoinChange {

    /*
    * amount = 5, coins = [1, 2, 5]
    * using the above test case, draw the 2D dp array and try to understand the sub problem
    */

    /*
    * At each cell at each coins, I've two options.
    *   1. Don't use the current coin to make change the amount.
    *   2. If possible Use the current to make the amount.
    *
    * 1. if we don't choose the current coin, in that case we can make change in mat[i-1][j] ways.
    * 2. if we choose the current coin, in that case subtract this coin from the current amount and
    *   get how many ways that remaining amount can be made change
    *   and this remaining amount sub problem is already solved
    *   So remaining amount can be changed in mat[i][j - coins[i-1]] ways where currentCoin = coins[i - 1]
    *
    * Add these two possibilities to get the current answer.
    * So the relation is :
    * T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]]
    *
    *
    * This is very much similar to 0-1 knapsack problem where also at each step we get two options
    *   1. choose the current thing.
    *   2. don't choose the current thing.
    *
    */

    /* APPROACH - 1
     * if number of coins = C, and amount = A
     * time complexity : O(A * C)
     * space complexity : O(A * C)
     */
    private static int numWaysToMakeChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 0; i <= coins.length; i++) {   /* filling up the 0th column */
            dp[i][0] = 1;  /* if the amount is zero, then there is only 1 way to fulfill the amount i.e doing nothing */
        }

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                int currentCoinValue = coins[i - 1];

                /*
                 * dp[i][j] will be the sum of
                 * the ways to make change not considering this coin (dp[i-1][j]) and
                 * the ways to make change considering this coin (dp[i][j] - currentCoinValue)
                 * ONLY if currentCoinValue <= j, otherwise this coin can not contribute to the total # of ways
                 * to make change at this sub problem target amount
                 */

                int withOutThisCoin = dp[i - 1][j];
                int withThisCoin = (j >= currentCoinValue) ? dp[i][j - currentCoinValue] : 0;

                dp[i][j] = withOutThisCoin + withThisCoin;
            }
        }

        /*
        * The answer considering ALL coins for the FULL amount is what we want to return as the answer
        */
        return dp[coins.length][amount];
    }

    /* Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]],
     * then we can optimize the space by only using one-dimension array.
     */

    /* APPROACH - 2
     * if number of coins = C, and amount = A
     * time complexity : O(A * C)
     * space complexity : O(A)
     */
    private static int numWaysToMakeChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;  /* if the amount is zero, then there is only 1 way to fulfill the amount i.e doing nothing */

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                int currentCoinValue = coins[i - 1];

                /*
                 * dp[j] will be the sum of
                 * the ways to make change not considering this coin (dp[j]) and
                 * the ways to make change considering this coin (dp[j] - currentCoinValue)
                 * ONLY if currentCoinValue <= j, otherwise this coin can not contribute to the total # of ways
                 * to make change at this sub problem target amount)
                 */

                int withOutThisCoin = dp[j];
                int withThisCoin = (j >= currentCoinValue) ? dp[j - currentCoinValue] : 0;

                dp[j] = withOutThisCoin + withThisCoin;
            }
        }

        /*
         * The answer considering ALL coins for the FULL amount is what we want to return as the answer
         */
        return dp[amount];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- >0) {
            int numOfCoins  = Integer.parseInt(br.readLine().trim());
            String[] input  = br.readLine().trim().split("\\s+");
            int[] coins     = new int[numOfCoins];
            int amount      = Integer.parseInt(br.readLine().trim());

            for(int i = 0; i < numOfCoins; i++) {
                coins[i] = Integer.parseInt(input[i]);
            }

            System.out.println(numWaysToMakeChange1(coins, amount));    /* approach 1 -> space : O(coins * amount) */
            System.out.println(numWaysToMakeChange2(coins, amount));    /* approach 2 -> space : O(amount) */
        }
    }
}
