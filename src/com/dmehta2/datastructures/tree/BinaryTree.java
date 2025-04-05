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
}
