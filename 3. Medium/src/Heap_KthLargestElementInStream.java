import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// https://www.youtube.com/results?search_query=kth+largest+element+in+a+stream

public class Heap_KthLargestElementInStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            String[] kn = br.readLine().trim().split("\\s+");
            int k = Integer.parseInt(kn[0]);
            int n = Integer.parseInt(kn[1]);
            String[] str = br.readLine().trim().split("\\s+");
            int[] ip = new int[n];
            for(int i = 0; i < n; ++i) {
                ip[i] = Integer.parseInt(str[i]);
            }
            List<Integer> output = findKthLargestElementInStream(ip, k);
            printOutput(output);
        }
    }

    private static List<Integer> findKthLargestElementInStream(int[] ip, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int num : ip) {
            if(minHeap.size() < k) {
                minHeap.offer(num);
            }
            else {
                // if heap size is greater than k, then add it the heap if the
                // upcoming value is greater than the top of heap.

                if(minHeap.peek() < num) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
            result.add(minHeap.size() < k ? -1 : minHeap.peek());
        }
        return result;
    }

    private static void printOutput(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for(int num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
