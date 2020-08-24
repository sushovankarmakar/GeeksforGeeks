import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
// https://www.youtube.com/watch?v=Kka8VgyFZfc (BEST VIDEO EXPLANATION)
// https://www.youtube.com/watch?v=5BpQ5m0K_t4 (Small and concise Video explanation)
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// https://ide.geeksforgeeks.org/zj0sp3otqZ (A good solution)

public class LL_RemoveNthNodeFromEndOfLL {

    /* two pointer algo is used instead of calculating length first */
    /* time complexity : O(N), space complexity : O(1) */
    private static Node removeNthNodeFromEndOfList(Node head, int n) {
        if (head == null) return null;

        Node dummyHead = new Node(-1);
        dummyHead.next = head;

        Node slow = dummyHead;
        Node fast = dummyHead;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
            if(fast == null) return dummyHead.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node nodeToBeDeleted = slow.next;
        slow.next = slow.next.next;
        nodeToBeDeleted = null;     /*deleting the nth node*/

        return dummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int numOfNodes = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(br.readLine().trim());
            Node head = buildLinkedList(input);
            printLinkedList(head);
            Node newHead = removeNthNodeFromEndOfList(head, n);
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
