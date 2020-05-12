import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
// https://www.geeksforgeeks.org/tree-isomorphism-problem/

public class Tree_CheckBinaryTreeIsIsomorphic {
	
	private static boolean isIsomorphic(Node root1, Node root2)  
    { 
        if(root1 == null && root2 == null) return true;
        
        //if only one of the node is null, then that tree can't be isomorphic
        if(root1 == null || root2 == null) return false;
        
        //if both the nodes data is not equal then tree can't be isomorphic
        if(root1.data != root2.data) return false;
         
        if(	(isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left)) || 
            (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))) {
                return true;    
            }
         return false;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip1 = br.readLine().trim();
			String ip2 = br.readLine().trim();
			Node root1 = buildTree(ip1);
			Node root2 = buildTree(ip2);
			System.out.println(isIsomorphic(root1, root2)? "Yes" : "No");
		}
	}
	
	private static Node buildTree(String str) {
		if(str.length() == 0 || str.charAt(0) == 'N') return null;
		
		String ip[] = str.split("\\s+");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
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
	
	static class Node  {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
