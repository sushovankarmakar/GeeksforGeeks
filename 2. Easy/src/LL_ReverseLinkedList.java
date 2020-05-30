import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/reverse-a-linked-list/
// https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1

class LL_ReverseLinkedList {

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split("\\s+");
            int ip[] = new int[n];
            for (int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            Node head = buildLinkedList(ip);
            printLinkedList(head);

            Node reversedHead = reverseLinkedList(head);
            printLinkedList(reversedHead);
        }
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
