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


public class Tree_VerticalTraversalOfBinaryTree {
	
	// pre order traversal didn't give right output in GCG, so I went for level order traversal
	
	/*void verticalTraversal(Node root, int horizontalDistance, TreeMap<Integer, List<Integer>> treeMap) {
		if(root == null) return;
		
		List<Integer> list = treeMap.get(horizontalDistance); 
		if(list == null) {
			list = new ArrayList<Integer>();	
		}
		list.add(root.data);
		treeMap.put(horizontalDistance, list);
		
		
		verticalTraversal(root.left, horizontalDistance-1, treeMap);
		verticalTraversal(root.right, horizontalDistance+1, treeMap);
	}*/
	
	static class Pair {
		Node node;
		int horizontalDistance;
		
		Pair(Node node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
		
		Node getNode() {
			return this.node;
		}
		
		int getHorizontalDistance() {
			return this.horizontalDistance;
		}
	}
	
	static class Tree {
		
		// level order traversal is applied here.
		
		void verticalTraversal(Node root, int horizontalDistance, TreeMap<Integer, List<Integer>> treeMap) {
			if(root == null) return;
			
			Queue<Pair> queue = new LinkedList<Pair>();
			queue.add(new Pair(root, horizontalDistance));
			
			while(!queue.isEmpty()) {
				
				int countNode = queue.size();
				
				while(countNode > 0) {
					Pair pair = queue.poll();
					
					root = pair.getNode();
					horizontalDistance = pair.getHorizontalDistance();
					
					List<Integer> list = treeMap.get(horizontalDistance); 
					if(list == null) {
						list = new ArrayList<Integer>();	
					}
					list.add(root.data);
					treeMap.put(horizontalDistance, list);
					
					
					if(root.left != null) queue.add(new Pair(root.left, horizontalDistance-1));
					if(root.right != null) queue.add(new Pair(root.right, horizontalDistance+1));
					
					countNode--;
				}
			}	
		}
		
		void printTree(TreeMap<Integer, List<Integer>> treeMap) {
			for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) { 
	            List<Integer> list  = (List<Integer>) entry.getValue();
	            for (Integer data : list) {
					System.out.print(data + " ");
				} 
	        }
			System.out.println("\n");
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s = br.readLine().trim();
			Node root = buildTree(s);
			Tree tree = new Tree();
			int horizontalDistance = 0; 
			TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
			tree.verticalTraversal(root, horizontalDistance, treeMap);
			tree.printTree(treeMap);
		}
	}
	
	static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0)=='N') return null;
		
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while (queue.size() > 0 && i < ip.length) {
			
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
