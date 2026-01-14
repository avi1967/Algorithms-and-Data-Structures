// Data Structure: Binary Search Tree (BST)
// Time Complexity:
//   - Search / Insert / Delete: O(h)
//     where h is the height of the tree (O(log n) average, O(n) worst)
// Space Complexity: O(h) recursion stack
// Key Idea: Maintain ordered structure where left < node < right
//
// Correctness Invariant:
// - For every node, all keys in the left subtree are smaller,
//   and all keys in the right subtree are larger.

package data_structures;

public class BinarySearchTree {

    // Node of the BST
    static class Node {
        String key;
        String value;
        Node left, right;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a key-value pair into the BST.
     */
    public void insert(String key, String value) {
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node node, String key, String value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareToIgnoreCase(node.key);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            // Key already exists: update value
            node.value = value;
        }
        return node;
    }

    /**
     * Searches for a key in the BST.
     *
     * @return associated value, or null if not found
     */
    public String search(String key) {
        Node node = searchRecursive(root, key);
        return (node == null) ? null : node.value;
    }

    private Node searchRecursive(Node node, String key) {
        if (node == null) return null;

        int cmp = key.compareToIgnoreCase(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return searchRecursive(node.left, key);
        return searchRecursive(node.right, key);
    }

    /**
     * Deletes a key from the BST.
     */
    public void delete(String key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node node, String key) {
        if (node == null) return null;

        int cmp = key.compareToIgnoreCase(node.key);
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Case 1: No children
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2: One child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Case 3: Two children
            Node successor = findMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = deleteRecursive(node.right, successor.key);
        }
        return node;
    }

    /**
     * Finds the minimum key in a subtree.
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * In-order traversal of the BST.
     * Returns keys in sorted order.
     */
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node node) {
        if (node == null) return;
        inorderRecursive(node.left);
        System.out.println(node.key + " : " + node.value);
        inorderRecursive(node.right);
    }
}
