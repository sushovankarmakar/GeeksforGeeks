import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Floyd's algorithm for cycle detection.
// https://www.youtube.com/watch?v=_BG9rjkAXj8&feature=emb_logo (Best Video Explanation)
// https://www.youtube.com/watch?v=-YiQZi3mLq0 (Best Video Explanation)
// https://www.youtube.com/watch?v=apIw0Opq5nk (Good Proof of the Algo)
// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1/
// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
// https://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work

public class LL_RemoveCycleLoopInLinkedList {

    private static int detectLoop(Node head) {
        Node slowPointer = head, fastPointer = head;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                removeLoop(slowPointer, head);
                return 1;
            }
        }
        return 0;
    }
    private static void removeLoop(Node slowPointer, Node head) {
        Node pointer1 = head;
        Node pointer2 = slowPointer;

        while(pointer1.next != pointer2.next) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer2.next = null;
    }

    // with extra space.
    /*public static void removeLoop(Node head){
        Set<Node> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head.next)) {
                head.next = null;
                return;
            }
            set.add(head);
            head = head.next;
        }
        return;
    }*/

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
            printLinkedList(head);
        }
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

    private static Node buildLinkedList(int[] ip) {
        Node head = new Node(ip[0]);
        Node tail = head;
        for (int i = 1; i < ip.length; i++) {
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

        if(tail != null) {
            tail.next = loopStartingNode;
        }
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
