import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int value) {
        data = value;
        left = right = null;
    }
}
public class Day18_CornerElements {

    // Function to print corner nodes at each level
    public static void printCornerElements(TreeNode root) {
        if (root == null)
            return; //If the tree is empty, nothing to print.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); //We use a Queue for level-order traversal. Add root node first.

        while (!queue.isEmpty()) { //Loop continues until all levels are visited.
            int size = queue.size(); //We need to know how many nodes are in the current level to identify first and last.

            // Traverse current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); //poll() removes and returns the front node.i tells us the position in the level

                // Print corner elements (first and last node of each level)
                if (i == 0 || i == size - 1) {
                    System.out.print(node.data + " ");
                }

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);//Add left and right children of the current node into the queue for the next level.

            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Corner elements of the tree:");
        printCornerElements(root);
    }
}
