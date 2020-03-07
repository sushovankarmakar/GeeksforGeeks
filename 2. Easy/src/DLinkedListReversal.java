import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/

class DLinkedListReversal {

	Node head;
	
	static class Node {
		int data;
		Node prev, next;
		Node(int d){
			data = d;
			prev = next = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			
			Node head = null;
			for (int i = 0; i < n; i++) {
				int d = Integer.parseInt(s[i]);
				head = insertEnd(head, d);
			}
			printDll(head);
			head = reverseDll(head);
			printDll(head);
		}
	}
	
	public static Node insertEnd(Node head, int d) {
		Node n = new Node(d); // creating a node
		Node temp = head;
		if(head == null) {
			head = n;
		}
		else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
			n.prev = temp;
		}
		return head;
	}
	
	public static void printDll(Node head) {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		while(temp != null) {
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(sb);
		sb.setLength(0);
	}
	
	public static Node reverseDll(Node head) {
		Node temp = head;
		while(temp != null) {
			
			// swapping temp.prev and temp.next
			Node temp1 = temp.next;
			temp.next = temp.prev;
			temp.prev = temp1;
			
			head = temp;
			temp = temp.prev;
		}
		return head;
	}
}
























