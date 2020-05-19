import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1/
// https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

public class BST_DeleteNodeFromBST {
	
	public static Node deleteNode(Node root, int value)
	{   
		if(root == null) return null;
		else if(value < root.data) root.left = deleteNode(root.left, value);
		else if(value > root.data) root.right = deleteNode(root.right, value);
		else {
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			else {
				root.data = minValue(root.right);
				root.right = deleteNode(root.right, value);
			}
		}
		return root;
	}
	
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
			int key = Integer.parseInt(br.readLine().trim());
			Node root = buildTree(ip);
			Node rootAfterDeletion = deleteNode(root, key);
			inorder(rootAfterDeletion);
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
