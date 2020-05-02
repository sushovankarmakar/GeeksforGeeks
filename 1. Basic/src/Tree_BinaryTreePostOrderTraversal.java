import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// https://practice.geeksforgeeks.org/problems/postorder-traversal/1/

public class Tree_BinaryTreePostOrderTraversal {
	
	static class Tree {
		void printPostOrder(Node root) {
			if(root == null) return;
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			tree.printPostOrder(root);
			System.out.println("\n");
		}
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
		while(queue.size() > 0 && i < ip.length) {
			
			Node currNode = queue.peek();
			queue.remove();
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
