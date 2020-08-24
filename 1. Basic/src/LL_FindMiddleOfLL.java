import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 24.08.2020
// https://leetcode.com/problems/middle-of-the-linked-list/
// https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
// https://www.geeksforgeeks.org/make-middle-node-head-linked-list/ (Similar Question)
// https://www.youtube.com/watch?v=h69rNQq7sfs (A good video tutorial)

public class LL_FindMiddleOfLL {

    private static Node getTheMidElement(Node head) {
        if (head == null || head.next == null) return head; /* if there is only one node, return that */

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;    /* this point slow pointer points to the mid element of the linked list */
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = buildLinkedList(input);
            printLinkedList(head);
            Node mid = getTheMidElement(head);
            System.out.println(mid.data);
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
