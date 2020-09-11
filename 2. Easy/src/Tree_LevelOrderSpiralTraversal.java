import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1/
// https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/

public class Tree_LevelOrderSpiralTraversal {
	
	static class Tree {
		void levelOrderSpiralTraversal(Node root) {
			if (root == null) return;
			Queue<Node> queue = new LinkedList<>();
			System.out.print(root.data + " ");
			if (root.left != null) queue.add(root.left);
			if (root.right != null) queue.add(root.right);
			
			
			Stack<Integer> stack = new Stack<Integer>();
			boolean flip = true;
			
			while (!queue.isEmpty()) {
				
				int nodeCount = queue.size();
				
				while (nodeCount > 0) {
					Node currNode = queue.poll();
					if(flip) System.out.print(currNode.data + " ");
					else stack.push(currNode.data);
					
					if (currNode.left != null) queue.add(currNode.left);
					if (currNode.right != null) queue.add(currNode.right);
					
					nodeCount--;
				}
				flip = !flip;
				while (!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}
			}
		} 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			tree.levelOrderSpiralTraversal(root);
			System.out.println("\n");
		}
	}
	
	static Node buildTree(String str) {
		if (str.length() == 0 || str.charAt(0)=='N') return null;
		
		String[] ip = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while (!queue.isEmpty() && i < ip.length) {
			
			Node currNode = queue.poll();
			
			String currVal = ip[i];
			
			if (!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
				
			}
			i++;
			
			if (i >= ip.length) break;
			
			currVal = ip[i];
			if (!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
		}
		return root;
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
