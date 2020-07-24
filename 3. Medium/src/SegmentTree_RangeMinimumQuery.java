import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 24.07.2020
// https://practice.geeksforgeeks.org/problems/range-minimum-query/1
// https://www.youtube.com/watch?v=ZBHKZF5w4YU (Hands down, BEST VIDEO EXPLANATION) (I followed this)
// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java
// https://www.youtube.com/results?search_query=segment+tree

/*Time complexity to create segment tree is O(n) since new array will be at max 4n size
        * Space complexity to create segment tree is O(n) since new array will be at max 4n size
        * Time complexity to search in segment tree is O(log(n)) since you would at max travel 4 depths
        * Time complexity to update in segment tree is O(log(n))
        * Time complexity to update range in segment tree is O(range)
 */

public class SegmentTree_RangeMinimumQuery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[] input = new int[n];
            for (int i = 0; i < str.length; i++) {
                input[i] = Integer.parseInt(str[i]);
            }
            int[] segmentTree = buildSegmentTree(n, input);

            for (int val : segmentTree) {
                System.out.print(val + " ");
            }
            System.out.println();


            // queries in segment tree
            int numOfQueries = Integer.parseInt(br.readLine().trim());
            String[] queries = br.readLine().trim().split("\\s+");
            for (int i = 0; i < numOfQueries; i++) {
                int lowOfQueryRange  = Integer.parseInt(queries[i*2]);
                int highOfQueryRange = Integer.parseInt(queries[i*2 + 1]);

                int minValueInTheRange = rangeQuery(n, input, segmentTree, lowOfQueryRange, highOfQueryRange);
                System.out.println(minValueInTheRange);
            }

            System.out.println("Update");
            String[] updateQueries = br.readLine().trim().split("\\s+");
            int indexToBeUpdated = Integer.parseInt(updateQueries[0]);
            int updatedValue = Integer.parseInt(updateQueries[1]);
            updateSegmentTree(n, input, segmentTree, indexToBeUpdated, updatedValue);

            for (int val : input) {
                System.out.print(val + " ");
            }
            System.out.println();

            for (int val : segmentTree) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static int[] buildSegmentTree(int n, int[] input) {
        int maxSizeOfSegmentTree = getSizeOfTheSegmentTree(n);  // n is input array's length
        int[] segmentTree = new int[maxSizeOfSegmentTree];  // in the worst case, max size will be 4*n
        Arrays.fill(segmentTree, Integer.MAX_VALUE);  // it is min value segment tree, so initially max value is filled.

        int rootOfTheSegmentTree = 0; // when binary tree is represented in an array, then 0 indicates the root of the binary tree
        buildMinSegmentTree(input, segmentTree, 0, n-1, rootOfTheSegmentTree);

        return segmentTree;
    }

    private static void buildMinSegmentTree(int[] input, int[] segmentTree, int low, int high, int pos) {
        if(low == high) {
            segmentTree[pos] = input[low];  // here we are filling the values of leaf nodes of the tree
            return;
        }
        int mid = low + (high - low)/2;

        buildMinSegmentTree(input, segmentTree, low, mid, (2*pos + 1));         // (2*pos + 1) indicates the left child
        buildMinSegmentTree(input, segmentTree, mid + 1, high, (2*pos + 2)); // (2*pos + 2) indicates the right child

        segmentTree[pos] = Math.min(segmentTree[2*pos + 1], segmentTree[2*pos + 2]);    // putting value in the parent position
    }

    private static int rangeQuery(int n, int[] input, int[] segmentTree, int qLow, int qHigh) {
        int rootOfTheSegmentTree = 0;
        return rangeMinQuery(segmentTree, qLow, qHigh, 0, n-1, rootOfTheSegmentTree);
    }

    // qLow : low of range query, qHigh : high of range query
    // low : input array's low, high : input array's high

    private static int rangeMinQuery(int[] segmentTree, int qLow, int qHigh, int low, int high, int pos) {

        if(qLow <= low && high <= qHigh) return segmentTree[pos];   // total overlap of intervals so return current position's value

        if(high < qLow || qHigh < low)  return Integer.MAX_VALUE;   // no overlap so return MAX value (cause this is min query)

        // partial overlap, so traverse both the children
        int mid = low + (high - low)/2;

        return Math.min(rangeMinQuery(segmentTree, qLow, qHigh, low, mid, (2*pos + 1)),   // traverse in the left child
                        rangeMinQuery(segmentTree, qLow, qHigh, mid+1, high, (2*pos + 2))); // traverse in the right child
    }

    private static void updateSegmentTree(int n, int[] input, int[] segmentTree, int indexToBeUpdated, int updatedValue) {
        int rootOfTheSegmentTree = 0;
        updateMinSegmentTree(input, segmentTree, 0, n-1, rootOfTheSegmentTree, indexToBeUpdated, updatedValue);
    }

    private static void updateMinSegmentTree(int[] input, int[] segmentTree, int low, int high, int pos,
                                             int indexToBeUpdated, int updatedValue) {
        if(indexToBeUpdated < low || high < indexToBeUpdated) return;

        if(low == high) {
            input[indexToBeUpdated] = updatedValue;
            segmentTree[pos] = updatedValue;
            return;
        }

        int mid = low + (high - low)/2;
        updateMinSegmentTree(input, segmentTree, low, mid, (2*pos + 1), indexToBeUpdated, updatedValue);
        updateMinSegmentTree(input, segmentTree, mid + 1, high, (2*pos + 2), indexToBeUpdated, updatedValue);

        segmentTree[pos] = Math.min(segmentTree[2*pos + 1], segmentTree[2*pos + 2]);
    }

    private static int getSizeOfTheSegmentTree(int n) {
        /*
        if input len is pow of 2 then size of segment tree is 2*length - 1, otherwise
        size of segment tree is (nextPowerOf2 * 2) - 1.
        example :
        n = 4, maxSizeOfSegmentTree = 4*2 -1 = 7
        n = 5, maxSizeOfSegmentTree = 8*2 - 1 = 15
        */

        int nextPowerOf2 = getNextPowerOf2(n);
        int maxSizeOfSegmentTree = (nextPowerOf2 * 2) - 1;
        return maxSizeOfSegmentTree;
    }

    private static int getNextPowerOf2(int num) {
        // https://github.com/sushovankarmakar/GeeksforGeeks/blob/master/1.%20Basic/src/Bit_SmallestPowOf2GreaterOrEqualN.java

        if(num == 0) return 1;

        if(num > 0 && (num & (num-1)) == 0) return num; // if the number is already a power of 2, return that value

        while((num & (num-1)) > 0) {
            num = num & (num-1); // num value gradually decrease, we stop only when we get a value which is a power of 2
        }

        return (num << 1);  // left shift is same as (num * 2). it doubles the value
    }
}
