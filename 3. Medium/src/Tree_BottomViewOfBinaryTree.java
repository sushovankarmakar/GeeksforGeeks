import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/
// https://www.youtube.com/watch?v=V7alrvgS5AI (BEST Video tutorial)
// https://www.geeksforgeeks.org/bottom-view-binary-tree/
// https://ide.geeksforgeeks.org/09vfuzfZN1
// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1 (Similar question)
// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1/ (Similar question)

public class Tree_BottomViewOfBinaryTree {

    static class Pair {
        private TreeNode node;
        private int horizontalDistance;

        Pair(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    /* level order traversal is applied here
     * This below code is very similar to vertical order traversal
     * In bottom view, we only take the last node of each list of nodes */

    private static List<Integer> getBottomView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;

        Map<Integer, Integer> treeMap = new TreeMap<>();	/* TreeMap is sorted according to the natural ordering of its keys */

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize-- > 0) {

                Pair pair = queue.poll();
                TreeNode currNode = pair.node;
                int horizontalDistance = pair.horizontalDistance;

                if (treeMap.containsKey(horizontalDistance)) {
                    treeMap.replace(horizontalDistance, currNode.data);
                } else {
                    treeMap.put(horizontalDistance, currNode.data);
                }

                if (currNode.left  != null) queue.add(new Pair(currNode.left,  horizontalDistance - 1));
                if (currNode.right != null) queue.add(new Pair(currNode.right, horizontalDistance + 1));
            }
        }

        output.addAll(treeMap.values());
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            TreeNode root = buildTree(s);
            List<Integer> output = getBottomView(root);
            printTree(output);
        }
    }

    private static void printTree(List<Integer> output) {
        StringBuilder sb = new StringBuilder();
        for (int value : output) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
        sb.setLength(0);
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

            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);

            }
            i++;

            if (i >= ip.length) break;

            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
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
