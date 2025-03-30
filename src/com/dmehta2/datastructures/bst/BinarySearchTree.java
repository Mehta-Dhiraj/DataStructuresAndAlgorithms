package com.dmehta2.datastructures.bst;

import com.dmehta2.datastructures.tree.BinaryTree;
import com.dmehta2.datastructures.tree.Node;

public class BinarySearchTree<E> extends BinaryTree<E> {

    public void insert(E data) {
        Node<E> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            insertRec(root, newNode);
        }
    }

    private void insertRec(Node<E> current, Node<E> newNode) {
        if (compare(current, newNode) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insertRec(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insertRec(current.getRight(), newNode);
            }
        }
    }


    public int compare(Node<E> current, Node<E> newNode) {
        if (current.getData() instanceof Integer) {
            return ((Integer) current.getData()).compareTo((Integer) newNode.getData());
        }
        return ((Comparable<E>) current.getData()).compareTo(newNode.getData());
    }

    public E search(E i) {
        Node<E> current = root;
        while (current != null) {
            if (compare(current, new Node<>(i)) == 0) {
                return current.getData();
            } else if (compare(current, new Node<>(i)) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }
}
