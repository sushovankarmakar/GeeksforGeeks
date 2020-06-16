import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
// https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
// https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/

public class LL_DeleteSingleLLNodeAtGivenPos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split("\\s+");
            int position = Integer.parseInt(br.readLine().trim());
            int ip[] = new int[n];
            for (int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            Node head = buildLinkedList(ip);
            System.out.println("Before deletion");
            printLinkedList(head);
            Node headAfterDeletion = deleteNodeAtGivenPosition(head, position);
            printLinkedList(headAfterDeletion);
        }
    }

    private static Node deleteNodeAtGivenPosition(Node head, int position) {
        if(head == null) return null;

        // if position is 1, then head has to be deleted.
        if(position == 1) {
            head = head.next;
            return head;
        }

        Node newHead = head;
        Node prev = head;
        Node toBeDeletedNode = head;

        // storing the prev node of to be deleted Node
        while(position > 1 && toBeDeletedNode != null) {
            prev = toBeDeletedNode;
            toBeDeletedNode = toBeDeletedNode.next;
            --position;
        }

        if(toBeDeletedNode != null) prev.next = toBeDeletedNode.next;

        return newHead;
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
