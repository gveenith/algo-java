import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// package Probs;

public class ConstructBST {
    public static void main(String[] args) {
        List<Integer> inorder = new ArrayList<Integer>();
        inorder.add(3);
        inorder.add(2);
        inorder.add(1);
        inorder.add(5);
        inorder.add(4);
        inorder.add(6);
        List<Integer> preorder = new ArrayList<Integer>();
        preorder.add(1);
        preorder.add(2);
        preorder.add(3);
        preorder.add(4);
        preorder.add(5);
        preorder.add(6);

        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= inorder.size() - 1; i++) {
            inorderMap.put(inorder.get(i), i);
        }

        TreeNode res = helper(inorder, preorder, 0, inorder.size() - 1, 0, inorderMap);
        printPreOrder(res);

    }

    public static TreeNode helper(List<Integer> inorder, List<Integer> preorder, int start, int end, int preOrderIndex,
            Map<Integer, Integer> inorderMap) {
        // base
        if (preOrderIndex > preorder.size() - 1 || start > end)
            return null;

        TreeNode node = new TreeNode(preorder.get(preOrderIndex));
        if (start == end)
            return node;
        int index = inorderMap.get(node.value);

        // rec dfs
        node.left = helper(inorder, preorder, start, index - 1, preOrderIndex + 1, inorderMap);
        node.right = helper(inorder, preorder, index + 1, end, preOrderIndex + index - start + 1, inorderMap);

        return node;
    }

    public static void printPreOrder(TreeNode root) {

        if (root == null) {
            System.out.print("#");
            return;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while (!st.empty()) {

            TreeNode node = st.peek();
            if (node == null) {
                System.out.print("#");
                st.pop();
                continue;
            }
            System.out.print(node.value);
            st.pop();

            if (node.right != null) {
                st.push(node.right);
            } else {
                st.push(null);
            }
            if (node.left != null) {
                st.push(node.left);
            } else {
                st.push(null);
            }
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        value = x;
        left = null;
        right = null;
    }
}
