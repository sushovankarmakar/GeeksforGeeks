import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
// https://ide.geeksforgeeks.org/sfUOjxyEfv
// https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
// https://www.youtube.com/watch?v=PQKkr036wRc
// https://www.youtube.com/watch?v=SineNp8Kjwo
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/ (Similar question)
// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1/ (Similar question)

public class Tree_VerticalTraversalOfBinaryTree {
	
	/* pre order traversal didn't give right output in GCG, so I went for level order traversal */

	/* recursive function won't work cause there is a condition in the question which says
	* "If there are multiple nodes passing through a vertical line,
	* then they should be printed as they appear in level order traversal of the tree." */
	
	/*
	void verticalTraversal(Node root, int horizontalDistance, TreeMap<Integer, List<Integer>> treeMap) {
		if (root == null) return;
		
		List<Integer> list = treeMap.get(horizontalDistance); 
		if (list == null) {
			list = new ArrayList<Integer>();	
		}
		list.add(root.data);
		treeMap.put(horizontalDistance, list);
		
		
		verticalTraversal(root.left, horizontalDistance - 1, treeMap);
		verticalTraversal(root.right, horizontalDistance + 1, treeMap);
	}
	*/
	
	static class Pair {
		private TreeNode node;
		private int horizontalDistance;
		
		Pair(TreeNode node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	/* level order traversal is applied here */
	/* this vertical order traversal is similar to top view and bottom view of a tree */

	private static List<Integer> verticalTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		if (root == null) return output;

		Map<Integer, List<Integer>> treeMap = new TreeMap<>();	/* TreeMap is sorted according to the natural ordering of its keys */

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			int queueSize = queue.size();

			while (queueSize-- > 0) {

				Pair pair = queue.poll();
				TreeNode currNode = pair.node;
				int horizontalDistance = pair.horizontalDistance;

				List<Integer> list = treeMap.get(horizontalDistance);

				if (list == null) {
					list = new ArrayList<>();
				}

				list.add(currNode.data);
				treeMap.put(horizontalDistance, list);

				if (currNode.left  != null) queue.add(new Pair(currNode.left,  horizontalDistance - 1));
				if (currNode.right != null) queue.add(new Pair(currNode.right, horizontalDistance + 1));
			}
		}

		for (List<Integer> list : treeMap.values()) {
			output.addAll(list);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String s = br.readLine().trim();
			TreeNode root = buildTree(s);
			List<Integer> output = verticalTraversal(root);
			printTree(output);
		}
	}

	private static void printTree(List<Integer> output) {
		StringBuilder sb = new StringBuilder();
		for (int value : output) {
			sb.append(value).append(" ");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
	
	private static TreeNode buildTree(String str) {
		if (str.length() == 0 || str.charAt(0) == 'N') return null;
		
		String[] ip = str.split("\\s+");
		TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while (!queue.isEmpty() && i < ip.length) {

			TreeNode currNode = queue.poll();
			
			String currVal = ip[i];
			
			if (!currVal.equals("N")) {
				currNode.left = new TreeNode(Integer.parseInt(currVal));
				queue.add(currNode.left);
				
			}
			i++;
			
			if (i >= ip.length) break;
			
			currVal = ip[i];
			if (!currVal.equals("N")) {
				currNode.right = new TreeNode(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
		}
		return root;
	}
	
	private static class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;
		TreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
