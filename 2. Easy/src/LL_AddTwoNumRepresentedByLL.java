import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
// https://www.geeksforgeeks.org/sum-of-two-linked-lists/
// https://leetcode.com/problems/add-two-numbers-ii/submissions/
// https://leetcode.com/problems/add-two-numbers/ (similar problem)
// https://www.youtube.com/watch?v=HzWKOp0C_aU (a video explanation)
// https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack (Similar Approach)

public class LL_AddTwoNumRepresentedByLL {

    private static Node addList(Node head1, Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (head1 != null) {
            stack1.push(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            stack2.push(head2.data);
            head2 = head2.next;
        }

        Node dummyHead = new Node(0);
        Node currNode = dummyHead;
        int sum = 0;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();

            Node newNode = new Node(sum % 10);
            newNode.next = currNode.next;
            currNode.next = newNode;

            carry = sum / 10;
            sum = carry;
        }

        if(carry != 0)  {
            Node newNode = new Node(carry);
            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str1 = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(br.readLine().trim());
            String[] str2 = br.readLine().trim().split("\\s+");
            Node head1 = buildLinkedList(str1);
            Node head2 = buildLinkedList(str2);
            printLinkedList(head1);
            printLinkedList(head2);
            Node resultHead = addList(head1, head2);
            printLinkedList(resultHead);
        }
    }

    private static void printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.data).append(" ");
            head = head.next;
        }
        System.out.println(sb);
        sb.setLength(0);
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
        private final int data;
        private Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
