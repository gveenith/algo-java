package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(1);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<Integer> result = new ArrayList<>();
        DFSHelper(root, result);
        result.forEach(System.out::println);
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root, result);

    }

    public static void DFSHelper(Node root, List<Integer> result) {
        // base
        if (root == null)
            return;

        result.add(root.data);
        // rec
        DFSHelper(root.left, result);
        DFSHelper(root.right, result);
    }

    public static void preorderTraversal(Node root, List<Integer> result) {

        Stack<Node> stack = new Stack<Node>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.data);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
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
