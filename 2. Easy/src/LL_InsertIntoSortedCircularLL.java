import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1
// https://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/ (A good article)
// https://www.youtube.com/watch?v=Gk64fs31T6Q

/*
* Sample Input:
* 7
* 4 5 9 10 0 1 2
* 7
*
* Sample Output
* 4 5 7 9 10 0 1 2
* */

public class LL_InsertIntoSortedCircularLL {

    /* There three cases we need to consider.
    * 1) Linked List is empty
    * 2) New node is to be inserted just before the head node
    * 3) New node is to be  inserted somewhere after the head
    * */

    private static Node insertIntoSortedCircularLL(Node head, int valueToBeAdded) {
        if (head == null) {  /* if head is already null */  /* 1) Linked List is empty */
            head = new Node(valueToBeAdded);
            head.next = head;

        } else if (valueToBeAdded <= head.data) {  /* 2) New node is to be inserted just before the head node */

            /* special case : if valueToBeAdded becomes head */
            Node nodeToBeAdded = new Node(valueToBeAdded);  /* creating nodeToBeAdded */
            nodeToBeAdded.next = head;

            Node tail = head;
            while(tail.next != head) {  /* traversing to the tail */
                tail = tail.next;
            }

            tail.next = nodeToBeAdded;  /* building the link */
            head = nodeToBeAdded;   /* new head */

        } else {    /* 3) New node is to be  inserted somewhere after the head */
            Node currentNode = head;

            /* traverse up to that node whose value is just less than the valueToBeAdded */
            while ( currentNode.next != null &&
                    currentNode.next.data < valueToBeAdded &&
                    currentNode.next != head ) {
                currentNode = currentNode.next;
            }

            Node nodeToBeAdded = new Node(valueToBeAdded);  /* creating nodeToBeAdded */
            nodeToBeAdded.next = currentNode.next;

            currentNode.next = nodeToBeAdded;   /* building the link */
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int numOfNodes = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            int valueToBeAdded = Integer.parseInt(br.readLine().trim());

            Node head = buildTheCircularLinkedList(input);  /* before adding the value */
            printTheLinkedList(head, numOfNodes);

            Node newHead = insertIntoSortedCircularLL(head, valueToBeAdded); /* after adding the value */
            printTheLinkedList(newHead, numOfNodes + 1);
        }
    }

    private static void printTheLinkedList(Node head, int numOfNodes) {
        StringBuilder sb = new StringBuilder();
        while (numOfNodes -- > 0) {
            sb.append(head.data).append(" ");
            head = head.next;
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    private static Node buildTheCircularLinkedList(String[] input) {
        Node head = new Node(Integer.parseInt(input[0]));
        Node currentNode = head;
        for (int i = 1; i < input.length; i++) {
            currentNode.next = new Node(Integer.parseInt(input[i]));
            currentNode = currentNode.next;
        }
        currentNode.next = head;

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
