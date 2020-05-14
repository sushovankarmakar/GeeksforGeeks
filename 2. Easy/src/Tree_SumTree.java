import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/sum-tree/1/
// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

public class Tree_SumTree {
		
	static boolean isSumTree(Node root)
	{   
	    if(root == null) return true;
	    
	    int leftValue = checkSumTree(root.left);
	    int rightValue = checkSumTree(root.right);
	    
	    if(leftValue == -1 || rightValue == -1) return false;
	    
	    if( root.data == (leftValue + rightValue)) return true;
	    
	    return false;
	}
	
	private static int checkSumTree(Node root) {
	    if(root == null) return 0;
	   
	    int leftValue = checkSumTree(root.left);
	    int rightValue = checkSumTree(root.right);
	    
	    if(leftValue == 0 && rightValue == 0) return root.data;

	    if((leftValue != -1) && (rightValue != -1)) {
	        if( root.data == (leftValue + rightValue)) {
	            return (root.data*2);
	        }
	    }
	    return -1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String str = br.readLine().trim();
			Node root = buildTree(str);
			//printTree(root);
			System.out.println(isSumTree(root) ? 1 : 0);
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
