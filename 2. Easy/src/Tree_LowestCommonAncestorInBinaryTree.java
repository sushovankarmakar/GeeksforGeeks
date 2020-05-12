import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
// https://www.youtube.com/watch?v=13m9ZCB8gjw
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

public class Tree_LowestCommonAncestorInBinaryTree {
	
	private static Node getLowestCommonAncestor(Node root, int n1, int n2) {
		if(root == null) return null;
		if(root.data == n1 || root.data == n2) return root;
		
		Node left_lca = getLowestCommonAncestor(root.left, n1, n2);
		Node right_lca = getLowestCommonAncestor(root.right, n1, n2);
		
		if(left_lca != null && right_lca != null) return root;
		
		return left_lca != null ? left_lca : right_lca;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String n1n2[] = br.readLine().trim().split("\\s+");
			int n1 = Integer.parseInt(n1n2[0]), n2 = Integer.parseInt(n1n2[1]);
			String ip = br.readLine().trim();
			Node root = buildTree(ip);
			//printTree(root);
			//System.out.println();
			Node lowestCommonAncestor = getLowestCommonAncestor(root, n1, n2);
			System.out.println(lowestCommonAncestor.data);
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0) == 'N' ) return null;
		
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>(); 
		queue.add(root);
		
		int i = 1;
		
		while(queue.size() > 0 && i < ip.length) {
			
			Node currNode = queue.poll();
			
			String currVal =  ip[i];
			
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
