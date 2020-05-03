import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

public class Tree_CheckForBalancedBinaryTree {

	static class Tree {
		
		// O(n^2) worst case time complexity
		/*boolean isBalanced(Node root) {
			if(root == null) return true;
			
			return ((Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) 
					&& isBalanced(root.left) && isBalanced(root.right)) ? true : false;
		}
		
		int getHeight(Node root) {
			if(root == null) return 0;
			return 1 + Math.max(getHeight(root.left),getHeight(root.right));
		}*/
		
		// O(n) worst case time complexity
		boolean isBalanced(Node root, Height height) {
			if(root == null) {
				height.height = 0;
				return true;
			}
			
			Height leftSubTreeHeight = new Height(), rightSubTreeHeight = new Height();
			boolean isLeftSubTreeBalanced = isBalanced(root.left, leftSubTreeHeight);
			boolean isRightSubTreeBalanced = isBalanced(root.right, rightSubTreeHeight);
			
			height.height = 1 + Math.max(leftSubTreeHeight.height, rightSubTreeHeight.height);
			
			if(Math.abs(leftSubTreeHeight.height - rightSubTreeHeight.height) >= 2) {
				return false;
			}
			else {
				return (isLeftSubTreeBalanced && isRightSubTreeBalanced) ;
			}
		}
	}
	
	static class Height {
		int height = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			//System.out.println(tree.isBalanced(root));
			Height height = new Height();
			System.out.println(tree.isBalanced(root, height));
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
