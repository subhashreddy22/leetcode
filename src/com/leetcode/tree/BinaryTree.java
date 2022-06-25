package com.leetcode.tree;

/**
 * Tree
 *
 *
 *         1
 *        / \
 *       2   3
 *      / \   \
 *     4   5   6
 */
public class BinaryTree {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTreeFromPreOrderSequence(nodes);
        System.out.println(root.data);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    static int index = -1;

    static Node buildTreeFromPreOrderSequence(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildTreeFromPreOrderSequence(nodes);
        newNode.right = buildTreeFromPreOrderSequence(nodes);

        return newNode;
    }

    /**
     * Pre Order Sequence -> Root, LeftSubtree, Right Subtree
     *
     */
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * In Order Sequence -> LeftSubtree, Root, Right Subtree
     *
     */
    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * Post Order Sequence -> LeftSubtree, Right Subtree, Root
     *
     */
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
