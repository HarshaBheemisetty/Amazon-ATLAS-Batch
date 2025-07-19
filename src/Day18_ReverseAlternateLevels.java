class TreeNode1 {
    int data;
    TreeNode1 left, right;

    TreeNode1(int value) {
        data = value;
        left = right = null;
    }
}

public class Day18_ReverseAlternateLevels {

    // Function to reverse alternate levels
    public static void reverseAlternateLevels(TreeNode1 root) {
        if (root == null) return;
        reverseUtil(root.left, root.right, 1);
    }

    // Helper function to reverse nodes at alternate levels
    private static void reverseUtil(TreeNode1 left, TreeNode1 right, int level) {
        if (left == null || right == null)
            return;

        // If the level is odd, swap the values
        if (level % 2 == 1) {
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }

        // Recursive calls for mirror nodes
        reverseUtil(left.left, right.right, level + 1);
        reverseUtil(left.right, right.left, level + 1);
    }

    // In-order traversal for testing
    public static void printInOrder(TreeNode1 root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Constructing a perfect binary tree of 4 levels
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);

        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        root.left.left.left = new TreeNode1(8);
        root.left.left.right = new TreeNode1(9);
        root.left.right.left = new TreeNode1(10);
        root.left.right.right = new TreeNode1(11);

        root.right.left.left = new TreeNode1(12);
        root.right.left.right = new TreeNode1(13);
        root.right.right.left = new TreeNode1(14);
        root.right.right.right = new TreeNode1(15);

        System.out.println("In-order before reversing alternate levels:");
        printInOrder(root);
        System.out.println();

        reverseAlternateLevels(root);  // Perform the reversal

        System.out.println("In-order after reversing alternate levels:");
        printInOrder(root);
        System.out.println();
    }
}
