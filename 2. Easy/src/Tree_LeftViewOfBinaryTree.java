import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
// https://www.geeksforgeeks.org/print-left-view-binary-tree/

public class Tree_LeftViewOfBinaryTree {
	
	// same logic with level by level traversal with printing only the first node of every level
	
	/*private static void getLeftView(Node root) {
		if(root == null) return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(true) {
			boolean isFirstNodeOfLevel = true;
			int nodeCount = queue.size();
			if(nodeCount == 0) break;
			
			while(nodeCount > 0) {
				Node currNode = queue.poll();
				
				if(isFirstNodeOfLevel) {
					System.out.print(currNode.data + " ");
					isFirstNodeOfLevel = !isFirstNodeOfLevel;
				}
				
				if(currNode.left != null) queue.add(currNode.left);
				if(currNode.right != null) queue.add(currNode.right);
				
				nodeCount--;
			}
		}
	}*/
	
	// recursive call
	private static int maxLevel = 0;
	private static void getLeftView(Node root) {
		getLeftViewUtil(root, 1);
		maxLevel = 0;
	}
	
	private static void getLeftViewUtil(Node root, int level) {
		if(root == null) return;
		
		if(maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		
		getLeftViewUtil(root.left, level+1);
		getLeftViewUtil(root.right, level+1);
		
		// if we traverse the right side child first then we will get right view of the tree.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			Node root = buildTree(ip);
			getLeftView(root);
			System.out.println();
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length()==0 || str.charAt(0)=='N') return null;
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while(queue.size() > 0 && i < ip.length) {
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
		private Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
