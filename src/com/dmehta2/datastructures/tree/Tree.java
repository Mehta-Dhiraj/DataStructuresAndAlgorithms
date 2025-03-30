package com.dmehta2.datastructures.tree;

import com.dmehta2.datastructures.queues.Queue;

import java.util.Scanner;

public class Tree<E> {

    public Node<E> root;

    //constructor
    public Tree() {
        root = null;
    }

    public Node<E> createTree() {
        Queue<Node<E>> queue = new Queue<>(100);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node data: ");
        E data = (E) scanner.nextLine();
        root = new Node<>(data);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.dequeue();
            System.out.println("Enter left child of " + currentNode.getData() + ": ");
            E leftChildData = (E) scanner.nextLine();
            if (!leftChildData.equals("n")) {
                Node<E> leftChild = new Node<>(leftChildData);
                currentNode.setLeft(leftChild);
                queue.enqueue(leftChild);
            }
            System.out.println("Enter right child of " + currentNode.getData() + ": ");
            E rightChildData = (E) scanner.nextLine();
            if (!rightChildData.equals("n")) {
                Node<E> rightChild = new Node<>(rightChildData);
                currentNode.setRight(rightChild);
                queue.enqueue(rightChild);
            }
        }
        return root;
    }

    public void inorderTraversal(Node<E> node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }

    public void preorderTraversal(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }

    public void postorderTraversal(Node<E> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public void levelOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        Queue<Node<E>> queue = new Queue<>(100);
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.dequeue();
            System.out.print(currentNode.getData() + " ");
            if (currentNode.getLeft() != null) {
                queue.enqueue(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.enqueue(currentNode.getRight());
            }
        }
    }

    public int height(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.getLeft());
            int rightHeight = height(root.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int size(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<E> getRoot() {
        return root;
    }

    public int countLeaves(Node<E> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    public int countNonLeaves(Node<E> root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return 0;
        }
        return 1 + countNonLeaves(root.getLeft()) + countNonLeaves(root.getRight());
    }

    public int countNodesAtLevel(Node<E> root, int level) {
        if (root == null) {
            return 0;
        }
        if (level == 1) {
            return 1;
        }
        return countNodesAtLevel(root.getLeft(), level - 1) + countNodesAtLevel(root.getRight(), level - 1);
    }

    public int countFullNodes(Node<E> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            return 1 + countFullNodes(root.getLeft()) + countFullNodes(root.getRight());
        }
        return countFullNodes(root.getLeft()) + countFullNodes(root.getRight());
    }

    public int countHalfNodes(Node<E> root) {
        if (root == null) {
            return 0;
        }
        if ((root.getLeft() != null && root.getRight() == null) || (root.getLeft() == null && root.getRight() != null)) {
            return 1 + countHalfNodes(root.getLeft()) + countHalfNodes(root.getRight());
        }
        return countHalfNodes(root.getLeft()) + countHalfNodes(root.getRight());
    }

    public int countNodes(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }
}
