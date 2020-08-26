import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/postorder-traversal/1/
// https://leetcode.com/problems/binary-tree-postorder-traversal/
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java
// https://www.youtube.com/watch?v=qT65HltK2uE (Best Video Explanation)
// https://www.youtube.com/watch?v=xLQKdq0Ffjg (BEST Video on non recursive with single stack)

public class Tree_BinaryTreePostOrderTraversal {
	
	static class Tree {

		void printPostOrderRecursive(Node root) {
			if (root == null) return;
			printPostOrderRecursive(root.left);
			printPostOrderRecursive(root.right);
			System.out.print(root.data + " ");
		}

		void printPostOrderRecursiveWithTwoStack(Node root) {
			Stack<Node> stackA = new Stack<>();
			Stack<Node> stackB = new Stack<>();

			Node currNode = root;
			stackA.push(currNode);

			while (!stackA.isEmpty()) {
				currNode = stackA.pop();
				stackB.push(currNode);

				if(Objects.nonNull(currNode.left)) stackA.push(currNode.left);
				if(Objects.nonNull(currNode.right)) stackA.push(currNode.right);
			}

			print(stackB);
		}

		void print(Stack<Node> stack) {
			if(stack == null) return;
			StringBuilder sb = new StringBuilder();

			while (!stack.isEmpty()) {
				sb.append(stack.pop().data).append(" ");
			}
			System.out.print(sb);
			sb.setLength(0);
		}

		// https://www.youtube.com/watch?v=xLQKdq0Ffjg (BEST Video on non recursive with single stack)
		// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java#L98

		void printPostOrderRecursiveWithOneStack(Node root) {
			StringBuilder sb = new StringBuilder();
			Stack<Node> stack = new Stack<>();
			Node currNode = root;

			/* be on the loop when stack is not empty and currNode is not null */
			while (currNode != null || !stack.isEmpty()) {

				if (currNode != null) {
					stack.push(currNode);
					currNode = currNode.left;
				}
				else {

					/* at this point, currNode is null but stack is not empty,
					* so now we are gonna check does the node at the top of the stack has a right child or not*/

					Node temp = stack.peek().right;

					if(temp == null) {

						/* at this point both the left and right child node is already visited or both are null
						* so print the value */

						temp = stack.pop();
						sb.append(temp.data).append(" ");

						/* now we check that temp is right child of top of the stack or not.
						* if it is the right child then we are already visited both right child and left child,
						* so print the value */

						while (!stack.isEmpty() && temp == stack.peek().right) {
							temp = stack.pop();
							sb.append(temp.data).append(" ");
						}
					}
					else {
						/* it it almost similar as currNode = currNode.right,
						* so here we actually go deeper in the right child */

						currNode = temp;
					}
				}
			}

			System.out.println(sb);
			sb.setLength(0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();

			System.out.println("Recursive : ");
			tree.printPostOrderRecursive(root);
			System.out.println();

			System.out.println("Non recursive with two stack : ");
			tree.printPostOrderRecursiveWithTwoStack(root);
			System.out.println();

			System.out.println("Non recursive with one stack : ");
			tree.printPostOrderRecursiveWithOneStack(root);
			System.out.println();
		}
	}
	
	private static Node buildTree(String str) {
		
		if (str.length()==0 || str.charAt(0)=='N') {
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
