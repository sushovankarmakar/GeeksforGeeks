import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/circular-tour/1
// https://leetcode.com/problems/gas-station/
// https://www.youtube.com/watch?v=nTKdYm_5-ZY (BEST Video explanation)
// https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas. (BEST article)
// https://www.youtube.com/watch?v=zcnVaVJkLhY (Good video)

public class Arrays_CircularTourOfGasStation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");

            int[] gas  = new int[n];
            int[] cost = new int[n];

            for(int i = 0; i < n; i++) {
                gas[i]  = Integer.parseInt(input[i*2]);
                cost[i] = Integer.parseInt(input[i*2 + 1]);
            }

            //System.out.println(canCompleteCircuit1(gas, cost));
            System.out.println(canCompleteCircuit2(gas, cost));
        }
    }

    /*
    * APPROACH 2 :
    * time complexity : O(n), space complexity : O(1)
    * */

    private static int canCompleteCircuit2(int[] gas, int[] cost) {
        int tourLength = gas.length;

        int start = 0;      /* this is the initial starting position */
        int surplus = 0;    /* surplus : the amount of petrol we have in the petrol tank */
        int deficit = 0;    /* deficit : the lack of petrol to cover some distance in the petrol station */

        for (int i = 0; i < tourLength; i++) {

            surplus = surplus + gas[i] - cost[i];

            if(surplus < 0) {        /* surplus < 0 means that is actually a deficit, so we need to add that to the deficit also */
                start = i + 1;       /* ith position can't be the starting position, try for the (i + 1)th position */
                deficit += surplus;  /* we are updating the deficit */
                surplus = 0;         /* as starting position is changing so, surplus will be zero again */
            }
        }

        /* if surplus + deficit >= 0 then that means we have enough fuel
        *  to have a circular tour staring from 'start' position
        * */

        return (surplus + deficit >= 0 ) ? start : -1;
    }


    /*
    * APPROACH 1 : brute force naive approach
    * time complexity : in worst case O(n^2), space complexity : O(1)
    * consider every petrol pumps as a starting point and see if there is a possible tour.
    * If we find a starting point with a feasible solution, we return that starting point.
    * The worst case time complexity of this solution is O(n^2)
    * */

    private static int canCompleteCircuit1(int[] gas, int[] cost) {
        int tourLength = gas.length;

        for(int i = 0; i < tourLength; i++) {

            /*
            * we will start from a particular position if and only if in that position
            * gas[i] - cost[i] >= 0
            */
            if(gas[i] - cost[i] >= 0) {
                if(isTourPossible(i, gas, cost, tourLength)) return i;
            }
        }
        return -1;
    }

    private static boolean isTourPossible(int currPos, int[] gas, int[] cost, int tourLength) {

        int initialPos = currPos;   /*storing the initial position so that we can check later*/
        int currGasAmount = gas[currPos]; /*currGasAmount indicates how much gas we can collect from current gas station*/
        int travelCost = cost[currPos]; /*travelCost indicates how much cost I need to travel from current position to next position*/

        while(currGasAmount >= travelCost) {  /*checking can I afford to travel using current gas amount*/

            currPos = (currPos + 1) % tourLength;   /*updating the current position*/

            currGasAmount = (currGasAmount - travelCost) + gas[currPos];  /*updating the current gas amount*/

            travelCost = cost[currPos];

            if(initialPos == currPos) return true;
        }

        return false;
    }
}
