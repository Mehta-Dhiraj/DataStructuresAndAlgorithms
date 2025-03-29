package com.dmehta2.datastructures.tree;

import com.dmehta2.datastructures.queues.Queue;

import java.util.Scanner;

public class Tree<E> {

    public Node<E> root;

    //constructor
    public Tree() {
        root = null;
    }

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

    public Node<E> createTree() {
        Queue<Node<E>> queue = new Queue<>(100);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node data: ");
        E data = (E) scanner.nextLine();
        Node<E> newNode = new Node<>(data);
        root = newNode;
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

}


