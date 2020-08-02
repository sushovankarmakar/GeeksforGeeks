import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.youtube.com/watch?v=rmNK2awrhkU (BEST Video explanation, I followed this) 
// https://practice.geeksforgeeks.org/problems/palindromic-patitioning/0
// https://leetcode.com/problems/palindrome-partitioning-ii/
// https://www.youtube.com/watch?v=lDYIvtBVmgo (Good Video, O(n^3) solution)
// https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/PalindromePartition.java
// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/ (Similar question)

public class DP_MinCutsForPalindromicPartitioning {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String input = br.readLine().trim();
            //System.out.println(getMinNumberOfCutsForPalindromePartitioning1(input)); // time complexity : O(n^3), space complexity : O(n^2)
            System.out.println(getMinNumberOfCutsForPalindromePartitioning2(input));  //  time complexity : O(n^2), space complexity : O(n)
        }
    }


    /*
    * APPROACH - 1 : time complexity : O(n^2), space complexity : O(n)
    * TAKE 'banana' as input string and DRY RUN TO UNDERSTAND THE CODE BETTER
    * input string : banana   [b, a, n, a, n, a]
    * minCuts array :         [1, 0, 1, 0, 1, 0]
    * output : minCuts[0] which is 1.
    * so palindromic partitioning will look like this :  b | anana
    * */

    private static int getMinNumberOfCutsForPalindromePartitioning2(String str) {
        if(str == null || str.length() <= 1) return 0;      /*Base case checking*/

        int n = str.length();

        /*minCuts array which will contain the minimum number of cuts required for palindromic partitioning the remaining substring
        so ith index of minCuts indicates the minimum number of cuts required for the subString which starts from ith index
        */
        int[] minCuts = new int[n];
        Arrays.fill(minCuts, Integer.MAX_VALUE);

        minCuts[n - 1] = 0; // (n - 1)th position represents the last character, as it is a single character, we need zero cut

        /* we start looping from the end
           we start looping from 2nd last position to 0th position
        */

        for (int start = n - 2; start >= 0; start--) {
            for (int end = start; end < n; end++) {     // we cut at each 'end' index

                /* We cut at the 'end' index. So we get a substring from start to end. If this substring is palindrome,
                * then check min cuts for the substring which starts from (end + 1)th index */

                String subString = str.substring(start, end + 1);  // second parameter is end + 1 cause second parameter is exclusive

                if(isPalindrome(subString)) {

                    /* if the subString is Palindrome and 'end' is the last index then cutting at this position is not
                    * required actually cause the whole subString is a palindrome */

                    if(end == str.length() - 1) {
                        minCuts[start] = 0;
                        break;
                    }

                    /* 1 is for current cut
                    * and minCuts[end + 1] gives us the min cuts for the substring which starts from (end + 1)th index
                    * so total current cuts = 1 + minCuts[end + 1]
                    *
                    * now take the minimum of already present value and current value
                    * */
                    minCuts[start] = Math.min(minCuts[start], 1 + minCuts[end + 1]);
                }
            }
        }
        return minCuts[0];
    }


    /*APPROACH - 2 : time complexity : in worst case, O(n^3), space complexity : O(n^2)
    https://www.youtube.com/watch?v=lDYIvtBVmgo (Below solution follows this video)*/

    private static int getMinNumberOfCutsForPalindromePartitioning1(String str) {
        int n = str.length();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
        }

        /* first we check number of cuts required for a substring with length 1, then for a substring with length 2,
        * then for a substring with length 3 and so on.
        * */

        int subStringLength = 1;
        while (subStringLength <= n) {
            int i = 0;
            int j = subStringLength - 1;

            while (i < n && j < n) {
                String subString = str.substring(i, j + 1);
                if (isPalindrome(subString)) {
                    /*if the substring is already a palindrome,
                    zero number of cuts required to make it a palindrome*/

                    mat[i][j] = 0;
                }
                else {
                    /*if the current substring is not palindrome then we need to cut at a position
                    * and after cutting we left with two substring : left and right,
                    * so noOfCuts =  (1 +
                    * (min cuts required for left substring palindromic partitioning) +
                    * (min cuts required for right substring palindromic partitioning))
                    * */

                    for (int k = i; k < j; k++) {
                        int noOfCuts = 1 + mat[i][k] + mat[k + 1][j];

                        /*take the minimum of already present value and current value*/
                        mat[i][j] = Math.min(noOfCuts, mat[i][j]);
                    }
                }
                i++;
                j++;
            }
            subStringLength++;
        }

        /*first row represents the whole string, so last cell of first row holds the min cuts required to
        * minimum number of cuts required where all the substrings are palindromic
        * */

        return mat[0][n-1];
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
