import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/inorder-traversal/1
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java
// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
// https://www.youtube.com/watch?v=VsxLHGUqAKs&feature=emb_logo

// https://www.youtube.com/watch?v=nzmtCFNae9k&t=200s (GOOD Video Example)
// https://www.youtube.com/watch?v=wGXB9OWhPTg (BEST Video in Morris Traversal)

// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/ (A good post which discusses all 3 approaches)

public class Tree_BinaryTreeInOrderTraversal {
	
	static class Tree {

		/* recursive inorder traversal with return type as list */
		ArrayList<Integer> inOrder(Node root) {
			ArrayList<Integer> op = new ArrayList<>();
			inorder(root, op);
			return op;
		}

		private void inorder(Node root, ArrayList<Integer> op) {
			if (root == null) return;
			inorder(root.left, op);
			op.add(root.data);
			inorder(root.right, op);
		}

		/* recursive inorder traversal with no return type */
		void printInOrderRecursive(Node root) {
			if (root == null) return;
			printInOrderRecursive(root.left);
			System.out.print(root.data+ " ");
			printInOrderRecursive(root.right);
		}

		/* non recursive inorder traversal using stack
		* time complexity  : O(N)
		* space complexity : O(N) */
		void printInOrderNonRecursive(Node root) {
			if (root == null) return;

			StringBuilder sb = new StringBuilder();
			Stack<Node> stack = new Stack<>();
			Node currNode = root;

			while (currNode != null || !stack.isEmpty()) { /* when currNode is null and stack is also empty, then traversing is complete */

				while (currNode != null) {	/* until currNode is null, push that node to stack and go deeper in left side */
					stack.push(currNode);
					currNode = currNode.left;
				}

				/* at this point, currNode must be null */
				currNode = stack.pop();
				sb.append(currNode.data).append(" ");

				/* we have visited the node and its left subtree.  Now, it's right subtree's turn */
				currNode = currNode.right;
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
		void printInOrderUsingMorrisTraversal(Node root) {
			StringBuilder sb = new StringBuilder();
			Node currNode  = root;
			while (currNode != null) {

				if (currNode.left == null) {

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

					if (inOrderPredecessor.right == null) {

						/* if predecessor's right is null that means we have not been in
						* the left side we should visit on the left child.
						* before visiting to the left child, we establish the link between
						* inOrderPredecessor's right and currNode */

						inOrderPredecessor.right = currNode;
						currNode = currNode.left;
					}
					else {

						/* if predecessor's right is current it means that we've already visited the left side
						* so we break the link between inOrderPredecessor and current node, then print the current data
						* and then go deeper on the right side */

						inOrderPredecessor.right = null;
						sb.append(currNode.data).append(" ");
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
		while(t-- > 0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			System.out.println("Recursive : ");
			tree.printInOrderRecursive(root);
			System.out.println();

			System.out.println("Non recursive : ");
			tree.printInOrderNonRecursive(root);

			System.out.println("Using Morris traversal : ");
			tree.printInOrderUsingMorrisTraversal(root);
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
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
