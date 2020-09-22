import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
// https://www.youtube.com/watch?v=OvpKeraoxW0 (Best Video Tutorial)
// https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/CloneLinkedListWithRandomPointers/ConstantSpace.java
// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
INPUT:
-----
2
4 2
1 2 3 4
1 2 2 4
4 2
1 3 5 9
1 1 3 4

OUTPUT:
------
1
1
*/

public class LL_CloneLLWithNextAndRandomPtr {

    private static Node copyList(Node head) {

        /* FIRST PASS : Clone each node and link each original node to it's copy via the original node's next pointer */
        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.data);   /* Create the copy node. */
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;  // moving the current pointer forward
        }

        /* SECOND PASS : Assign clone the random mapping
        * we'll use each original node's next value to map to the clone allowing us to reach the clone list. */

        curr = head;    // Reset curr to the head of the original list.
        while (curr != null && curr.next != null) {

            if(curr.arb != null) {  // some node's arbitrary pointer may be null
                curr.next.arb = curr.arb.next;
            }
            curr = curr.next.next; // moving the current pointer forward
        }

        /* THIRD PASS : Our goal is to restore the original list, and extract the copy list. */
        curr = head;    // First reset curr to the head of the original list.
        Node dummyHead = new Node(-1);
        Node cloneCurr = dummyHead;

        while (curr != null) {
            cloneCurr.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;           // moving the current pointer forward
            cloneCurr = cloneCurr.next; // moving the current clone pointer forward
        }
        return dummyHead.next;
    }

    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            Node generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                Node tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                Node tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            Node res = copyList(head);

            Node cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(Node head, Node res, Node cloned_add, Node generated_add) {

        if (generated_add == cloned_add) return false;

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
            else if(temp1.arb== null && temp2.arb !=null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    private static class Node {
        int data;
        Node next;
        Node arb;

        Node(int d) {
            data = d;
            next = arb = null;
        }
    }
}
