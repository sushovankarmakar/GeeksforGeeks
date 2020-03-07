import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// wrong Implementation

class ImplementStackUsingLL {
	
	StackNode head;
	static class StackNode {
		
		int data;
		StackNode next;
		StackNode(int data){
			this.data = data;
			next = null;
		}
	}
	
	static StackNode push(StackNode head, int data) {  
		StackNode n = new StackNode(data);
		
		if(head==null) {
			head = n;
		}
		else {
			n.next = head;
			head = n;
		}
		return head;
	}
	
	static int pop(StackNode head) {
		int poppedVal = 0;
		if(head==null)	return -1;
		else {
			poppedVal = head.data;
			head = head.next;
		}
		return poppedVal;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			
			ImplementStackUsingLL ll = new ImplementStackUsingLL();
			ll.head = null;
			
			for (int i = 0; i < n;) {
				int queryType = Integer.parseInt(ip[i]);
				
				if(queryType==1) {
					int val = Integer.parseInt(ip[++i]);
					 ll.head = push(ll.head, val);
				}
				else {
					int popped = pop(ll.head);
					System.out.println(popped+" ");
					++i;
				}
			}
		}
	}
}
