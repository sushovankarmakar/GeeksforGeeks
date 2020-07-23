import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/overlapping-intervals/0
// https://leetcode.com/problems/merge-intervals/solution/
// https://www.youtube.com/watch?v=bom4wItgkt0

// https://www.lintcode.com/problem/meeting-rooms-ii/description (Very Similar problem)

public class Arrays_MergeOverlappingIntervals {

    private static int[][] mergeAllOverlappingIntervals(int[][] intervals) {

        // sorting on the starting time of the intervals
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> mergedList = new ArrayList<>();

        int[] prevInterval = intervals[0];
        mergedList.add(prevInterval);

        for (int[] currInterval : intervals) {

            /*if previous interval's endTime greater than current interval's startTime,
            then there is a overlap, update the previous interval's endTime*/

            if(currInterval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            }
            else {
                /*no overlapping here, just make make the current interval as previous interval
                and add the previous interval*/

                prevInterval = currInterval;
                mergedList.add(prevInterval);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] intervalInput = br.readLine().trim().split("\\s+");

            int[][] intervals = new int[n][2];

            for(int i = 0 ; i < n ; i++) {
                intervals[i][0] = Integer.parseInt(intervalInput[i*2]);
                intervals[i][1] = Integer.parseInt(intervalInput[(i*2)+1]);
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
