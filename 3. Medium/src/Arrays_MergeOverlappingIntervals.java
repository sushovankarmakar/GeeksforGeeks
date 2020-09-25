import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/overlapping-intervals/0
// https://leetcode.com/problems/merge-intervals/
// https://leetcode.com/problems/merge-intervals/solution/
// https://www.youtube.com/watch?v=bom4wItgkt0
// https://www.youtube.com/watch?v=2JzRBPFYbKE&ab_channel=takeUforward (A GOOD VIDEO Explanation)
// https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution (BEST post)

// https://leetcode.com/problems/non-overlapping-intervals/ (Very Similar problem, Arrays_NonOverlappingIntervals.java, only 3 line changes)
// https://www.lintcode.com/problem/meeting-rooms-ii/description (Very Similar problem)

public class Arrays_MergeOverlappingIntervals {

    /* time complexity : O(Nlog(N)), space complexity : O(N) */

    private static int[][] mergeAllOverlappingIntervals(int[][] intervals) {
        List<int[]> mergedList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return mergedList.toArray(new int[0][]);
        }

        /* each interval's 0th index represents the start time, 1st index represents the end time */
        /* sorting on the starting time of the intervals */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] prevInterval = intervals[0];
        mergedList.add(prevInterval);

        for (int[] currInterval : intervals) {

            /*if previous interval's endTime greater than current interval's startTime,
            then there is a overlap, update the previous interval's endTime*/

            if(prevInterval[1] >= currInterval[0]) {    /* previous interval's end time is greater than or equals to current interval's start time, so overlaps */
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);   /* Main difference from Arrays_NonOverlappingIntervals.java */
            }
            else {
                /* no overlapping here,
                add the current interval to the list and
                make the current interval as previous interval
                which will be used in the next round */

                mergedList.add(currInterval);
                prevInterval = currInterval;
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
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

            int[][] results = mergeAllOverlappingIntervals(intervals);

            StringBuilder sb = new StringBuilder();
            for (int[] result : results) {
                sb.append(result[0]).append(" ").append(result[1]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
