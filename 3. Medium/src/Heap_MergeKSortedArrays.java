import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
// https://www.youtube.com/watch?v=6bvnZzwiKzs (best video explanation)
// https://www.byte-by-byte.com/mergekarrays/
// https://www.youtube.com/watch?v=ptYUCjfNhJY (a good explanation)
// https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/MergeKSortedArrays/MergeKSortedArrays.java
// https://www.geeksforgeeks.org/merge-k-sorted-arrays/

public class Heap_MergeKSortedArrays {

    private static List<Integer> mergeKArrays(int[][] ip, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<QueueNode> minHeap = getModifiedMinHeap();

        for (int i = 0; i < ip.length; i++) {   // first we store the first elements of each array
            minHeap.offer(new QueueNode(i, 0, ip[i][0]));
        }

        while(!minHeap.isEmpty()) {
            QueueNode node = minHeap.poll();
            result.add(node.value);

            int newIndex = node.index + 1;

            if(newIndex < ip[node.arrayId].length) {
                minHeap.add(new QueueNode(node.arrayId, newIndex, ip[node.arrayId][newIndex]));
            }
        }

        return result;
    }

    private static class QueueNode {
        // we need to store the arrayId and index.
        // so when a value is removed from minHeap we can store a value from that arrayId and that index

        private int arrayId;
        private int index;
        private int value;

        public QueueNode(int arrayId, int index, int value) {
            this.arrayId = arrayId;
            this.index = index;
            this.value = value;
        }
    }

    private static Queue<QueueNode> getModifiedMinHeap() {
        Queue<QueueNode> minHeap = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.value, o2.value)
        );

        // upper inside lambda expression can be replaced by below two codes as well.
        //1.
        /*new Comparator<ArrayEntry> () {
                    @Override
                    public int compare(ArrayEntry o1, ArrayEntry o2) {
                        return Integer.compare(o1.value, o2.value);
                    }
                }*/
        // 2.
        // Comparator.comparingInt(o -> o.value)

        return minHeap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            int  k = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int[][] ip = new int[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    ip[i][j] = Integer.parseInt(str[i*k + j]);
                }
            }

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    System.out.print(ip[i][j] + " ");
                }
                System.out.println();
            }

            List<Integer> op = mergeKArrays(ip, k);
            System.out.println(op);
        }
    }
}
