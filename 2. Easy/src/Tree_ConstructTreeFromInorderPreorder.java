import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/construct-tree-1/1
// https://www.techiedelight.com/construct-binary-tree-from-inorder-postorder-traversals/
// https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// https://www.youtube.com/watch?v=PoBGyrIWisE (Theory part)
// https://www.youtube.com/watch?v=FBpQEQkQ1No (BEST VIDEO)

// time complexity : O(n),  space complexity : O(n) due to hashmap

public class Tree_ConstructTreeFromInorderPreorder {

	private static Map<Integer, Integer> inOrderValueIndicesMap = new HashMap<>();
	private static int preOrderIndex = 0;

	private static Node buildTree(int[] preOrder, int[] inOrder) {
		for (int i = 0; i < inOrder.length; i++) {
			inOrderValueIndicesMap.put(inOrder[i], i);
		}

		/*making the static index = 0 for next test cases. or it will give ArrayIndexOutOfBoundException*/
		preOrderIndex = 0;	/* we start from the end cause in preOrder, root resides at the start */

		return build(preOrder, inOrder, 0, inOrder.length - 1);
	}
	
	private static Node build(int[] preOrder, int[] inOrder, int inOrderStartIndex, int inOrderEndIndex) {
		if(inOrderStartIndex > inOrderEndIndex) return null;
		
		Node rootNode = new Node(preOrder[preOrderIndex]);
		preOrderIndex++;
		
		if(rootNode == null || inOrderStartIndex == inOrderEndIndex) return rootNode;
		
		int inOrderIndex = inOrderValueIndicesMap.get(rootNode.data);

		/* In case of PreOrder and InOrder, we will first construct left child and then right child
		 * In case of PostOrder and InOrder, we will first construct right child and then left child */

		rootNode.left =	build(preOrder, inOrder, inOrderStartIndex, inOrderIndex - 1);
		rootNode.right = build(preOrder, inOrder, inOrderIndex + 1, inOrderEndIndex);
		
		return rootNode;
	}
	
	private static void printPostOrder(Node root) {
		if (root == null) return;
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] ip1 = br.readLine().trim().split("\\s+");
			String[] ip2 = br.readLine().trim().split("\\s+");
			int[] inOrder = new int[n];
			int[] preOrder = new int[n];

			for	(int i = 0; i < n; i++) {
				inOrder[i] = Integer.parseInt(ip1[i]);
				preOrder[i] = Integer.parseInt(ip2[i]);
			}

			Node root = buildTree(preOrder, inOrder);
			printPostOrder(root);
			System.out.println();
		}
	}
}
