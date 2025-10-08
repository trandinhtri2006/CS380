import java.util.ArrayList;
import java.util.Stack;

/**
 * The {@code Node} class represents a node in a binary search tree.
 * Each node contains an integer value and references to its left and right child nodes.
 */
class Node {
    int value;
    Node left, right;

    /**
     * Constructs a new {@code Node} with the specified value.
     *
     * @param value the integer value stored in this node
     */
    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

/**
 * The {@code BinarySearchTree} class provides methods to create and manage a binary search tree (BST),
 * including insertion, traversal, search, and deletion operations.
 */
class BinarySearchTree {

    /** The root node of this binary search tree. */
    Node root;

    /**
     * Recursively inserts a new value into the tree.
     *
     * @param root  the root node of the current subtree
     * @param value the integer value to insert
     * @return the updated root node of the subtree
     */
    public Node insert(Node root, int value) {
        // base case
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // recursive step
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    /**
     * Inserts a value into the BST (public wrapper for recursive insert).
     *
     * @param value the integer value to insert
     * @return the updated root of the BST
     */
    public Node insert(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    /**
     * Performs a pre-order traversal of the tree (root-left-right)
     * and prints node values to the console.
     *
     * @param root the root node of the subtree to traverse
     */
    public void preOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("EMPTY ROOT");
            return;
        }

        System.out.print(root.value + "-");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * Performs an in-order traversal of the tree (left-root-right)
     * and prints node values to the console.
     *
     * @param root the root node of the subtree to traverse
     */
    public void inOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("EMPTY ROOT");
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.value + "-");
        inOrderTraversal(root.right);
    }

    /**
     * Performs a post-order traversal of the tree (left-right-root)
     * and prints node values to the console.
     *
     * @param root the root node of the subtree to traverse
     */
    public void postOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("EMPTY ROOT");
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + "-");
    }

    /**
     * Searches the tree for a node containing a specific key.
     *
     * @param root the root node of the current subtree
     * @param key  the value to search for
     * @return {@code true} if the key exists in the tree; {@code false} otherwise
     */
    public boolean find(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        return find(root.left, key) || find(root.right, key);
    }

    /**
     * Finds the node with the smallest key (leftmost node) in the tree.
     *
     * @param root the root node of the subtree
     * @return the smallest key in the tree
     */
    public int getMin(Node root) {
        if (root == null) {
            System.out.println("EMPTY ROOT");
            return Integer.MIN_VALUE;
        }

        if (root.left == null) {
            return root.value;
        }

        return getMin(root.left);
    }

    /**
     * Finds the node with the largest key (rightmost node) in the tree.
     *
     * @param root the root node of the subtree
     * @return the largest key in the tree
     */
    public int getMax(Node root) {
        if (root == null) {
            System.out.println("EMPTY ROOT");
            return Integer.MAX_VALUE;
        }

        if (root.right == null) {
            return root.value;
        }

        return getMax(root.right);
    }

    /**
     * Deletes a node with the specified key from the BST.
     *
     * <p>There are three cases to handle:
     * <ul>
     *   <li>Case 1: Node is a leaf (no children)</li>
     *   <li>Case 2: Node has one child</li>
     *   <li>Case 3: Node has two children (replace with in-order predecessor)</li>
     * </ul>
     *
     * @param root the root node of the subtree
     * @param key  the value to delete
     * @return the updated root node of the subtree
     */
    public Node delete(Node root, int key) {
        if (root == null) {
            return root;
        } else if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // Node has been found
            if (root.left == null && root.right == null) {
                // Case 1: Leaf node
                root = null;
            } else if (root.right == null) {
                // Case 2: Only left child
                root = root.left;
            } else if (root.left == null) {
                // Case 2: Only right child
                root = root.right;
            } else {
                // Case 3: Two children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }
}

/**
 * The {@code TreeDemo} class demonstrates usage of the {@link BinarySearchTree}
 * class, including insertion, traversal, and search operations.
 */
public class TreeDemo {
    /**
     * The main entry point of the program. Demonstrates basic BST operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();

        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);
        t1.insert(0);

        System.out.print("in-order: ");
        t1.inOrderTraversal(t1.root);
        System.out.println();

        System.out.print("post-order: ");
        t1.postOrderTraversal(t1.root);
        System.out.println();

        System.out.print("find 22: ");
        System.out.println(t1.find(t1.root, 22));

        System.out.print("getMin: ");
        System.out.println(t1.getMin(t1.root));

        System.out.print("getMax: ");
        System.out.println(t1.getMax(t1.root));
        System.out.println();
    }
}
