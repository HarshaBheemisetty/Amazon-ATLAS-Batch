import java.util.*;
class TreeNode {
    int data;
    TreeNode left, right;

    // Constructor
    TreeNode(int value) {
        data = value;
        left = null;
        right = null;
    }
}

// BinarySearchTree class
public class Day15_BinaryTree {
    TreeNode root;

    // Constructor
    public Day15_BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);// if root is empty it will create a new node and assigns it to root
            System.out.println("Inserted " + value + " as root node.");
        } else {
            insert(root, value);
        }
    }

    // 2️⃣ Insert when tree is not empty
    private void insert(TreeNode node, int value) {
        if (value < node.data) {
            if (node.left == null) {
                node.left = new TreeNode(value);
                System.out.println("Inserted " + value + " to the left of " + node.data);
            } else {
                insert(node.left, value);
            }
        } else if (value > node.data) {
            if (node.right == null) {
                node.right = new TreeNode(value);
                System.out.println("Inserted " + value + " to the right of " + node.data);
            } else {
                insert(node.right, value);
            }
        } else {
            // Duplicate value
            System.out.println("Value " + value + " already exists in the tree.");
        }
    }

    // Main method to test insertion
    public static void main(String[] args) {
        Day15_BinaryTree bst = new Day15_BinaryTree();

        // Insert nodes
        bst.insert(50); // root
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(70); // Duplicate
    }
}
