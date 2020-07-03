import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/array-to-bst/0
// https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35220/My-Accepted-Java-Solution

class BST_ArrayToBST {

	private static TreeNode buildBSTFromSortedArray(int[] ip) {
		if(ip.length == 0) return null;

		int left = 0;
		int right = ip.length-1;
		return buildBST(ip, left, right);
	}

	private static TreeNode buildBST(int[] ip, int left, int right) {
		if(left > right) return null;

		int mid = left + (right - left) / 2;

		TreeNode root = new TreeNode(ip[mid]);

		root.left  = buildBST(ip, left, mid-1);
		root.right = buildBST(ip, mid+1, right);

		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split("\\s+");
			int[] ip = new int[n];
			for(int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(str[i]);
			}
			TreeNode root = buildBSTFromSortedArray(ip);

			StringBuilder sb = new StringBuilder();
			printTree(root, sb);
			System.out.println(sb);
		}
	}

	static void printTree(TreeNode root, StringBuilder sb) {
		if(root == null) return;

		sb.append(root.data).append(" ");
		printTree(root.left, sb);
		printTree(root.right, sb);
	}

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
