import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DLinkedListDeletion {

	Node head;
	
	static class Node{
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
			String ip[] = br.readLine().trim().split("\\s+");
			int x = Integer.parseInt(br.readLine().trim());
			Node head = null;
			for (int i = 0; i < n; i++) {
				int data = Integer.parseInt(ip[i]);
				head = insert(head, data);
			}
			printDll(head);
			head = delete(head, x);
			printDll(head);
		}
	}
	
	static Node insert(Node head, int data) {
		Node n = new Node(data);  // creation of a new node
		Node temp = head;
		
		if(head==null) {
			head = n;
		}
		else {
			while(temp.next !=null) {
				temp = temp.next;
			}
			temp.next = n;
			n.prev = temp;
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
	
	static Node delete(Node head, int x) {
		Node temp = head;
		
		while( (--x) !=0 ) {
			if (temp.next != null) temp = temp.next;
		}
		if(temp.prev != null) temp.prev.next = temp.next;
		else { // special case only if first node is getting deleted
			
			temp.next.prev = null;
			head = temp.next;
		}
		if(temp.next != null) temp.next.prev = temp.prev;
		temp.prev = temp.next = null;
		
		return head;
	}
}






