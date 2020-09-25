import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/non-overlapping-intervals/
// https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution/687712 (I followed this)
// https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most (A good post to understand)
// https://practice.geeksforgeeks.org/problems/overlapping-intervals/0 (Similar Problem)
// https://leetcode.com/problems/merge-intervals/ (Very much Similar Problem) (To understand current problem, solve the similar problem first. Just 3 line differences)

public class Arrays_NonOverlappingIntervals {

    /* time complexity : O(Nlog(N)), space complexity : O(N) */

    private static int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> mergedList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        /* each interval's 0th index represents the start time, 1st index represents the end time */
        /* sorting on the starting time of the intervals */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] prevInterval = intervals[0];
        mergedList.add(prevInterval);

        for (int[] currInterval : intervals) {

            if (prevInterval[1] > currInterval[0]) {   /* previous interval's end time is greater than current interval's start time, so overlaps */   /* Change 1 */
                prevInterval[1] = Math.min(prevInterval[1], currInterval[1]);   /* Main difference from Arrays_MergeOverlappingIntervals.java */ /* Change 2 */
            } else {
                mergedList.add(currInterval);
                prevInterval = currInterval;
            }
        }
        return intervals.length - mergedList.size(); /* Change 3 */
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] intervalInput = br.readLine().trim().split("\\s+");

            int[][] intervals = new int[n][2];

            for(int i = 0 ; i < n ; i++) {
                intervals[i][0] = Integer.parseInt(intervalInput[i * 2]);
                intervals[i][1] = Integer.parseInt(intervalInput[(i * 2) + 1]);
            }

            int output = eraseOverlapIntervals(intervals);
            System.out.println(output);
        }
    }
}
