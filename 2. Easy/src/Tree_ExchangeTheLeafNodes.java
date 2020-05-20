import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/exchange-the-leaf-nodes/1
// https://www.geeksforgeeks.org/pairwise-swap-leaf-nodes-binary-tree/

public class Tree_ExchangeTheLeafNodes {
	
	static Node prevNode = null;
    public static void exchangeLeaves(Node root){
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            if(prevNode == null) {
                prevNode = root;
            }
            else {
                swapNodes(prevNode, root);
                prevNode = null;
            }
        }
        exchangeLeaves(root.left);
        exchangeLeaves(root.right);
    }
    
    private static void swapNodes(Node root1, Node root2) {
        int temp = root1.data;
        root1.data = root2.data;
        root2.data = temp;
    }
	
	
	public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    Map<Integer, Node> map = new HashMap<>();
		    
		    int n = sc.nextInt();
             
            Node root = null;
            Node parent;
		    while(n-- > 0){
		        int p = sc.nextInt();
		        if(!map.containsKey(p)){
		            root = new Node(p);
		            map.put(root.data, root);
		        }
		        parent = map.get(p);
		        
		        int ch = sc.nextInt();
		        Node child = new Node(ch);
		        
		        char c = sc.next().charAt(0);
		        if(c == 'L')
		            parent.left = child;
		        else if(c == 'R')
		            parent.right = child;
		            
		        map.put(ch, child);
		    }
		    
		    exchangeLeaves(root);
		    
		    prevNode = null;
		    
		    inorder(root);
		    System.out.println();
		}
		sc.close();
	}
	
	static class Node {
	    int data;
	    Node left, right;
	    
	    public Node(int data){
	        this.data = data;
	    }
	}
}
