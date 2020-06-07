import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
// https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
// https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
// https://www.youtube.com/watch?v=acJEBQiFPoY

public class LL_ReverseLinkedListGroupsOfSizeK {

    public static Node reverse(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count++;
        }

        if(next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split("\\s+");
            int k = Integer.parseInt(br.readLine().trim());
            int ip[] = new int[n];
            for (int i = 0; i < n; i++) {
                ip[i] = Integer.parseInt(str[i]);
            }
            Node head = buildLinkedList(ip);
            System.out.println("After reversal");
            printLinkedList(head);
            Node reversedHead = reverse(head, k);
            System.out.println("Before reversal");
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
