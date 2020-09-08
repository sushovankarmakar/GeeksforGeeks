import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/level-order-tree-traversal/
// https://practice.geeksforgeeks.org/problems/level-order-traversal/1/

public class Tree_LevelOrderTraversal {
	
	private static List<Integer> levelOrderTraversal(Node root) {
		List<Integer> output = new ArrayList<>();
		if (root == null) return output;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			output.add(currNode.data);

			if(currNode.left  != null) queue.add(currNode.left);
			if(currNode.right != null) queue.add(currNode.right);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String input = br.readLine().trim();
			Node root = buildTree(input);
			List<Integer> output = levelOrderTraversal(root);
			printTree(output);
		}
	}

	private static void printTree(List<Integer> output) {
		StringBuilder sb = new StringBuilder();
		for (int value : output) {
			sb.append(value).append(" ");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
	
	static Node buildTree(String str) {
		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}
		String[] ip = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while (!queue.isEmpty() && i < ip.length) {
			Node currNode = queue.peek();
			queue.remove();
			
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
		Node(int data){
			this.data = data;
			left = right = null;
		}
 	}
}
