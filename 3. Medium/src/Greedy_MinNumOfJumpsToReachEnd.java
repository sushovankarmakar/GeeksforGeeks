import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
// https://leetcode.com/problems/jump-game-ii/
// https://www.youtube.com/watch?v=vBdo7wtwlXs (Best video explanation) (I followed this)
// https://www.youtube.com/watch?v=PEgwWGoKUaY

// https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
// https://stackoverflow.com/questions/27858356/how-to-find-minimum-number-of-jumps-to-reach-the-end-of-the-array-in-on-time

// https://leetcode.com/problems/jump-game/ (Similar Problem) (To solve this we can use the exact same approach which has been used here)


public class Greedy_MinNumOfJumpsToReachEnd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[] input = new int[n];
            for (int i = 0; i < input.length; i++) {
                input[i] = Integer.parseInt(str[i]);
            }
            System.out.println(findMinNumJumpsToReachEnd(input));
        }
    }

    /* Corner Case example :
    * Input :
    * 6
      3 1 1 1 0 3
    * Output : -1  (we can't end of the array)
    * */

    // Greedy Solution : time complexity : O(n), space complexity : O(1)
    private static int findMinNumJumpsToReachEnd(int[] path) {
        // Sometimes this is called Valley peak approach
        /* We will solve this using ladder-stairs-jump analogy :
        1. At every index collect a ladder
            a. store it is large enough
            b. throw if it is small
        2. and keep climbing current ladder
        3. if the current ladder is over, use the ladder you have stored */


        /*BASE CASE : if path length is less than 2, then we don't need any jump,
        we already at the end of the path. example: [0] */
        if(path.length < 2 ) return 0;

        /*BASE CASE : if the path length is more than 1 and if the first value of the path is 0,
        then we can't reach to the end of the path, so return -1.  example: [0, 2, 1]*/
        if(path[0] == 0) return -1;

        int ladder = path[0];
        int stairs = path[0];
        int jumps  = 1;

        for (int level = 1; level < path.length; level++) {
            if(level == path.length - 1) return jumps;    /*we have come to the end of the path, return current jumps*/

            /*along the path, each level we try to find the better ladder which has more reach than the current ladder reach
            and if we get a better ladder (level + path[level]) than current ladder,
            then take that better ladder, which will be used when current ladder's stairs are finished*/
            if(level + path[level] > ladder) {
                ladder = level + path[level];
            }

            stairs--;   /*at each step, reduce the stairs*/

            /*if stairs is zero means it is the end of the current ladder,
            so we need to jump to another ladder*/
            if(stairs == 0) {
                jumps++;
                stairs = ladder - level;    /*get the remaining number of stairs which we need to travel more*/


                /*CORNER CASE : if remaining number of stairs is less or equal to 0,
                that means we can't proceed further, so return -1*/
                if(stairs <= 0) return -1;
            }
        }
        return jumps;
    }
}
