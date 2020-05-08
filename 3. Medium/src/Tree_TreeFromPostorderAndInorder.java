import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/
// https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
// https://hackerranksolutionc.blogspot.com/2017/10/tree-from-post-and-inorder.html

public class Tree_TreeFromPostorderAndInorder {
	
	static int postOrderIndex;
	
	static Node makeTree(int[] inOrder, int[] postOrder, int startInOrderIndex, 
			 int endInOrderIndex, Map<Integer, Integer> inOrderValueIndicesMap) {
		
		if(startInOrderIndex > endInOrderIndex) return null;
		
		Node rootNode = new Node(postOrder[postOrderIndex]);
		postOrderIndex--;
		
		if(startInOrderIndex == endInOrderIndex) return rootNode;
		
		int inOrderIndex = inOrderValueIndicesMap.get(rootNode.data);
		
		rootNode.right = makeTree(inOrder, postOrder, inOrderIndex+1, endInOrderIndex, inOrderValueIndicesMap);
		rootNode.left = makeTree(inOrder, postOrder, startInOrderIndex, inOrderIndex-1, inOrderValueIndicesMap);
		
		// we make right subtree before left subtree cause when inOrderIndex = 0 and 
		// left makeSubtree is called then it goes to up and if(startInOrderIndex > endInOrderIndex) becomes true
		// it returns null and we terminate the execution
		
		return rootNode;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] ip1 = br.readLine().trim().split("\\s+"), 
					 ip2 = br.readLine().trim().split("\\s+");
			int[] inOrder = new int[n],
				  postOrder = new int[n];
			for (int i = 0; i < n; i++) {
				inOrder[i] = Integer.parseInt(ip1[i]);
				postOrder[i] = Integer.parseInt(ip2[i]);
			}
			Node root = buildTree(inOrder, postOrder, n);
			printPreOrder(root);
			System.out.println();
		}
	}
	
	static Node buildTree(int[] inOrder, int[] postOrder, int n) {
		Map<Integer, Integer> inOrderValueIndicesMap = getInOrderValueIndicesMap(inOrder);
		postOrderIndex = n-1;
		return makeTree(inOrder, postOrder, 0, n-1, inOrderValueIndicesMap);
	}
	
	static Map<Integer, Integer> getInOrderValueIndicesMap(int[] inOrder) {
		Map<Integer, Integer> inOrderValueIndicesMap = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			inOrderValueIndicesMap.put(inOrder[i], i);
		}
		return inOrderValueIndicesMap;
	}
	
	static void printPreOrder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
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
