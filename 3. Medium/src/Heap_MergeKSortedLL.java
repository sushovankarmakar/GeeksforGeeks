import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
// https://www.youtube.com/watch?v=ptYUCjfNhJY&t=326s (Best video explanation)
// https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/MergeKSortedLinkedLists/MergeKSortedLinkedLists.java
// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1 (Similar question)
// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/

public class Heap_MergeKSortedLL {

    private static Node mergeKLinkedList(Node[] nodes, int n) {

        /*
        Use the built-in PriorityQueue library, pass a Comparator to make poll() return the smallest item
        instead of the largest item (default is the largest/highest) priority item.
        A "Comparator" just tells the structure how to compare individual items to keep the queue sorted
        */

        Queue<Node> minHeap = new PriorityQueue<>(
                (node1, node2) -> Integer.compare(node1.data, node2.data)
        );

        /*
        Add the head of each linked list to the Priority Queue,
        the queue will move the node with the smallest value to the front.
        */

        for (Node node : nodes) {
            minHeap.offer(node);
        }

        Node mergedListDummyHead = new Node(0);
        Node mergedListTail = mergedListDummyHead;

        // Process each node in the queue while there are nodes to process across all k lists
        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();

            mergedListTail.next = smallestNode;     // Append the node to the final list

            mergedListTail = mergedListTail.next;   // Advance the tail pointer

            /*
            Add the node that is after the node we just appended...to the priority queue
            for consideration (if it is not null)
            */

            if(mergedListTail.next != null) minHeap.offer(mergedListTail.next);
        }

        return mergedListDummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(br.readLine().trim());
                String[] str = br.readLine().trim().split("\\s+");
                Node head = buildLinkedList(str);
                nodes[i] = head;
            }
            Node mergedLinkedListHead = mergeKLinkedList(nodes, n);
            printLinkedList(mergedLinkedListHead);
        }
    }

    private static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data).append(" ");
            head = head.next;
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    private static Node buildLinkedList(String[] str) {
        Node head = new Node(Integer.parseInt(str[0]));
        Node currNode = head;
        for (int i = 1; i < str.length; i++) {
            currNode.next = new Node(Integer.parseInt(str[i]));
            currNode = currNode.next;
        }
        return head;
    }

    private static class Node {
        private int data;
        private Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
