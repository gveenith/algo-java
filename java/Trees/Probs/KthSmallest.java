//package Probs;

public class KthSmallest {
    public static int COUNTER = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);

        int k = 3;
        System.out.println(helper(root, k, 0, 0));

    }

    public static int helper(TreeNode node, int k, int left, int right) {
        if (node == null)
            return 0;

        if (node.left != null) {
            left = helper(node.left, k, left, right);
        }

        COUNTER = COUNTER + 1;
        if (COUNTER == k) {
            return node.val;
        }

        if (node.right != null) {
            right = helper(node.right, k, left, right);
        }

        return Math.max(left, right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}