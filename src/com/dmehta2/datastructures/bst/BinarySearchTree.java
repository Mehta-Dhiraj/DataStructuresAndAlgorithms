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

    public Node<E> search(E i) {
        Node<E> current = root;
        while (current != null) {
            if (compare(current, new Node<>(i)) == 0) {
                return current;
            } else if (compare(current, new Node<>(i)) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public Node<E> delete(E i) {
        Node<E> current = root;
        Node<E> parent = null;

        while (current != null && compare(current, new Node<>(i)) != 0) {
            parent = current;
            if (compare(current, new Node<>(i)) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (current == null) {
            return null; // Not found
        }

        // Case 1: No children
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (parent.getLeft() == current) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // Case 2: One child
        else if (current.getLeft() == null || current.getRight() == null) {
            Node<E> child = (current.getLeft() != null) ? current.getLeft() : current.getRight();
            if (current == root) {
                root = child;
            } else if (parent.getLeft() == current) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        // Case 3: Two children
        else {
            Node<E> successor = findSuccessor(current.getRight());
            E successorData = successor.getData();
            delete(successorData);
            current.setData(successorData);
        }
        return current;
    }

    public Node<E> findSuccessor(Node<E> current) {
        Node<E> successor = current.getRight();
        while (successor != null && successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }

    public Node<E> findPredecessor(Node<E> current) {
        Node<E> predecessor = current.getLeft();
        while (predecessor != null && predecessor.getRight() != null) {
            predecessor = predecessor.getRight();
        }
        return predecessor;
    }
}
