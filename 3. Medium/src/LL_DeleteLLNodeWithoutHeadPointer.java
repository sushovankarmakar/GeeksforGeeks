import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// https://leetcode.com/problems/delete-node-in-a-linked-list/
// https://www.youtube.com/watch?v=bJPmNKMtjdk
// https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

public class LL_DeleteLLNodeWithoutHeadPointer {

    private static void deleteNodeWithoutHead(Node node) {
        Node temp = node.next;  // later this temp value will be null

        // we didn't delete the given node actually.
        // we copied the next node to this node and deleted the next node.

        node.value = node.next.value;
        node.next = node.next.next;

        temp = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split("\\s+");
            int valueToBeDeleted = Integer.parseInt(br.readLine().trim());
            int ip[] = new int[n];
            for (int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            Node head = buildLinkedList(ip);
            System.out.println("Before deletion");
            printLinkedList(head);
            Node nodeToBeDeleted = searchNode(head, valueToBeDeleted);
            deleteNodeWithoutHead(nodeToBeDeleted);
            System.out.println("After deletion");
            printLinkedList(head);
        }
    }

    private static Node searchNode(Node head, int valueToBeDeleted) {
        Node currentNode = head;

        while (currentNode != null && currentNode.value != valueToBeDeleted) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private static Node buildLinkedList(int[] ip) {
        Node head = new Node(ip[0]);
        Node tail = head;
        for (int i = 1; i < ip.length; i++) {
            tail.next = new Node(ip[i]);
            tail = tail.next;
        }
        return head;
    }

    private static void printLinkedList(Node head) {
        StringBuffer sb = new StringBuffer();

        Node temp = head;

        while(temp != null) {
            sb.append(temp.value + " ");
            temp = temp.next;
        }

        System.out.println(sb);
        sb.setLength(0);
    }

    private static final class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
