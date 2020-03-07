import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LinkedListInsertion {

	Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			
			LinkedListInsertion ll = new LinkedListInsertion();
			ll.head = null;
			for (int i = 0; i < n*2 ; i +=2) {
				int val = Integer.parseInt(s[i]);
				Node newHead = null;
				if( (i+1)== 0) {
					newHead = insertAtBeginning(ll.head,val);
				}
				else {
					newHead = insertAtEnd(ll.head, val);
				}
				printll(newHead);
			}
		}
	}
	
	public static Node insertAtBeginning(Node head, int val) {
		Node n = new Node(val);  //creating a new node 
		n.data = val;
		n.next = null;
		
		if(head==null) {
			head = n;
		}
		else {
			n.next = head;
			head = n;
		}
		return head;
	}
	
	public static Node insertAtEnd(Node head, int val) {
		Node n = new Node(val);
		n.data = val;
		n.next = null;
		
		if(head==null) {
			head = n;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = n; 
		}
		return head;
	}
	
	public static void printll(Node head) {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		while(temp != null) {
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(sb);
		sb.setLength(0);
	}
}
