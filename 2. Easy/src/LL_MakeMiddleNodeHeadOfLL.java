import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 24.08.2020
// https://www.geeksforgeeks.org/make-middle-node-head-linked-list/
// https://www.youtube.com/watch?v=h69rNQq7sfs (A good video tutorial)
// https://leetcode.com/problems/middle-of-the-linked-list/ (Similar Question)
// https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1 (Similar Question)

public class LL_MakeMiddleNodeHeadOfLL {

    private static Node getTheMidElement(Node head) {
        if (head == null || head.next == null) return head;     /* if there is only one node, return that */

        Node dummyHead = new Node(-1);
        dummyHead.next = head;

        Node prev = dummyHead;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        /*at end of the above while loop, slow pointer indicates the middle element and prev pointer indicates the
        * previous node of the middle element */

        prev.next = prev.next.next;     /* linking the gap */

        slow.next = head;   /* setting the middle node's next node as head */
        dummyHead.next = slow; /* setting the head node */

        return dummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = buildLinkedList(input);
            printLinkedList(head);
            Node newHead = getTheMidElement(head);
            printLinkedList(newHead);
        }
    }

    private static Node buildLinkedList(String[] input) {
        Node head = new Node(Integer.parseInt(input[0]));
        Node currentNode = head;
        for (int i = 1; i < input.length; i++) {
            currentNode.next = new Node(Integer.parseInt(input[i]));
            currentNode = currentNode.next;
        }
        return head;
    }

    private static void printLinkedList(Node head) {
        if(head == null) System.out.println("This linked list is empty");

        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode.data).append(" ");
            currentNode = currentNode.next;
        }
        System.out.println(sb);
        sb.setLength(0);
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
