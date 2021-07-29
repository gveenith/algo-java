//package Probs;

public class MirrorBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // dfs postorder left and right
        TreeNode rootNode = helper(root);
        System.out.println(rootNode.data);
        System.out.println(rootNode.left.data);
        System.out.println(rootNode.right.data);
        System.out.println(rootNode.left.left.data);
        System.out.println(rootNode.left.right.data);
        System.out.println(rootNode.right.left.data);
        System.out.println(rootNode.right.right.data);
    }

    public static TreeNode helper(TreeNode node) {

        // base
        if (node == null)
            return null;
        TreeNode childNode = new TreeNode(node.data);
        // dfs postorder left and right
        if (node.left != null) {
            childNode.right = helper(node.left);
        }
        if (node.right != null) {
            childNode.left = helper(node.right);
        }

        return childNode;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
