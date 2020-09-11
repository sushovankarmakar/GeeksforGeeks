import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// https://www.youtube.com/watch?v=s5XRtcud35E (Theory Part)
// https://practice.geeksforgeeks.org/problems/construct-tree-1/1 (Similar question)
// https://www.youtube.com/watch?v=FBpQEQkQ1No (BEST VIDEO for similar question)

// time complexity : O(n),  space complexity : O(n) due to hashmap

public class Tree_ConstructTreeFromInorderPostorder {

    private static Map<Integer, Integer> inOrderValueIndicesMap = new HashMap<>();
    private static int postOrderIndex = 0;

    private static TreeNode buildTree(int[] postOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderValueIndicesMap.put(inOrder[i], i);
        }
        postOrderIndex = postOrder.length - 1;  /* we start from the end cause in postOrder, root resides at the end */
        return build(postOrder, inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode build(int[] postOrder, int[] inOrder, int inOderStartingIndex, int inOrderEndingIndex) {
        if (inOderStartingIndex > inOrderEndingIndex) return null;

        TreeNode rootNode = new TreeNode(postOrder[postOrderIndex]);
        postOrderIndex--;

        if (rootNode == null || inOderStartingIndex == inOrderEndingIndex) return rootNode;

        int inOrderIndex = inOrderValueIndicesMap.get(rootNode.data);

        /* In case of PostOrder and InOrder, we will first construct right child and then left child
        * In case of PreOrder and InOrder, we will first construct left child and then right child*/

        rootNode.right = build(postOrder, inOrder, inOrderIndex + 1, inOrderEndingIndex);
        rootNode.left = build(postOrder, inOrder, inOderStartingIndex, inOrderIndex - 1);

        return rootNode;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] ip1 = br.readLine().trim().split("\\s+");
            String[] ip2 = br.readLine().trim().split("\\s+");
            int[] inOrder = new int[n];
            int[] postOrder = new int[n];

            for	(int i = 0; i < n; i++) {
                inOrder[i] = Integer.parseInt(ip1[i]);
                postOrder[i] = Integer.parseInt(ip2[i]);
            }

            TreeNode root = buildTree(postOrder, inOrder);
            printPreOrder(root);
            System.out.println();
        }
    }
    private static void printPreOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
