import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left, right;

    TreeNode2(int x) {
        val = x;
    }
}
public class Day18_RightSideView {

    public List<Integer> rightSideView(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);//This sets up a queue for level-order traversal (BFS).We add the root to begin.

        while (!queue.isEmpty()) {
            int levelSize = queue.size();//This gets the number of nodes at the current level.
            // For each level
            for (int i = 0; i < levelSize; i++) {
                TreeNode2 node = queue.poll();// Loop through all nodes at this level, queue.poll() removes and returns the front node of the queue.

                // If it's the last node in this level → add to result
                if (i == levelSize - 1)
                    result.add(node.val);//Only the last node at the level is visible from the right. So, if i == levelSize - 1, add node.val to the result.

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);//Add the node’s children to the queue for the next level. We always add left first, then right
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Build tree from [1,2,3,4,null,null,null,5]
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.left.left = new TreeNode2(5);

        Day18_RightSideView rsv = new Day18_RightSideView();
        System.out.println("Right Side View: " + rsv.rightSideView(root));
    }
}
