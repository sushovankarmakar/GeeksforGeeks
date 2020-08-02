import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.youtube.com/watch?v=MiqoA-yF-0M (THE BEST VIDEO EVER <- I followed this)
// https://practice.geeksforgeeks.org/problems/edit-distance/0
// https://leetcode.com/problems/edit-distance/
// https://www.youtube.com/watch?v=We3YDTzNXEk

public class DP_EditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] pq = br.readLine().trim().split("\\s+");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            String[] inputStrings = br.readLine().trim().split("\\s+");
            String strA = inputStrings[0];
            String strB = inputStrings[1];
            System.out.println(getMinOpsRequired(strA, strB, p, q));
        }
    }


    /* time complexity : O(n*m), space complexity : O(n*m) */
    private static int getMinOpsRequired(String strA, String strB, int n, int m) {
        int[][] ops = new int[n + 1][m + 1];

        for(int j = 0; j < ops[0].length; j++) {
            ops[0][j] = j; /*filling up the first row*/
        }

        for(int i = 0; i < ops.length; i++) {
            ops[i][0] = i; /*filling up the first column*/
        }

        for(int i = 1; i < ops.length; i++) {
            for(int j = 1; j < ops[i].length; j++) {

                if(strA.charAt(i - 1) == strB.charAt(j - 1)) {

                    /*if both the character matches then, don't perform any operation just copy from previous state
                    * example :
                    * lets say A[0,5] = "benyam" and B[0,5] = "ephrem"
                    * now at the last index both 'm' matches so now check excluding 'm'.
                    * so excluding 'm', A[0,4] = "benya" and B[0,4] = "ephre".
                    * so whatever value we got while matching A[0,4] with B[0,4] copy that value only
                    *  */

                    ops[i][j] = ops[i - 1][j - 1];
                }
                else {

                    /*if two characters don't match then, we can perform 3 operations
                    * among them, which has minimum value, we need to take that and add 1
                    * 1. REPLACE :
                    * lets say A[0,3] = "beny" and B[0,2] = "eph". then while converting "beny" to "eph", check 'y' with 'h'.
                    * these two characters don't match, so now if we do replace operation then we need to check the cost
                    * while converting A[0,2] to B[0,1] where A[0,2] = "ben" and B[0,1] = "ep"
                    * then add 'h' which effectively substitute 'y' with 'h'.
                    *
                    *
                    * 2. INSERT :
                    * lets say A[0,3] = "beny" and B[0,2] = "eph". then while converting "beny" to "eph", check 'y' with 'h'.
                    * these two characters don't match, so now if we do insert operation we need to check the cost
                    * while converting A[0,3] to B[0,1] where A[0,2] = "beny" and B[0,1] = "ep"
                    * then insert 'h' at the end of 'ep'
                    *
                    *
                    * 3. DELETE :
                    * lets say A[0,3] = "beny" and B[0,2] = "eph". then while converting "beny" to "eph", check 'y' with 'h'.
                    * these two characters don't match, so now if we do delete operation then we need to check the cost
                    * while converting A[0,3] to B[0,1] where A[0,2] = "ben" and B[0,1] = "eph"
                    * which effectively deletes 'h' from the end of 'ep'
                    * */

                    /*  replace(i - 1, j - 1)  | insert (i - 1, j)
                    *   delete (i, j -1)       | (we are here) (i,j)
                    * */

                    int insertCost  = ops[i - 1][j];
                    int deleteCost  = ops[i][j - 1];
                    int replaceCost = ops[i - 1][j -1];

                    /*We want to take the minimum of these 3 options to fix the problem (we add
                    * 1 to the min cost action to symbolize performing the operation)*/

                    ops[i][j] = 1 + Math.min(replaceCost, Math.min(insertCost, deleteCost));
                }
            }
        }
        return ops[n][m];   /*last cell of the matrix ops matrix holds the min operation cost value*/
    }
}
