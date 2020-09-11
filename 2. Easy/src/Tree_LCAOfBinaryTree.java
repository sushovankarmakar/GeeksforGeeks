import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// https://www.youtube.com/watch?v=13m9ZCB8gjw (BEST VIDEO - Short one to understand)
// https://www.youtube.com/watch?v=py3R23aAPCA (BEST VIDEO - I followed this type of code)
// https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/LowestCommonAncestorBinaryTree/LowestCommonAncestorBinaryTree.java
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/ (Similar question)

public class Tree_LCAOfBinaryTree {

    /*
    Tip : It is very important to understand LCA in various scenarios before attempting the question.
    The solution is very easy if all scenarios understood clearly.

    scenario 1: both n1 and n2 are in left and right subtree of the ancestor. (return the ancestor)
    scenario 2 : either n1 or n2 is the ancestor or other. Then return the ancestor(node n1 or n2)
    scenario 3 : only one of n1 or n2 found. the return that node
    scenario 4 : none found. return null
    */

    /* time complexity  : O(N) , N = total number of nodes in the tree
    *  space complexity : O(H) , H = height of the tree, which is the call stack
    * */

    private static TreeNode lcaOfBinaryTree(TreeNode root, int number1, int number2) {
        /*
         * Our base cases. How our recursion stops. When we have an answer.
         *
         * 1.) If the node we are holding is null then we can't search...just return
         * null 2.) If we find either value return ourselves to the caller
         *
         * Remember, we are "grabbing"/"holding" 'root' in this call.
         */
        if (root == null) return null;
        if (root.data == number1 || root.data == number2) return root;

        /*
         * 'root' doesn't satisfy any of our base cases.
         *
         * Search left and then search right.
         */

        TreeNode leftSearchResult   = lcaOfBinaryTree(root.left,  number1, number2);
        TreeNode rightSearchResult  = lcaOfBinaryTree(root.right, number1, number2);

        /* If nothing turned up on the left, return whatever we got back on the right. */
        if (leftSearchResult == null) return rightSearchResult;   /* if (left == null && right != null) */

        /* If nothing turned up on the right, return whatever we got back on the left. */
        if (rightSearchResult == null) return leftSearchResult;   /* if (left != null && right == null) */

        /* (left == null && right == null)  - this condition will be automatically taken care by above two if conditions */

        /*
         * If we reach here that means we got something back on the left AND
         * right...that means this node is the LCA...because our recursion returns from
         * bottom to up...so we return what we hold...'root'
         */
        return root;    /* if (left != null && right != null) */
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            String[] numbers = br.readLine().trim().split("\\s+");
            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);
            TreeNode root = buildTree(s);
            TreeNode lcaNode = lcaOfBinaryTree(root, number1, number2);
            System.out.println(lcaNode != null ? lcaNode.data : "LCA not found");
        }
    }

    private static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        String[] ip = str.split("\\s+");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < ip.length) {
            TreeNode currNode = queue.poll();

            String currData = ip[index];
            if (!currData.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currData));
                queue.add(currNode.left);
            }
            index++;

            if (index >= ip.length) break;

            currData = ip[index];
            if (!currData.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currData));
                queue.add(currNode.right);
            }
            index++;
        }
        return root;
    }

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
