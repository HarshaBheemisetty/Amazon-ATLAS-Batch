// Node class: represents each node in the BST
class TreeNode3 {
    int data;
    TreeNode3 left, right;

    // Constructor
    TreeNode3(int value) {
        data = value;
        left = null;
        right = null;
    }
}

// BinarySearchTree class: handles insert, inorder, and search
class Day15_BSTSearch {
    TreeNode root;

    // Constructor
    public Day15_BSTSearch() {
        root = null;
    }

    // Insert method (handles root and delegates)
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            System.out.println("Inserted " + value + " as root node.");
        } else {
            insert(root, value);
        }
    }

    // Recursive insert
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

    // Inorder traversal (left, root, right)
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    // Search method (returns true/false)
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(TreeNode node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.data) {
            return true;
        } else if (key < node.data) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        Day15_BSTSearch bst = new Day15_BSTSearch();

        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(70); // Duplicate test

        // Traversal
        bst.inorderTraversal();

        // Search
        System.out.println("Search for 30: " + bst.search(30)); // true
        System.out.println("Search for 25: " + bst.search(25)); // false
    }
}
