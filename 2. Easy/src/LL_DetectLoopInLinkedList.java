import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1/
// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

public class LL_DetectLoopInLinkedList {

    private static int detectLoop(Node head) {
        Node slowPointer = head, fastPointer = head;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(br.readLine().trim());
            int[] ip = new int[n];
            for (int i = 0; i < n; ++i) {
                ip[i] = Integer.parseInt(str[i]);
            }
            Node head = buildLinkedList(ip);
            if(0 < x ) createLoop(head, x);
            System.out.println(detectLoop(head) == 1 ? "True" : "False");
        }
    }

    private static Node buildLinkedList(int[] ip) {
        Node head = new Node(ip[0]);
        Node tail = head;
        for (int i = 0; i < ip.length; i++) {
            tail.next = new Node(ip[i]);
            tail = tail.next;
        }
        return head;
    }

    private static void createLoop(Node head, int x) {
        Node tail = head;
        Node loopStartingNode = null;
        int i = 1;
        while (head != null) {

            if(i == x) {
                loopStartingNode = head;
            }
            tail = head;
            head = head.next;
            i++;
        }
        tail.next = loopStartingNode;
        return;
    }

    static class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
