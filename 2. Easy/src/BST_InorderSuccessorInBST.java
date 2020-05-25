import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
// https://www.youtube.com/watch?v=kdK_5rl1cVw
// https://www.youtube.com/watch?v=5cPbNCrdotA
// https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
// https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/

public class BST_InorderSuccessorInBST {
	
	 private static Node inorderSuccessor(Node root, Node x){
        if(root == null || x == null) return null;
        
        if(x.right != null) return getMinNode(x.right);
        
        Node successor = null;
        
        while(root != null) {
            if(x.data < root.data) {
                successor = root;
                root = root.left;
            }
            else if(root.data < x.data) {
                root = root.right;
            }
            else break;
        }
        return successor;
    }
    
    private static Node getMinNode(Node root) {
        if(root == null) return null;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip = br.readLine().trim();
			int k = Integer.parseInt(br.readLine().trim());
			Node root = buildTree(ip);
			Node x = search(root, k);
			Node inorderSuccessor = inorderSuccessor(root, x);
			System.out.println((inorderSuccessor != null) ? inorderSuccessor.data : -1);
		}
	}
	
	
	private static Node search(Node root, int x) {
		if(root == null || root.data == x) return root;

		if(root.data > x)
			return search(root.left, x);

		return search(root.right, x);
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
		while(!queue.isEmpty() && i < ip.length) {
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
	
	static class Node {
		private int data;
		private Node left; 
		private Node right;
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
