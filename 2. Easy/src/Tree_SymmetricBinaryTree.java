import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/symmetric-tree/1
// https://www.youtube.com/watch?v=XV7Sg2hJO3Q
// https://www.youtube.com/results?search_query=symmetric+tree+%28mirror+image+of+itself%29
// https://www.youtube.com/watch?v=9jH2L2Ysxko
// https://www.youtube.com/watch?v=K7LyJTWr2yA

public class Tree_SymmetricBinaryTree {
	
	static boolean isSymmetric(Node root) {
		return (root == null) || checkSymmetric(root.left, root.right);
	}
	
	static boolean checkSymmetric(Node left, Node right) {
		if(left == null && right == null) return true;
		else if(left != null && right != null) {
			return ( (left.data == right.data)  && 
					checkSymmetric(left.left, right.right) && 
					checkSymmetric(left.right, right.left));
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String str = br.readLine().trim();
			Node root = buildTree(str);
			printTree(root);
			System.out.println();
			System.out.println(isSymmetric(root)? "True" : "False");
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0) == 'N') return null;
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i=1;
		while(queue.size() > 0 && i < ip.length) {
			Node currNode = queue.poll();
			
			String currVal = ip[i];
			if(!currVal.equals("N")) {
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
	
	static void printTree(Node root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}
	
	static class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
