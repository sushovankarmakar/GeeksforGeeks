import java.util.*;

// https://www.youtube.com/watch?v=24li7yc91us&feature=emb_logo (Best explanation) (APPROACH -1)
// https://www.youtube.com/watch?v=RBlcUlUkDCU (Best explanation) (APPROACH - 2)
// https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/

// https://www.lintcode.com/problem/meeting-rooms-ii/description
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/ (Similar problem)

public class Heap_MeetingRoom {

    // APPROACH -1
    /*
    minimum number or meeting rooms required  == maximum number of concurrent meetings at all the time
    so whatever maximum number of concurrent meetings we have at one time,
    we need at least that number of meetings rooms to accommodate all the meetings
    */

    private static int findNumRooms(int[][] intervals) {  // overall time complexity : O(n*log(n)), space complexity : O(n)
        int[] startingTime = new int[intervals.length];
        int[] endingTime = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            startingTime[i] = intervals[i][0];
            endingTime[i] = intervals[i][1];
        }

        Arrays.sort(startingTime);  // sort the all starting time   // O(n*log(n))
        Arrays.sort(endingTime);    // sort the all ending time

        int maxConcurrentMeetings = Integer.MIN_VALUE;
        int currNumOfConcurrentMeetings = 0;

        /*traverse through both startingTime array and endingTime array and
        1.if a startingTime is smaller than a endingTime, then collision happens,
            so increase the currNumOfConcurrentMeetings and try next startingTime
        2.if a startingTime is smaller than a endingTime,
           so decrease the currNumOfConcurrentMeetings and try next endingTime*/

        for (int i = 0, j = 0; i < startingTime.length && j < startingTime.length; ) {
            if(startingTime[i] < endingTime[j]) {
                currNumOfConcurrentMeetings += 1;
                i++;
            }
            else {
                currNumOfConcurrentMeetings -= 1;
                j++;
            }
            maxConcurrentMeetings = Math.max(maxConcurrentMeetings, currNumOfConcurrentMeetings);   // keep track of max value
        }
        return maxConcurrentMeetings;
    }

    // APPROACH - 2
    private static int findNumRoomsUsingHeap(int[][] intervals) {  // overall time complexity : O(n*log(n)), space complexity : O(n)
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));   // sorting on the basis of arrival time
        Queue<Integer> priorityQueue = new PriorityQueue<>();   // this priority queue (min heap) works as the number of rooms and stores only ending time

        for (int[] interval : intervals) {
            int startingTime = interval[0];
            int endingTime = interval[1];

            /*if startingTime is greater than the min ending time present in the min heap
            then, we can say this meeting is over, remove this from min heap*/

            if(!priorityQueue.isEmpty() && priorityQueue.peek() <= startingTime) {
                priorityQueue.poll();
            }
            priorityQueue.offer(endingTime);    // put endingTime of each meetings
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] meetings = new int[n][2];

        for(int i = 0 ; i < n ; i++) {
            meetings[i][0] = scanner.nextInt();
            meetings[i][1] = scanner.nextInt();
        }

        //int result = findNumRooms(meetings);
        int result = findNumRoomsUsingHeap(meetings);
        System.out.printf("%d", result);
    }
}
