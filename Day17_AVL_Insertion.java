class Node15 {
    int key, height;
    Node15 left, right;

    Node15(int d) {
        key = d;
        height = 1;  // New node is initially added at leaf
    }
}
public class Day17_AVL_Insertion
{
    Node15 root;
    int height(Node15 N)
    {
        if (N == null) return 0;
        return N.height;
    }
    // Get max of two numbers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    // Right rotate
    Node15 rightRotate(Node15 y) {
        Node15 x = y.left;
        Node15 T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
    Node15 leftRotate(Node15 x) {
        Node15 y = x.right;
        Node15 T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
    // Get Balance factor
    int getBalance(Node15 N)
    {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }
    Node15 insert(Node15 node, int key) {
        // 1. Perform normal BST insertion
        if (node == null)
            return new Node15(key);

        if (key < node.key)
            node.left = insert(node.left, key); // if key is less than current node insert at left subtree.
        else if (key > node.key)
            node.right = insert(node.right, key);// if key is greater than current node insert at right subtree.
        else  // Duplicate keys not allowed
            return node;

        // 2. Update height
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Balance the tree if unbalanced

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal
    void inorder(Node15 node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Day17_AVL_Insertion tree = new Day17_AVL_Insertion();

        int[] Values = {10, 20, 50, 40, 30, 25};

        for (int key : Values) {
            tree.root = tree.insert(tree.root, key);
        }

        System.out.println("Inorder traversal of AVL tree:");
        tree.inorder(tree.root);
    }
}


