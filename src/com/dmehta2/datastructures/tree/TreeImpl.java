package com.dmehta2.datastructures.tree;

public class TreeImpl {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Node<Integer> tree1 = tree.createTree();
        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree1);
        System.out.println("\nPreorder traversal:");
        tree.preorderTraversal(tree1);
        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree1);

        Tree<Integer> tree2 = new Tree<>();
        tree2.insert(1);
        tree2.insert(2);
        tree2.insert(3);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(6);
        tree2.insert(7);
        tree2.insert(8);

        System.out.println("\nInorder traversal:");
        tree2.inorderTraversal(tree2.root);
        System.out.println("\nPreorder traversal:");
        tree2.preorderTraversal(tree2.root);
        System.out.println("\nPostorder traversal:");
        tree2.postorderTraversal(tree2.root);
    }
}
