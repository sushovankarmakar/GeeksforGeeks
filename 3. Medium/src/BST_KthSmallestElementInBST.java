import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
// https://www.youtube.com/watch?v=C6r1fDKAW_o (Good video explanation)

public class BST_KthSmallestElementInBST {

    // time complexity : O(N), space complexity : O(N)
    /*public static int kthSmallestElement(Node root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return (k > list.size()) ? -1 : list.get(k-1);
    }

    private static void inOrderTraversal(Node root, List<Integer> list) {
        if(root == null) return;

        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);
    }*/

    // time complexity : O(H + k), space complexity : O(H + k)  where H is height of tree
    public static int kthSmallestElement(Node root, int k) {
        int[] nums = new int[2];    // nums[0] stores the kth position and nums[1] stores the kth value
        nums[1] = Integer.MIN_VALUE;
        inOrderTraversal(root, nums, k);
        return nums[1] == Integer.MIN_VALUE ? -1 : nums[1];
    }

    private static void inOrderTraversal(Node root, int[] nums, int k) {
        if(root == null) return;

        inOrderTraversal(root.left, nums, k);
        if(++nums[0] == k) {
            nums[1] = root.data;
            return;
        }
        inOrderTraversal(root.right, nums, k);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            String ip = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Node root = buildTree(ip);
            System.out.println(kthSmallestElement(root, k));
        }
    }

    private static Node buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N') {
            return null;
        }
        String[] ip = str.split("\\s+");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty() && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("N")) {
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

    private static class Node {
        private int data;
        private Node left;
        private Node right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
