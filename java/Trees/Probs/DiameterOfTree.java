import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//543. Diameter of Binary Tree
// Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// Example:
// Given a binary tree
//           1
//          / \
//         3   2
//        /     \    
//       4       5
// Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

// Note: The length of path between two nodes is represented by the number of edges between them.
public class DiameterOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int[] diameter = new int[] { 0 };
        DiameterOfTreeHelper(root, diameter, 0, 0);

        Arrays.stream(diameter).forEach(System.out::println);

    }

    public static int DiameterOfTreeHelper(TreeNode node, int[] diameter, int leftDiameter, int rightDiameter) {

        // base
        if (node == null)
            return 0;

        // rec
        leftDiameter = DiameterOfTreeHelper(node.left, diameter, leftDiameter, rightDiameter);
        rightDiameter = DiameterOfTreeHelper(node.right, diameter, leftDiameter, rightDiameter);

        diameter[0] = Math.max(diameter[0], leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
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
