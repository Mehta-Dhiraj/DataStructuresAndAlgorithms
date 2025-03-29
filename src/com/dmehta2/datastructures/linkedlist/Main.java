package com.dmehta2.datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyCircularLinkedList list1 = DoublyCircularLinkedList.create(new int[]{10, 20, 30, 40, 50, 60});
        list1.display();
        list1.deleteAtFirst();
        list1.display();
        list1.deleteAtLast();
        list1.display();
        list1.deleteAt(3);
        list1.display();
    }
}