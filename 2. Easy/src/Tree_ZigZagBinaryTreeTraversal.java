import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/zigzag-tree-traversal/
// https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
// https://www.youtube.com/watch?v=vjt5Y6-1KsQ (Good video explanation two stack and one queue)
// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversalInSpiralOrder.java
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class Tree_ZigZagBinaryTreeTraversal {

	// this is almost similar to Level Order Traversal.
	// this is used one queue and one stack
	static class Tree {
		void levelOrderZigZagTraversal(Node root) {
			if(root == null) return;
			
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);
			
			Stack<Integer> stack = new Stack<>();
			boolean flip = true;
			
			while(true) {
				
				int nodeCount = queue.size();
				if(nodeCount == 0) break;
				
				while(nodeCount > 0) {
					Node currNode = queue.poll();
					
					if(flip) System.out.print(currNode.data + " ");
					else stack.push(currNode.data);
					
					if(currNode.left!=null) queue.offer(currNode.left);
					if(currNode.right!=null) queue.offer(currNode.right);
					
					nodeCount--;
				}
				
				while(!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}
					
				flip = !flip;
			}
		} 
	}

	// below solution uses one queue only
	public static List<List<Integer>>  zigzagLevelOrderUsingOneQueue(Node root) {
		List<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean fromLeft = true;

		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0) break;

			List<Integer> op = new LinkedList<>();

			while(nodeCount > 0) {

				Node currNode = queue.poll();

				if(fromLeft) op.add(currNode.data);
				else {
					op.add(0, currNode.data);
				}
				if(currNode.left  != null) queue.offer(currNode.left);
				if(currNode.right != null) queue.offer(currNode.right);

				nodeCount--;
			}
			result.add(op);
			fromLeft = !fromLeft;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			tree.levelOrderZigZagTraversal(root);
			System.out.println("\n");
			//zigzagLevelOrderUsingOneQueue(root);
		}
	}
	
	static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0)=='N') return null;
		
		String[] ip = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while (!queue.isEmpty() && i < ip.length) {
			
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
