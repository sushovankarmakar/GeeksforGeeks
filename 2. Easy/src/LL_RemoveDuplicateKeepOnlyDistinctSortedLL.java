import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code (A good tutorial)
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/ (Similar Question)

public class LL_RemoveDuplicateKeepOnlyDistinctSortedLL {

    private static Node keepOnlyDistinctElements(Node head) {
        if(head == null) return null;

        Node dummyHead = new Node(-1);
        dummyHead.next = head;

        Node prevNode = dummyHead;
        Node currNode = head;

        while(currNode != null) {

            while(currNode.next != null && currNode.data == currNode.next.data) {  /* if duplicate found, we go forward */
                currNode = currNode.next;
            }

            /* below if-else if very important to understand
            * input : 1 2 3 3 4 4 5
            * output : 1 2 5
            * take above example and dry run it */

            if(prevNode.next != currNode) {
                /* it means we've duplicates between them, but don't update prevNode directly,
                 * cause there may be more than one two duplicate values like 1 2 3 3 4 4 5 */

                prevNode.next = currNode.next;
            }
            else {
                prevNode = currNode;
            }

            currNode = currNode.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = buildLinkedList(input);
            printLinkedList(head);

            Node newHead = keepOnlyDistinctElements(head);
            printLinkedList(newHead);
        }
    }

    private static void printLinkedList(Node head) {
        if(head == null) System.out.println("No nodes in Linked List");

        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while(currentNode != null) {
            sb.append(currentNode.data).append(" ");
            currentNode = currentNode.next;
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    private static Node buildLinkedList(String[] input) {
        Node head = new Node(Integer.parseInt(input[0]));
        Node currentNode = head;
        for(int i = 1; i < input.length; i++) {
            currentNode.next = new Node(Integer.parseInt(input[i]));
            currentNode = currentNode.next;
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
