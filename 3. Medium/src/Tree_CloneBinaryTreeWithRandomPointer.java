import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1
// https://www.youtube.com/watch?v=zbnAHuJGMEg
// https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/ (BEST Explanation <- I followed this)

public class Tree_CloneBinaryTreeWithRandomPointer {

    /*--- START OF SOLUTION ---*/

    public static TreeNode cloneTree(TreeNode actualRoot) {
        if (actualRoot == null) return null;

        TreeNode clonedRoot = cloneLeftRightNode(actualRoot);
        copyRandomNode(actualRoot, clonedRoot);
        restoreTreeLeftNode(actualRoot, clonedRoot);

        return clonedRoot;
    }

    /* This function creates new nodes cloned tree and puts new cloned node in between current node and it's left child
    i.e. if current node is A and it's left child is B ( A --- >> B ), then new cloned node with key A wil be created (say cA) and
      it will be put as
      A --- >> cA --- >> B
    Here B can be a NULL or a non-NULL left child.

    Right child pointer will be set correctly i.e. if for current node A, right child is C in original tree
    (A --- >> C) then corresponding cloned nodes cA and cC will like cA ---- >> cC
    */

    private static TreeNode cloneLeftRightNode(TreeNode actualRoot) {

        if (actualRoot == null) return null;

        TreeNode actualLeft = actualRoot.left;  // storing the actual root
        actualRoot.left = new TreeNode(actualRoot.data); // creating a clone node and make it left node of actual node
        actualRoot.left.left = actualLeft;    // store the actual left node int the clone node's left node

        if (actualLeft != null) {
            actualLeft.left = cloneLeftRightNode(actualLeft);
        }
        actualRoot.left.right = cloneLeftRightNode(actualRoot.right);

        return actualRoot.left;
    }

    /* This function sets random pointer in cloned tree as per original tree i.e. if node A's random pointer points to node B, then
    in cloned tree, cA wil point to cB (cA and cB are new node in cloned tree corresponding to node A and B in original tree)  */

    private static void copyRandomNode(TreeNode actualRoot, TreeNode clonedRoot) {
        if (actualRoot == null || clonedRoot == null) return;

        // set the random pointer of clonedRoot
        if (actualRoot.random != null) {
            clonedRoot.random = actualRoot.random.left;
        }
        else {
            clonedRoot.random = null;
        }

        // now explore left and right side of current node
        if (actualRoot.left != null && clonedRoot.left != null) {
            copyRandomNode(actualRoot.left.left, clonedRoot.left.left);
        }
        copyRandomNode(actualRoot.right, clonedRoot.right);
    }

    /* This function will restore left pointers correctly in both original and cloned tree */
    private static void restoreTreeLeftNode(TreeNode actualRoot, TreeNode clonedRoot) {
        if (actualRoot == null || clonedRoot == null) return;

        if (clonedRoot.left != null) {

            TreeNode clonedLeft = clonedRoot.left.left;
            TreeNode actualLeft = actualRoot.left.left;

            clonedRoot.left = clonedLeft;
            actualRoot.left = actualLeft;
        }
        else {
            actualRoot.left = null;
        }

        restoreTreeLeftNode(actualRoot.left, clonedRoot.left);
        restoreTreeLeftNode(actualRoot.right, clonedRoot.right);
    }

    /*--- END OF SOLUTION ---*/

    /* above 4 functions are part of the solution of cloning a tree
    * below functions I copied from the GFG page, which are creating the actual tree with random pointers and
    * are not part of the solution */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int n, n1, n2;
        char lr;
        TreeNode root;

        while (q-- > 0) {
            n = sc.nextInt();
            root = null;
            while (n-- >0) {
                n1 = sc.nextInt();
                n2 = sc.nextInt();
                lr = sc.next().charAt(0);

                if (root == null) {
                    root = new TreeNode(n1);
                    switch (lr) {
                        case 'L':
                            root.left = new TreeNode(n2);
                            break;
                        case 'R':
                            root.right = new TreeNode(n2);
                            break;
                    }
                }
                else{
                    if(lr=='X')
                        clone(root, root, n1, n2);
                    else
                        insert(root, n1, n2, lr);
                }
            }
            try {
                TreeNode z = cloneTree(root);
                if (z == root)
                    System.out.println("0");
                else
                    System.out.println(printInorder(root, z));
            }
            catch(ClassCastException ex){}
        }
    }

    public static int printInorder(TreeNode a, TreeNode b) {
        if (((a==null) && (b==null)) || ((a.random==null) && (b.random==null)))
            return 1;
        if(a.random.data == b.random.data)
            if(printInorder(a.left,b.left)==1)
                if(printInorder(a.right,b.right)==1)
                    return 1;
        return 0;

    }

    public static void clone(TreeNode root, TreeNode proof, int n1, int n2) {
        try{
            if (root == null && proof == null) return;
            if (n1 == root.data) {
                if(proof.data == n2)
                    root.random=proof;
                else{
                    clone(root, proof.left, n1, n2);
                    clone(root, proof.right, n1, n2);
                }
            }
            else{
                clone(root.left, proof, n1, n2);
                clone(root.right, proof, n1, n2);
            }
        }
        catch (NullPointerException ex) {}
    }

    public static void insert(TreeNode root, int n1, int n2, char lr) {
        if (root == null)
            return;
        if (n1 == root.data) {
            switch (lr) {
                case 'L':
                    root.left = new TreeNode(n2);
                    break;
                case 'R':
                    root.right = new TreeNode(n2);
                    break;
            }
        }
        else {
            insert(root.left,n1,n2,lr);
            insert(root.right,n1,n2,lr);
        }
    }

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        private TreeNode random;

        TreeNode (int d) {
            data = d;
            left = null;
            right = null;
            random = null;
        }
    }
}
