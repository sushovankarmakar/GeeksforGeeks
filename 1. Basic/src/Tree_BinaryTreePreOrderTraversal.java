import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 26.08.2020
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// https://practice.geeksforgeeks.org/problems/preorder-traversal/1/
// https://leetcode.com/problems/binary-tree-preorder-traversal/
// https://www.geeksforgeeks.org/iterative-preorder-traversal/
// https://www.geeksforgeeks.org/iterative-postorder-traversal-set-3/?ref=rp

// https://www.youtube.com/watch?v=elQcrJrfObg (A Good Video)

public class Tree_BinaryTreePreOrderTraversal {
	
	static class Tree {

		void printPreOrderRecursive(Node root) {
			if(root == null) return;
			System.out.print(root.data + " ");
			printPreOrderRecursive(root.left);
			printPreOrderRecursive(root.right);
		}

		void printPreOrderNonRecursive(Node root) {
			if(root == null) return;

			StringBuilder sb  = new StringBuilder();
			Stack<Node> stack = new Stack<>();

			Node currNode = root;
			stack.push(currNode);

			while (!stack.isEmpty()) {
				currNode = stack.pop();
				sb.append(currNode.data).append(" ");

				/* below two if conditions' sequence is very important.
				* we first put right node at stack and left node at stack
				* so when popping out we'll get left node first and then right node */

				if(currNode.right != null) {
					stack.push(currNode.right);
				}
				if(currNode.left != null) {
					stack.push(currNode.left);
				}
			}

			System.out.println(sb);
			sb.setLength(0);
		}

		// https://www.youtube.com/watch?v=wGXB9OWhPTg

		/* why we need a stack or recursion :
		 * when we are visiting from current node tp the left side,
		 * we need a way to comeback to the current node after left side is already visited
		 * this is wy we store the current node first at stack and then visit the left child */

		/* Morris Traversal : which uses neither recursion nor stack
		 * space complexity : O(N)
		 * time complexity : O(1) */

		void printPreOrderUsingMorrisTraversal(Node root) {
			if(root == null) return;

			StringBuilder sb = new StringBuilder();
			Node currNode = root;

			while (currNode != null) {

				if(currNode.left == null) {

					/* if current node's left is null, then there is nothing
					 * explore on the left side,so we print the current and
					 * go deeper in the right side */

					sb.append(currNode.data).append(" ");
					currNode = currNode.right;
				}
				else {

					/* if a current node has left child,
					 * find the inorder predecessor of that node
					 *
					 * inorder predecessor is the right most node in the left subtree
					 * */

					Node inOrderPredecessor = currNode.left;

					/* to find predecessor, keep going right till right node is not null
					 * or right node is not current */

					while (inOrderPredecessor.right != currNode && inOrderPredecessor.right != null) {
						inOrderPredecessor = inOrderPredecessor.right;
					}

					/* after the above while loop is end, then either
					 * predecessor's right is current or predecessor's right will be null */

					if(inOrderPredecessor.right == null) {

						/* if predecessor's right is null that means we have not been in
						 * the left side we should visit on the left child.
						 * before visiting to the left child, print the current data and we establish the link between
						 * inOrderPredecessor's right and currNode */

						inOrderPredecessor.right = currNode;
						sb.append(currNode.data).append(" ");
						currNode = currNode.left;
					}
					else {

						/* if predecessor's right is current it means that we've already visited the left side
						 * now go deeper on the right side */

						inOrderPredecessor.right = null;
						currNode = currNode.right;
					}
				}
			}

			System.out.println(sb);
			sb.setLength(0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();

			System.out.println("Recursive : ");
			tree.printPreOrderRecursive(root);
			System.out.println();

			System.out.println("Non recursive : ");
			tree.printPreOrderNonRecursive(root);

			System.out.println("Using Morris traversal : ");
			tree.printPreOrderUsingMorrisTraversal(root);
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length()==0 || str.charAt(0)=='N') {
			return null;
		}
		String[] ip = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while(!queue.isEmpty() && i < ip.length) {
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
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}


