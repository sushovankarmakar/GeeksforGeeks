import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/sum-of-leaf-nodes/1
// https://www.geeksforgeeks.org/sum-leaf-nodes-binary-tree/

public class Tree_SumOfLeafNodes {

	private static int getSumofLeafNodes(Node root) {
		int sumOfLeafNodes = 0;
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;

		sumOfLeafNodes += getSumofLeafNodes(root.left);
		sumOfLeafNodes += getSumofLeafNodes(root.right);

		return sumOfLeafNodes;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			Map<Integer, Node> m = new HashMap<>();
			int n = sc.nextInt();
			Node root = null;
			while (n-- > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				Node parent = m.get(n1);
				if (parent == null) {

					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}
			System.out.println(getSumofLeafNodes(root));
		}
		sc.close();
	}

	private static class Node {
		private int data;
		private Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
