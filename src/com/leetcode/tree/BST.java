package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * InOrder Traversal will print the elements in sorted order
 *
 * Time Complexity of Search - Worst is O(n). In general it is O(h), h is height of BST
 */
public class BST {

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println(root.data);

        System.out.println("InOrder Traversal");
        inOrder(root);
        System.out.println();

        System.out.println("Search of 3 in BST -> " + search(root, 3));

        printInRange(root, 1, 4);
        System.out.println();

        printRootToLeaf(root, new ArrayList<>());
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (root.data > data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        } else if (root.data < x) {
            printInRange(root.right, x, y);
        } else {
            printInRange(root.left, x, y);
        }
    }

    static void printRootToLeaf(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }
}
