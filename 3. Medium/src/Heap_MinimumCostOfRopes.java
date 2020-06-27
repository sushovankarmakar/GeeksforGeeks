import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes/0
// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
// https://www.youtube.com/results?search_query=Find+a+way+to+connect+N+ropes+with+minimum+cost
// https://leetcode.com/discuss/interview-question/344677/Amazon-or-Online-Assessment-2019-or-Min-Cost-to-Connect-Ropes

public class Heap_MinimumCostOfRopes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            long[] ip = new long[n];
            for(int i = 0; i < n; ++i) {
                ip[i] = Long.parseLong(str[i]);
            }
            System.out.println(getMinCostOfRopes(ip));
        }
    }

    private static long getMinCostOfRopes(long[] ip) {
        Queue<Long> queue = new PriorityQueue<>();

        for(long val : ip) {
            queue.offer(val);
        }

        // logic is we need to always add the smallest and 2nd smallest element in the stream.

        long totalCost = 0;
        while(queue.size() >= 2) {
            long min1 = queue.poll();
            long min2 = queue.poll();

            long cost = (min1 + min2);
            totalCost += cost;

            queue.offer(cost);
        }
        return totalCost;
    }
}
