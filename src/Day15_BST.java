class TreeNode1 {
    int data;
    TreeNode1 left, right;

    // Constructor
    TreeNode1(int value) {
        data = value;
        left = null;
        right = null;
    }
}
public class Day15_BST {
    TreeNode root;  // root of the tree

    // Constructor: creates an empty tree
    public Day15_BST() {
        root = null;
    }

    // Insert method for empty tree or first insert
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            System.out.println("Inserted " + value + " as root node.");
        } else {
            insert(root, value);
        }
    }

    // Insert method when tree is not empty (recursive)
    private void insert(TreeNode current, int value) {
        if (value < current.data) {
            if (current.left == null) {
                current.left = new TreeNode(value);
                System.out.println("Inserted " + value + " to the left of " + current.data);
            } else {
                insert(current.left, value);
            }
        } else if (value > current.data) {
            if (current.right == null) {
                current.right = new TreeNode(value);
                System.out.println("Inserted " + value + " to the right of " + current.data);
            } else {
                insert(current.right, value);
            }
        } else {
            System.out.println("Value " + value + " already exists. Not inserted.");
        }
    }

    // ✅ Inorder Traversal Method (recursive)
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println(); // for newline after traversal
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);             // Visit left
            System.out.print(node.data + " ");       // Visit root
            inorderTraversal(node.right);            // Visit right
        }
    }

    // Main method to test the insertions and traversal
    public static void main(String[] args) {
        Day15_BST bst = new Day15_BST();

        // Insert some values into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(70); // Duplicate test

        // 🔍 Perform inorder traversal
        bst.inorderTraversal();
    }
}
