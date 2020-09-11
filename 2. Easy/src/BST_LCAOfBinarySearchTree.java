import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// https://www.youtube.com/watch?v=TIoCCStdiFo (BEST VIDEO EVER)
// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1 (Similar question)

public class BST_LCAOfBinarySearchTree {

    /* time complexity  : O(H) , H = height of the tree
     *  space complexity : O(H) , H = height of the tree, which is the call stack
     * */
    /* Function to find LCA of number1 and number2. The function assumes that both number1 and number2 are present in BST */
    private static TreeNode lcaOfBinarySearchTree(TreeNode root, int number1, int number2) {
        if (root == null) return null;

        /* If both number1 and number2 are smaller than root, then LCA lies in left */
        if (root.data > number1 && root.data > number2) {
            return lcaOfBinarySearchTree(root.left, number1, number2);
        }
        /* If both number1 and number2 are greater than root, then LCA lies in right */
        if (number1 > root.data && number2 > root.data) {
            return lcaOfBinarySearchTree(root.right, number1, number2);
        }
        return root;
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
            TreeNode lcaNode = lcaOfBinarySearchTree(root, number1, number2);
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
