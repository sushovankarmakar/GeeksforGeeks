import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/print-linked-list-elements/1
// https://www.geeksforgeeks.org/linked-list-set-1-introduction/

public class LL_PrintLinkedList {

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
