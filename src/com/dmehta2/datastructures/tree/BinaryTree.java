package com.dmehta2.datastructures.tree;

import com.dmehta2.datastructures.queues.Queue;

public class BinaryTree<E> extends Tree<E> {


    public void insert(E data) {
        Queue<Node<E>> queue = new Queue<>(100);
        Node<E> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                Node<E> currentNode = queue.dequeue();
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    break;
                } else {
                    queue.enqueue(currentNode.getLeft());
                }
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    break;
                } else {
                    queue.enqueue(currentNode.getRight());
                }
            }
        }
    }

    protected void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            inorderRec(root.getRight());
        }
    }

    protected void preorderRec(Node<E> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
        }
    }

    protected void postorderRec(Node<E> root) {
        if (root != null) {
            postorderRec(root.getLeft());
            postorderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }
}
