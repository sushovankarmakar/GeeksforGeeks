import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
// https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/ (Followed this O(n) solution)
// https://www.youtube.com/watch?v=rm2WE0MCJ6k (A good explanation)
// https://www.youtube.com/watch?v=9bCqmaIY2as (Only the explanation is good)
// https://github.com/sushovankarmakar/GeeksforGeeks/blob/master/1.%20Basic/src/Tree_HeightOfBinaryTree.java (Similar Problem)

// SPECIAL CASE :
// Input  : 1 4 5 N N 12 7 N 25 N 8 30 N N 12 N N N 9 N N
// Output : 8 (not 7)

// time complexity : O(n), space complexity : O(h*h)

public class Tree_DiameterOfBinaryTree {

    private static int maxDiameter = Integer.MIN_VALUE;

    private static class Pair {     // Pair class is need to keep the height and diameter value at each node
        int height;
        int diameter;
        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    private static int getDiameterOfBinaryTree(TreeNode root) { // O(n)
        if(root == null) return 0;
        getPair(root);

        int diameter = maxDiameter;
        maxDiameter = Integer.MIN_VALUE;    // re-setting the static value

        return diameter;
    }

    private static Pair getPair(TreeNode root) {    // O(n)
        if(root == null) return new Pair(0,0);  // if root is null, height is 0, diameter is 0

        int leftHeight = getPair(root.left).height;
        int rightHeight = getPair(root.right).height;

        int currentHeight = Math.max(leftHeight, rightHeight) + 1;
        int currentDiameter = leftHeight + rightHeight + 1;

        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return new Pair(currentHeight, currentDiameter);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t -- > 0) {
            String[] str = br.readLine().trim().split("\\s+");
            TreeNode root = buildTree(str);
            printTheTree(root);
            System.out.println();
            System.out.println(getDiameterOfBinaryTree(root));
        }
    }

    private static TreeNode buildTree(String[] str) {
        if(str == null || str.length == 0 || str[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < str.length) {
            TreeNode currNode = queue.poll();

            String currVal = str[i];

            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));;
                queue.add(currNode.left);
            }
            i++;

            if(i >= str.length) break;

            currVal = str[i];

            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    private static void printTheTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.value + " ");
        printTheTree(root.left);
        printTheTree(root.right);
    }

    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
