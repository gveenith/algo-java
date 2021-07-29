package Probs;

public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left_ptr = new TreeNode(300);
        root.right_ptr = new TreeNode(500);
        root.left_ptr.left_ptr = new TreeNode(200);
        root.left_ptr.right_ptr = new TreeNode(400);
        root.right_ptr.left_ptr = new TreeNode(600);
        root.right_ptr.right_ptr = new TreeNode(700);

        Result result = findLargestBSTHelper(root);
        
        System.out.println(result.count);
    }

    static Result findLargestBSTHelper(TreeNode node) {

        // edge
        if (node == null) {
            return new Result();
        }

        // dfs postorder rec
        Result leftChild = findLargestBSTHelper(node.left_ptr);
        Result rightChild = findLargestBSTHelper(node.right_ptr);

        Result res = new Result();

        // check the result to determine if its bst
        res.isBST = leftChild.isBST && rightChild.isBST && node.val >= leftChild.max && node.val <= rightChild.min;
        res.min = Math.min(node.val, Math.min(leftChild.min, rightChild.min));
        res.max = Math.max(node.val, Math.max(leftChild.max, rightChild.max));

        if (res.isBST) {
            res.count = leftChild.count + rightChild.count + 1;
        } else if (leftChild.count > rightChild.count) {
            res.count = leftChild.count;
        } else {
            res.count = rightChild.count;
        }
        return res;

    }

}


class Result {
    int count;
    boolean isBST;
    int min;
    int max;

    Result() {
        this.count = 0;
        this.isBST = true;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

}

class TreeNode {
    int val;
    TreeNode left_ptr;
    TreeNode right_ptr;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left_ptr, TreeNode right_ptr) {
        this.val = val;
        this.left_ptr = left_ptr;
        this.right_ptr = right_ptr;
    }
}
