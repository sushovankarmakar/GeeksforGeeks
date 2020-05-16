import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1
// https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
// https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description
// https://www.interviewbit.com/problems/longest-consecutive-sequence-in-binary-tree/
// https://www.programcreek.com/2014/04/leetcode-binary-tree-longest-consecutive-sequence-java/
// https://www.interviewbit.com/help_requests/43156/

public class Tree_LongestConsecutiveSequenceInBinaryTree {
	
	/*static int ans = -1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0; 
        
        ans = -1;
        
        longestConsecutiveUtil(root, Integer.MAX_VALUE, 1);
        
        return ans;
    }
    
    private static void longestConsecutiveUtil(TreeNode root, int prevVal, int currDepth) {
        if(root == null) {
            ans = Math.max(ans, currDepth);
            return;
        }
        
        if(root.val == 1 + prevVal){
            ++currDepth;
            ans  = Math.max(ans, currDepth);
        }
        else
            currDepth = 1;
        
        longestConsecutiveUtil(root.left, root.val, currDepth);
        longestConsecutiveUtil(root.right, root.val, currDepth);
    }*/
	
	static class Result {
        int res = 0;
    }
    public static int longestConsecutive(Node root) {
        if(root == null) return 0; 
        
        Result res = new Result();
        
        longestConsecutiveUtil(root, 0, root.data, res);
        
        return res.res;
    }
    
    private static void longestConsecutiveUtil(Node root, int currLength, int expected, Result res) {
        if(root == null) return;
        
        if(root.data == expected) currLength++;
        else  currLength = 1;
        
        res.res = Math.max(res.res, currLength);
        
        longestConsecutiveUtil(root.left, currLength, root.data+1, res);
        longestConsecutiveUtil(root.right, currLength, root.data+1, res);
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String str = br.readLine().trim();
			Node root = buildTree(str);
			//printTree(root);
			System.out.println(longestConsecutive(root));
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
