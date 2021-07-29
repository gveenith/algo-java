package Probs;

public class univalueSubTree {

    public static void main(String[] args) {
        TreeNodes root = new TreeNodes(2);
        root.left = new TreeNodes(2);
        root.right = new TreeNodes(2);
        root.left.left = new TreeNodes(2);
        root.left.right = new TreeNodes(2);
        root.right.left = new TreeNodes(4);
        root.right.right = new TreeNodes(2);
        System.out.println(isUnivalTreePreOrderHelper(root));
        System.out.println(isUnivalTreePreOrderRefactorHelper(root));
        System.out.println(isUnivalTreeInOrderHelper(root));
        int[] result = new int[] { 0 };

        int[] result1 = new int[] {};
        univalTreeCountSubtreeHelper(root, result);
        univalTreeCountpreorderSubtreeHelper(root, result1);
        System.out.println(result[0]);
    }

    public static boolean isUnivalTreePreOrderHelper(TreeNodes root) {

        if (root == null)
            return true;

        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val)
            return false;

        return isUnivalTreePreOrderHelper(root.left) && isUnivalTreePreOrderHelper(root.right);

    }

    public static boolean isUnivalTreePreOrderRefactorHelper(TreeNodes root) {

        boolean left = root.left == null || root.val == root.left.val && isUnivalTreePreOrderRefactorHelper(root.left);
        boolean right = root.right == null
                || root.val == root.right.val && isUnivalTreePreOrderRefactorHelper(root.right);

        return left && right;

    }

    public static boolean isUnivalTreeInOrderHelper(TreeNodes node) {
        if (node == null)
            return true;

        boolean left = isUnivalTreeInOrderHelper(node.left);
        if (node.left != null && node.val != node.left.val) {
            return false;
        }
        if (node.right != null && node.val != node.right.val) {
            return false;
        }
        boolean right = isUnivalTreeInOrderHelper(node.right);

        return left && right;

    }

    public static boolean univalTreeCountSubtreeHelper(TreeNodes node, int[] result) {
        if (node == null)
            return true;

        boolean left = univalTreeCountSubtreeHelper(node.left, result);
        boolean right = univalTreeCountSubtreeHelper(node.right, result);

        if ((node.left == null || left && node.val == node.left.val)
                && (node.right == null || right && node.val == node.right.val)) {
            result[0] = result[0] + 1;
            return true;
        } else {
            return false;
        }
    }

    public static boolean univalTreeCountpreorderSubtreeHelper(TreeNodes node, int[] result) {
        if (node == null)
            return true;

        if ((node.left == null || left && node.val == node.left.val)
                && (node.right == null || right && node.val == node.right.val)) {
            result[0] = result[0] + 1;
            return true;
        } else {
            return false;
        }

        boolean left = univalTreeCountpreorderSubtreeHelper(node.left, result);
        boolean right = univalTreeCountpreorderSubtreeHelper(node.right, result);

    }

}

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes() {
    }

    TreeNodes(int val) {
        this.val = val;
    }

    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
