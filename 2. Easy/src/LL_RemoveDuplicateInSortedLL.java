import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
// https://www.youtube.com/watch?v=wIB5sg_Ulx4 (A Good Video explanation)
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/solution/
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ (Similar Question)

public class LL_RemoveDuplicateInSortedLL {

    /*
    * Given a sorted linked list, delete all duplicates such that each element appear only once
    * */

    private static Node removeDuplicate(Node head) {
        if (head == null) return new Node(-1);

        Node currNode = head;

        while (currNode != null && currNode.next != null) {
            if (currNode.data == currNode.next.data) {
                Node temp = currNode.next;
                currNode.next = currNode.next.next;
                temp = null;
            }
            else {
                currNode = currNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int numOfNodes = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");

            Node head = buildLinkedList(input);
            printLinkedList(head);

            Node newHead = removeDuplicate(head);
            printLinkedList(newHead);
        }
    }

    private static void printLinkedList(Node head) {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode.data).append(" ");
            currentNode = currentNode.next;
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    private static Node buildLinkedList(String[] input) {
        Node head = new Node(Integer.parseInt(input[0]));
        Node currentNode = head;
        for (int i = 1; i < input.length; i++) {
            currentNode.next = new Node(Integer.parseInt(input[i]));
            currentNode = currentNode.next;
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
