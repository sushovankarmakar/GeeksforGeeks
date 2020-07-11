import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11.07.2020
// https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1/
// below are three very good video tutorials.
// https://www.youtube.com/watch?v=3thY0z3Pf5k
// https://www.youtube.com/watch?v=bOGh_3MTrdE
// https://www.youtube.com/watch?v=wk4QsvwQwdQ

public class LL_LinkedListIsPalindrome {

    private static boolean isLinkedListPalindrome(Node head) {
        if(head == null) return true;
        Node midNode = getMidNode(head);
        System.out.println(midNode.data);

        Node firstHalfHeadNode = head;
        Node secondHalfHeadNode = reverseLinkedList(midNode.next);

        while (secondHalfHeadNode != null) {
            if(firstHalfHeadNode.data != secondHalfHeadNode.data) {
                return false;
            }
            firstHalfHeadNode = firstHalfHeadNode.next;
            secondHalfHeadNode = secondHalfHeadNode.next;
        }
        return true;
    }

    private static Node reverseLinkedList(Node head) {
        if(head == null) return null;

        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node getMidNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split("\\s+");
            Node head = buildLinkedList(str);
            System.out.println(isLinkedListPalindrome(head) ? 1 : 0);
        }
    }

    private static Node buildLinkedList(String[] str) {
        Node head = new Node(Integer.parseInt(str[0]));
        Node currNode = head;
        for (int i = 1; i < str.length; i++) {
            currNode.next = new Node(Integer.parseInt(str[i]));
            currNode = currNode.next;
        }
        return head;
    }

    static class Node {
        private int data;
        private Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
