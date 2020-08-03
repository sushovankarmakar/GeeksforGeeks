import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/total-decoding-messages/0
// https://leetcode.com/problems/decode-ways/
// https://www.youtube.com/watch?v=qli-JCrSwuk (BEST VIDEO TUTORIAL <- From Recursive to Dynamic)
// https://www.youtube.com/watch?v=YcJTyrG3bZs (I followed this solution)
// https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/DecodeWays/Recursive.java

public class DP_NumWaysDecodeMessage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String decodedMessage = br.readLine().trim();
            System.out.println(numDecodingRecursiveSolution(decodedMessage));
            System.out.println(numDecodingDPSolution(decodedMessage));
        }
    }


    /* DYNAMIC PROGRAMMING APPROACH :
     * time complexity  : O(n) , no more repetitive calculation
     * space complexity : O(n) dp array size */
    private static int numDecodingDPSolution(String str) {
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);

        return numDecodingUtilDP(str, 0, dp);
    }

    private static int numDecodingUtilDP(String str, int decodePointer, int[] dp) {

        if(decodePointer >= str.length()) {
            return 1;   /* "" is a valid decomposition */
        }

        if(dp[decodePointer] > -1) {
            /* this sub-problem is already solved and has a value.
            * so don't repeat the calculation, just return the value.
            * actually this creates a difference between dp and recursive solution
            * by not doing the repetitive calculation */

            return dp[decodePointer];
        }

        int totalNumberWaysToDecode = 0;

        for(int i = 1; i <= 2; i++) {   /* we can take 1 character or 2 characters */

            if(decodePointer + i <= str.length()) {
                String snippet = str.substring(decodePointer, decodePointer + i);

                if(isValid(snippet)) {
                    totalNumberWaysToDecode += numDecodingUtilDP(str, decodePointer + i, dp);
                }
            }
        }

        dp[decodePointer] = totalNumberWaysToDecode;    /* store the sub-problem answer before returning */

        return dp[decodePointer];
    }


    /* RECURSIVE APPROACH : it will give TLE
    * time complexity : O(2^n) cause in every step we can have 2 options to choose
    * space complexity : O(n) stack size */
    private static int numDecodingRecursiveSolution(String str) {
        return numDecodingUtilRecursive(str, 0);
    }

    private static int numDecodingUtilRecursive(String str, int decodePointer) {

        if(decodePointer >= str.length()) return 1;

        int totalNumOfWaysToDecode = 0;

        for(int i = 1; i <= 2; i++) {

            if(decodePointer + i <= str.length()) {
                String snippet = str.substring(decodePointer, decodePointer + i);

                if(isValid(snippet)) {
                    totalNumOfWaysToDecode += numDecodingUtilRecursive(str, decodePointer + i);
                }
            }
        }
        return totalNumOfWaysToDecode;
    }

    private static boolean isValid(String str) {
        if(str.length() == 0 || str.charAt(0) == '0') {
            /* if there are leading 0's then that is not a valid string */
            return false;
        }

        int value = Integer.parseInt(str);

        return (1 <= value && value <= 26);
    }
}
