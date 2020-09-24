import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
// https://leetcode.com/problems/maximum-product-subarray/
// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity (BEST Resource) (I followed this)
// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity/48320 (BEST Explanation)
// https://www.youtube.com/watch?v=vtJvbRlHqTA&ab_channel=SahilThakur (A good video explanation) (His algo is bit different)
// https://www.youtube.com/watch?v=hJ_Uy2DzE08&ab_channel=KnowledgeCenter (A good video explanation)
// https://www.geeksforgeeks.org/maximum-product-subarray/
// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0 (Similar question)
// https://leetcode.com/problems/maximum-subarray/ (Similar question)

public class DP_ContiguousSubArrayMaxProduct {

    /* this is very similar to the "DP Contiguous SubArray Max Sum Kadane Algo" problem.
    here you keep 2 values: the max cumulative product UP TO current element starting from SOMEWHERE in the past,
    and the minimum cumulative product UP TO current element .
    it would be easier to see the DP structure if we store these 2 values for each index, like maxProduct[i],minProduct[i] .

    At each new element,
    1. u could either add the new element to the existing product, or
    2. start fresh the product from current index (wipe out previous results), hence the 2 Math.max() lines.

    if we see a negative number, the "candidate" for max should instead become the previous min product,
    because a bigger number multiplied by negative becomes smaller, hence the swap() */


    static long getContiguousSubArrMaxProduct(int[] arr, int size) {
        long currMax = arr[0];
        long currMin = arr[0];
        long answer = arr[0];   /* store the result that is the max we have found so far */

        for (int i = 1; i < size; i++) {

            if (arr[i] < 0) {
                /* multiplied by a negative makes big number smaller, small number bigger so we redefine the extremums by swapping them*/

                long temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            /* max/min product for the current number is either the current number itself or the max/min by the previous number times the current one */
            currMax = Math.max(currMax * arr[i], arr[i]);
            currMin = Math.min(currMin * arr[i], arr[i]);

            answer = Math.max(answer, currMax);     /* the newly computed max value is a candidate for our global result */
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            String[] ip = br.readLine().trim().split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(ip[i]);
            }
            System.out.println(getContiguousSubArrMaxProduct(arr, size));
        }
    }
}
