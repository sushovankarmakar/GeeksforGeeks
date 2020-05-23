import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

public class BST_FixingTwoNodesOfBST {

	static Node node1, node2, prev;

	public static Node correctBST(Node root) {
		node1 = node2 = null;

		correctBSTUtil(root);

		swap(node1, node2);

		node1 = node2 = prev = null;  // making them null for the after each test cases case there are static global variables.

		return root;
	}

	private static void correctBSTUtil(Node root) {
		if (root == null)
			return;

		correctBSTUtil(root.left);

		if (prev != null && (prev.data > root.data)) {

			if (node1 == null) {
				node1 = prev;
				node2 = root;
			} else {
				node2 = root;
			}
		}

		prev = root;

		correctBSTUtil(root.right);
	}

	private static void swap(Node node1, Node node2) {
		if (node1 == null || node2 == null)
			return;

		int tempNode = node1.data;
		node1.data = node2.data;
		node2.data = tempNode;
	}

	static int flag = 1;
	static int c = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int m = n;
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			Node temp = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					temp = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						temp.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						temp.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
					insert(temp, a, a1, lr);
				}
			}
			flag = 1;
			c = 0;
			root = correctBST(root);

			inorder(temp, root);
			if (c + 1 == m)
				System.out.println(flag);
			else
				System.out.println("0");
		}
		sc.close();
	}

	public static void inorder(Node temp, Node root) {
		if (flag == 0) {
			return;
		}
		if (temp == null && root == null)
			return;
		if (root == null) {
			flag = 0;
			return;
		}
		if (temp == null) {
			flag = 0;
			return;
		}
		if (temp.data == root.data) {
			c++;
		}
		inorder(temp.left, root.left);
		inorder(temp.right, root.right);
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}
}
