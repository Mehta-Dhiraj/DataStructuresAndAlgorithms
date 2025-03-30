package com.dmehta2.datastructures.bst;

public class BinarySearchTreeImpl {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);

        System.out.println("Preorder Traversal:");
        bst.preorderTraversal(bst.root);
        System.out.println("\nPostorder Traversal:");
        bst.postorderTraversal(bst.root);
        System.out.println("\nInorder Traversal:");
        bst.inorderTraversal(bst.root);
        System.out.println("\nLevel Order Traversal:");
        bst.levelOrderTraversal(bst.root);
        System.out.println("\nSearching for 3: " + bst.search(3));
        System.out.println("\nHeight of the tree: " + bst.height(bst.root));
        System.out.println("Size of the tree: " + bst.size(bst.root));
        System.out.println("Searching for 4: " + bst.search(4));
        System.out.println("Number of nodes: " + bst.countNodes(bst.root));
        System.out.println("Number of full nodes: " + bst.countFullNodes(bst.root));
        System.out.println("Number of leaf nodes: " + bst.countLeaves(bst.root));
        System.out.println("Number of half nodes: " + bst.countHalfNodes(bst.root));
    }
}
