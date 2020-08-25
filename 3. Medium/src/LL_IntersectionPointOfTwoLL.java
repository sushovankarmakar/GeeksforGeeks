import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 25.08.2020
// https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
// https://leetcode.com/problems/intersection-of-two-linked-lists/
// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/165648 (BEST Tutorial)
// https://www.youtube.com/watch?v=IpBfg9d4dmQ (A good video tutorial)

public class LL_IntersectionPointOfTwoLL {

    private static int findTheIntersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) return -1;

        Node currNode1 = head1;
        Node currNode2 = head2;

        while (currNode1 != currNode2) {    /* if currNode1 is end of the list, then set to the head of the longer list */
            if(currNode1 == null) {
                currNode1 = head2;
            }
            else {
                currNode1 = currNode1.next; /* regular traversal */
            }

            if(currNode2 == null) {
                currNode2 = head1;
            }
            else {
                currNode2 = currNode2.next;
            }
        }

        return currNode1 != null ? currNode1.data : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t --> 0) {
            String[] details = br.readLine().trim().split("\\s+");  // l, m, n
            String[] input1 = br.readLine().trim().split("\\s+");
            String[] input2 = br.readLine().trim().split("\\s+");
            String[] input3 = br.readLine().trim().split("\\s+");

            Node head1 = createLinkedList(input1);
            Node tail1 = getTheTailNode(head1);

            Node head2 = createLinkedList(input2);
            Node tail2 = getTheTailNode(head2);

            addToTheTail(input3, tail1);
            addToTheTail(input3, tail2);

            printLinkedList(head1);
            printLinkedList(head2);

            System.out.println(findTheIntersection(head1, head2));
        }
    }

    private static void printLinkedList(Node head) {
        if(head == null) System.out.println("This linked list is empty");

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data).append(" ");
            head = head.next;
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    private static Node getTheTailNode(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private static void addToTheTail(String[] input, Node tail) {
        for (String num : input) {
            tail.next = new Node(Integer.parseInt(num));
            tail = tail.next;
        }
    }

    private static Node createLinkedList(String[] input) {
        Node head = new Node(Integer.parseInt(input[0]));
        Node currNode = head;
        for (int i = 1; i < input.length; i++) {
            currNode.next = new Node(Integer.parseInt(input[i]));
            currNode = currNode.next;
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
