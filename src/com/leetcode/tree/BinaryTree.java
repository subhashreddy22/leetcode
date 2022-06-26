package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree
 *
 *
 *         1
 *        / \
 *       2   3
 *      / \   \
 *     4   5   6
 *
 *     PreOrder, InOrder, PostOrder -> DFS -> Time Complexity - O(n)
 *     LevelOrder -> BFS
 *
 *     Ref: https://www.youtube.com/watch?v=-DzowlcaUmE
 */
public class BinaryTree {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTreeFromPreOrderSequence(nodes);
        System.out.println(root.data);
        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();
        System.out.println("InOrder");
        inOrder(root);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(root);
        System.out.println();
        System.out.println("LevelOrder");
        levelOrder(root);

        System.out.println("Count of Nodes -> " + countOfNodes(root));
        System.out.println("Sum of Nodes -> " + sumOfNodes(root));
        System.out.println("Height of Tree -> " + height(root));

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("Is Sub Tree -> " + isSubTree(root, subRoot));

        Node LCA = lowestCommonAncestor(root, new Node(5), new Node(4));
        System.out.println("Lowest Common Ancestor -> " + LCA.data);
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

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // adding null which is used as a reference to print next line

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodesCount = countOfNodes(root.left);
        int rightNodesCount = countOfNodes(root.right);

        return leftNodesCount + rightNodesCount + 1; // adding 1 for root node count
    }

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodesSum = sumOfNodes(root.left);
        int rightNodesSum = sumOfNodes(root.right);

        return leftNodesSum + rightNodesSum + root.data;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isSubTree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    static Node lowestCommonAncestor(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        Node leftLCA = lowestCommonAncestor(root.left, n1, n2);
        Node rightLCA = lowestCommonAncestor(root.right, n1, n2);

        if (leftLCA == null) {
            return rightLCA;
        }

        if (rightLCA == null) {
            return leftLCA;
        }

        return root;
    }
}
