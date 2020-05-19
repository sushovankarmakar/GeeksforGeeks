import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

public class BST_InsertNodeInBST {
	
	private static Node insert(Node root, int key) {
		if(root == null) return null;
		
		if(key < root.data) {
			if(root.left == null) root.left = new Node(key);
			else insert(root.left, key);
		}
		else if(key > root.data) {
			if(root.right == null) root.right = new Node(key);
			else insert(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().trim();
			int key = Integer.parseInt(br.readLine().trim());
			Node root = buildTree(ip);
			Node rootAfterInsertion = insert(root, key);
			inorder(rootAfterInsertion);
			System.out.println();
		}
	}
	
	private static void inorder(Node root)
    {
        if(root==null)  return;
    
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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
