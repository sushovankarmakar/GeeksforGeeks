import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/check-for-bst/1
// https://www.youtube.com/watch?v=MILxfAbIhrE
// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

public class BST_CheckForBST {
	
	private static boolean isBST(Node root, int lowerLimit, int upperLimit) {
		if(root == null) return true;
		if((lowerLimit < root.data) && (root.data < upperLimit)) {
			if(isBST(root.left, lowerLimit, root.data) && isBST(root.right, root.data, upperLimit)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip = br.readLine().trim();
			Node root = buildTree(ip);
			System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)? "1" : "0");
		}
	}



	private static Node buildTree(String str) {
		if(str.length()==0 || str.charAt(0)=='N') {
			return null;
		}
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		int i = 1;
		while(queue.size() > 0 && i < ip.length) {
			Node currNode = queue.peek();
			queue.remove();

			String currVal = ip[i];

			if (!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
			}

			i++;
			if(i >= ip.length) break;

			currVal = ip[i];

			if(!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
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
			this.left = this.right = null;
		}
	}
}
