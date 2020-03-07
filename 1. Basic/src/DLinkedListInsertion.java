import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class DLinkedListInsertion {

	Node head;
	
	static class Node {
		int data;
		Node prev,next;
		Node(int d){
			data = d;
			prev = null;
			next = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			int p = Integer.parseInt(s2[0]), x = Integer.parseInt(s2[1]);
			
			DLinkedListInsertion dll = new DLinkedListInsertion();
			dll.head = null;
			
			for (int i = 0; i < n; i++) {
				int data = Integer.parseInt(s1[i]);
				dll.head = insertAtEnd(dll.head, data);
			}
			
			printDll(dll.head);
			dll.head = addNode(dll.head,p,x);
			printDll(dll.head);
		}
	}
	
	static Node insertAtEnd(Node head, int data) {
		Node n = new Node(data);
		if(head==null) {
			head = n;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
			n.prev = temp;
			n.next = null;
		}
		return head;
	}
	
	static void printDll(Node head) {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		while(temp != null) {
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(sb);
		sb.setLength(0);
	}
	
	static Node addNode(Node head, int pos, int data) {
		Node n = new Node(data); // creating a new node
		
		Node temp = head;
		while( (pos--) != 0) {
			if(temp.next!= null) temp = temp.next;
		}
		
		n.next = temp.next;
		n.prev = temp;
		temp.next = n;
		if(temp.next.prev != null ) temp.next.prev = n;
		
		return head;
	}
	
	// below code I submitted in GFG
	
	/*void addNode(Node head, int pos, int data)
	{
		Node n = new Node(); // creating a new node
		n.data = data;
		n.prev = n.next = null;
		
		Node temp = head;
		while( (pos--) != 0 ) {
			if(temp.next!= null) temp = temp.next;
		}
		n.next = temp.next;
		n.prev = temp;
		temp.next = n;
		
		// as we not traversing back, so below line is not required specially for this solution, but in general cases, it is required.
		//if(temp.next.prev != null ) temp.next.prev = n;   
	}*/
}
