import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphFromTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);
        root.left_ptr.left_ptr = new TreeNode(4);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.right_ptr.left_ptr = new TreeNode(6);
        root.right_ptr.right_ptr = new TreeNode(7);

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        helper(root, null, map);
        for (Map.Entry<Integer, List<TreeNode>> result : map.entrySet()) {
            System.out.print(result.getKey() + "  ->");
            List<TreeNode> res = result.getValue();
            res.forEach((x) -> System.out.print(x.val));
            System.out.println("");
        }
    }

    public static void helper(TreeNode node, TreeNode parent, Map<Integer, List<TreeNode>> map) {
        if (node != null) {
            map.put(node.val, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(parent.val).add(node);
                map.get(node.val).add(parent);
            }
            helper(node.left_ptr, node, map);
            helper(node.right_ptr, node, map);
        }
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