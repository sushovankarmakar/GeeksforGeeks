import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
// https://www.youtube.com/watch?v=Jg4E4KZstFE
// https://backtobackswe.com/platform/content/sum-root-to-leaf-paths/video

public class Tree_RootToLeafPathSum {
	
	/*static boolean hasPathSum(Node root, int expectedSum) {
		return (root.data == expectedSum) || 
				checkPathSum(root.left, expectedSum, root.data) ||
				checkPathSum(root.right, expectedSum, root.data);
	}
	
	static boolean checkPathSum(Node root, int expectedSum, int currentSum) {
		if(root == null) return (expectedSum == currentSum);
		
		return checkPathSum(root.left, expectedSum, (currentSum + root.data)) ||
				checkPathSum(root.right, expectedSum, (currentSum + root.data));
	}*/
	
	/*static boolean hasPathSum(Node root, int expectedSum) {
		if(root == null) return false;
		
		boolean isLeaf = (root.left == null && root.right == null);
		
		if(isLeaf) {
			return ((expectedSum - root.data) == 0); 
		}
		
		return hasPathSum(root.left, (expectedSum - root.data)) || 
				hasPathSum(root.right, (expectedSum - root.data));
	}*/
	
	static boolean hasPathSum(Node root, int expectedSum) {
		if(root == null) return (expectedSum == 0);
		
		return hasPathSum(root.left, (expectedSum - root.data)) ||
				hasPathSum(root.right, (expectedSum - root.data));
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String str = br.readLine().trim();
			int expectedSum = Integer.parseInt(br.readLine().trim());
			Node root = buildTree(str);
			//printTree(root);
			System.out.println(hasPathSum(root, expectedSum)? 1 : 0);
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0) == 'N') return null;
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i=1;
		while(queue.size() > 0 && i < ip.length) {
			Node currNode = queue.poll();
			
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
	
	static void printTree(Node root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}
	
	static class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
