import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
// https://www.youtube.com/watch?v=VmogG01IjYc (best video explanation)
// https://www.youtube.com/watch?v=1CxyVdA_654
// https://stackoverflow.com/questions/10657503/find-running-median-from-a-stream-of-integers
// https://leetcode.com/problems/find-median-from-data-stream/

public class Heap_FindMedianInStream {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> ip = new ArrayList<>();
        while(n-->0) {
            int num = Integer.parseInt(br.readLine().trim());
            ip.add(num);
        }
        List<Integer> medians = findMedians(ip);
        print(medians);
    }

    private static void print(List<Integer> medians) {
        for(int num : medians) {
            System.out.println(num);
        }
    }

    private static List<Integer> findMedians(List<Integer> ip) {
        List<Integer> result = new ArrayList<>();
        if(ip == null) return result;

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int num : ip) {
            addToHeap(maxHeap, minHeap, num);

            balanceHeap(maxHeap, minHeap);

            result.add(findMedian(maxHeap, minHeap));
        }
        return result;
    }

    private static void addToHeap(Queue<Integer> maxHeap, Queue<Integer> minHeap, int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
    }

    private static void balanceHeap(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static int findMedian(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        else {
            return maxHeap.peek();
        }
    }
}
