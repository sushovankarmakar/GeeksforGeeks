import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/
// https://practice.geeksforgeeks.org/editorial.php?pid=700184
// https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/

public class Tree_ConnectNodesAtSameLevel {
	
	// with no extra space, time : O(n) , space : O(n)
	/*private static void connectNodesAtSameLevel(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0) break;
			
			while(nodeCount > 0) {
				TreeNode currNode = queue.poll();
				
				if(nodeCount != 1) currNode.nextRight = queue.peek();
				System.out.println(currNode.data + " " + (currNode.nextRight != null ? currNode.nextRight.data : "N"));
				
				if(currNode.left != null) queue.add(currNode.left);
				if(currNode.right != null) queue.add(currNode.right);
				
				nodeCount--;
			}
		}
	}*/

	//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	// below solution is only for PERFECT BINARY TREE
	public TreeNode connectNodesAtSameLevelForPerfectBinaryTree(TreeNode root) {
		if(root == null) return null;
		connectRightNextNode(root.left, root.right);
		return root;
	}

	private void connectRightNextNode(TreeNode node1, TreeNode node2) {
		if(node1 == null) return;

		node1.nextRight = node2;

		connectRightNextNode(node1.left, node1.right);
		connectRightNextNode(node2.left, node2.right);
		connectRightNextNode(node1.right, node2.left);
	}

	// https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
	// with no extra space, time : O(n) , space : O(1)
	public static void connectNodesAtSameLevel(TreeNode root){
        if(root == null) return;
		
		root.nextRight = null;
		
		TreeNode levelStart = root;		//we have to keep track of first node of every level
		
		while(levelStart != null) {
			TreeNode node = levelStart;
		    
		    while(node != null) {
		        if(node.left != null) {
		            if(node.right != null) 
		                node.left.nextRight = node.right;
		            else 
		                node.left.nextRight = getNextNodeFirstChild(node);
		        }
		        
		        if(node.right != null)
		            node.right.nextRight = getNextNodeFirstChild(node);
		        
		        node = node.nextRight;
		    }
		    
		    if(levelStart.left != null) levelStart = levelStart.left;
		    else if(levelStart.right != null) levelStart = levelStart.right;
		    else levelStart = getNextNodeFirstChild(levelStart);
		}
    }
    
    private static TreeNode getNextNodeFirstChild(TreeNode root) {
        if(root == null) return null;
        root = root.nextRight;
        
        while(root != null) {
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
            
            root = root.nextRight;
        }
        
        return null;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip = br.readLine().strip();
			TreeNode root = buildTree(ip);
			
			connectNodesAtSameLevel(root);
			
			//printLevelOrder(root);
			//System.out.println();
			
			printSpecial(root);
			System.out.println();
			
			printInOrder(root);
			System.out.println();
		}
	}
	
	private static void printSpecial(TreeNode root) {
       if (root == null)
         return;
    
       TreeNode next_root=null;
    
       while (root != null)
       {
          System.out.print(root.data+" ");
    
          if( root.left!=null && next_root==null )
            next_root = root.left;
          else if( root.right!=null && next_root==null  )
            next_root = root.right;
    
          root = root.nextRight;
       }
       
       printSpecial(next_root);
    }

	static void printLevelOrder(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(queue.size() != 0) {
			TreeNode currNode = queue.poll();
			System.out.print(currNode.data + " ");
			
			if(currNode.left != null) {
				queue.add(currNode.left);
			}
			
			if(currNode.right != null) {
				queue.add(currNode.right);
			}
		}
	}
	
	static void printInOrder(TreeNode root) {
		if(root == null) return;
		
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
	
	static TreeNode buildTree(String str) {
		if(str.length() == 0 || str.charAt(0) == 'N') return null;
		String ip[] = str.split("\\s+");
		TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		int i = 1;
		while(queue.size() != 0 && i < ip.length) {
			TreeNode currTreeNode = queue.poll();
			
			String currVal = ip[i];
			
			if(!currVal.equals("N")) {
				currTreeNode.left = new TreeNode(Integer.parseInt(currVal));
				queue.add(currTreeNode.left);
			}
			i++;
			
			if(i >= ip.length) break;
			
			currVal = ip[i];
			
			if(!currVal.equals("N"))  {
				currTreeNode.right = new TreeNode(Integer.parseInt(currVal));
				queue.add(currTreeNode.right);
			}
			i++;
		}
		return root;
	}
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode nextRight;
		TreeNode(int data) {
			this.data = data;
			this.left = this.right = this.nextRight = null;
		}
	}
}
