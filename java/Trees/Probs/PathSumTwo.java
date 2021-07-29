// 113. Path Sum II
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// Return:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        int sum = 22;

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        PathSumTwoHelper(root, sum, path, result);
        result.forEach(System.out::println);
    }

    public static void PathSumTwoHelper(Node node, int sum, List<Integer> path, List<List<Integer>> result) {
        // edge
        if (node == null)
            return;
        // base
        path.add(node.data);
        if (isLeaf(node) && sum == node.data) {
            result.add(new ArrayList<>(path));
        }
        // rec
        if (node.left != null) {
            PathSumTwoHelper(node.left, sum - node.data, path, result);
        }

        if (node.right != null) {
            PathSumTwoHelper(node.right, sum - node.data, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
