package com.dmehta2.datastructures.tree;

public class BinaryTree {

    Node root;


//    public void insert(int data) {
//        root = insertRec(root, data);
//    }
//
//    private Node insertRec(Node root, int data) {
//        if (root == null) {
//            root = new Node(data);
//            return root;
//        } else {
//            if (data < root.getData()) {
//                root.setLeft(insertRec(root.getLeft(), data));
//            } else if (data > root.getData()) {
//                root.setRight(insertRec(root.getRight(), data));
//            }
//        }
//        return root;
//    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            inorderRec(root.getRight());
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.getLeft());
            postorderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }
}
