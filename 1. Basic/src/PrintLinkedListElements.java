class PrintLinkedListElements {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		Node(int d) { // constructor
			data = d; 
			next = null;
		}
	}
	
	public static void main(String[] args) {
		PrintLinkedListElements printll = new PrintLinkedListElements();
		printll.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		printll.head.next = second;
		second.next = third;
		
		// print the linked list
		printllist(printll.head);
	}
	
	public static void printllist(Node head) {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		while(temp !=null) {
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(sb);
		sb.setLength(0);
	}
}
