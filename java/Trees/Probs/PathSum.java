// 112. Path Sum
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \      \
// 7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

public class PathSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.right = new Node(1);

        int sum = 22;

        if (root == null) {
            System.out.print(false);
        } else {
            System.out.print(PathSumHelper(root, sum));
        }

    }

    public static boolean PathSumHelper(Node node, int sum) {

        // base - calc sum , check isleaf and return
        sum = sum - node.data;
        if (isLeaf(node))
            return sum == 0;
        // rec
        return PathSumHelper(node.left, sum) || PathSumHelper(node.right, sum);

    }

    public static boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
    }
}

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}