import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://ide.geeksforgeeks.org/JGmq5jDWP0
// https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
// https://practice.geeksforgeeks.org/problems/level-order-traversal-line-by-line/1/

public class Tree_LevelOrderTraversalLineByLine {
	
	// using height and for loop
	/*static class Tree {
		int getHeight(Node root) {
			if(root == null) return 0;
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
		
		void levelOrderTraversalLineByLine(Node root, int height) {
			for(int i = 1; i<=height; i++) {
				printGivenLevel(root, i);
				System.out.print("$ ");
			}
		}
		
		void printGivenLevel(Node root, int level) {
			if(root == null) return;
			if(level == 1) System.out.print(root.data + " ");
			else if(level > 1) {
				printGivenLevel(root.left, level-1);
				printGivenLevel(root.right, level-1);
			}
		}
	}*/
	
	// using queue and null
	// this algorithm gives TLE problem. 
	/*static class Tree {
		void levelOrderTraversalLineByLine(Node root) {
			if(root == null) return;
			
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);
			
			while(queue.size() > 0) {
				Node currNode = queue.poll();
				
				if(currNode != null) {
					System.out.print(currNode.data + " ");
				}
				else if(currNode == null) {
					System.out.print("$ ");
					queue.add(null);
					continue;
				}
				
				if(currNode.left != null) queue.add(currNode.left);
				if(currNode.right != null) queue.add(currNode.right);
			}
			System.out.println("$ ");
			queue.clear();
		}
	}*/
	
	static class Tree {

		public void levelOrderTraversalLineByLine(Node root) {
			if(root == null) return;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			
			while(true) {
				
				int nodeCount = queue.size();
				if(nodeCount == 0) break;
				
				while(nodeCount > 0) {
					Node currNode = queue.poll();
					System.out.print(currNode.data + " ");
					
					if(currNode.left != null) queue.add(currNode.left);
					if(currNode.right != null) queue.add(currNode.right);
					
					nodeCount--;
				}
				System.out.print("$ ");
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			//int height = tree.getHeight(root);
			//tree.levelOrderTraversalLineByLine(root,height);
			tree.levelOrderTraversalLineByLine(root);
			System.out.println("\n");
		}
	}
	
	static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0)=='N') {
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
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
 	}

}
