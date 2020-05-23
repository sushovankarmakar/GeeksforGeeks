import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1/
// https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/

public class BST_MinimumElementInBST {
	private static int minValue(Node root) {
	    int minVal = root.data;
	    while(root.left != null) {
	    	minVal = root.left.data;
	    	root = root.left;
	    }
	    return minVal;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			Node root = buildTree(ip);
			System.out.println(minValue(root));
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length()==0 || str.charAt(0)=='N') return null;
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while(queue.isEmpty() && i < ip.length) {
			Node currNode = queue.poll();
			
			String currData = ip[i];
			
			if(!currData.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currData));
				queue.add(currNode.left);
			}
			i++;
			
			if(i >= ip.length) break;
			
			currData = ip[i];
			if(!currData.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currData));
				queue.add(currNode.right);
			}
			i++;
		}
		return root;
	}
	
	private static class Node {
		private int data;
		private Node left;
		private Node right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
