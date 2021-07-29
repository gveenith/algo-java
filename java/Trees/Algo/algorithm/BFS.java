package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BFS {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.left = new Node(12);
        root.left.right = new Node(1);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> rightSideViewResult = new LinkedList<>();
        bfsTraversal(root, result, rightSideViewResult);
        rightSideViewResult.forEach(System.out::println);
        // result.forEach(System.out::println);

    }

    public static void bfsTraversal(Node root, List<List<Integer>> result, List<Integer> rightSideViewResult) {

        // edge case - root being null - return
        if (root == null) {
            return;
        }

        // first take root node and add it into queue.
        Queue<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(root);

        // till queue is not empty
        // remove the root node and push its children into queue
        // repeat this for all nodes
        while (!bfsQueue.isEmpty()) {

            List<Integer> levelOrderList = new ArrayList<>();

            int bfsQueueLength = bfsQueue.size();
            for (int i = 0; i < bfsQueueLength; i++) {

                Node node = bfsQueue.remove();
                levelOrderList.add(node.data);
                // System.out.print(" " + node.data);

                if (node.left != null) {
                    bfsQueue.add(node.left);
                }

                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
            }

            // Collections.reverse(levelOrderList);
            levelOrderList.forEach(System.out::println);
            System.out.println(levelOrderList.get(levelOrderList.size() - 1));
            rightSideViewResult.add(levelOrderList.get(levelOrderList.size() - 1));
            result.add(levelOrderList);

        }

    }
}
