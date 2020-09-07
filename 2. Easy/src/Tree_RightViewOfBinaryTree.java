import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
// https://leetcode.com/problems/binary-tree-right-side-view/
// https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
// https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1 (Similar question)

public class Tree_RightViewOfBinaryTree {

    /* same logic with level by level traversal with printing only the first node of every level */

    /* NON-RECURSIVE */
    private static List<Integer> getRightViewNonRecursive(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        if (root == null) return values;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            boolean isFirstNodeFromRightSide = true;
            int sizeOfQueue = queue.size();
            if (sizeOfQueue == 0) break;

            while (sizeOfQueue > 0) {
                TreeNode currNode = queue.poll();

                if (isFirstNodeFromRightSide) {
                    values.add(currNode.data);
                    isFirstNodeFromRightSide = false;
                }

                if (currNode != null && currNode.right != null) queue.add(currNode.right);
                if (currNode != null && currNode.left  != null) queue.add(currNode.left);

                sizeOfQueue--;
            }
        }
        return values;
    }

    /* RECURSIVE */
    private static int maxLevelSeenSoFar = 0;
    private static List<Integer> getRightViewRecursive(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        getRightViewRecursiveUtil(root, 1, values);
        maxLevelSeenSoFar = 0;
        return values;
    }

    private static void getRightViewRecursiveUtil(TreeNode root, int currLevel, List<Integer> values) {
        if (root == null) return;

        if (maxLevelSeenSoFar < currLevel) {
            values.add(root.data);
            maxLevelSeenSoFar = currLevel;
        }

        getRightViewRecursiveUtil(root.right, currLevel + 1, values);
        getRightViewRecursiveUtil(root.left, currLevel + 1, values);

        /* if we traverse the left side child first then we will get left view of the tree. */
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String input = br.readLine().trim();
            TreeNode root = buildTree(input);

            System.out.println("Non recursive ");
            List<Integer> output1 = getRightViewNonRecursive(root); /* non recursive call*/
            print(output1);

            System.out.println("Recursive ");
            List<Integer> output2 = getRightViewRecursive(root);    /* recursive call */
            print(output2);
        }
    }

    private static void print(List<Integer> output) {
        StringBuilder sb = new StringBuilder();
        for (int value : output) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
        sb.append(0);
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
            String currData = ip[i];

            if (!currData.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currData));
                queue.add(currNode.left);
            }
            i++;

            if (i >= ip.length) break;

            currData = ip[i];
            if (!currData.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currData));
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
