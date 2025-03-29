package com.dmehta2.datastructures.linkedlist;

public class DoublyLinkedList {
    DoublyNode first;
    DoublyNode last;

    public static DoublyLinkedList create(int[] data) {
        DoublyNode last;
        DoublyLinkedList list = new DoublyLinkedList();
        for (int datum : data) {
            list.insertAtLast(datum);
        }
        return list;
    }

    public void insertAtFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (first == null) {
            first = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void display() {
        DoublyNode temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtPosition(int data, int position) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode temp = first;

        if (position == 1) {
            insertAtFirst(data);
            return;
        }
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
    }

    public void insertAtLast(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (first == null) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
    }

    public int deleteAtFirst() {
        int data = first.data;
        first = first.next;
        first.prev = null;
        return data;
    }

    public int deleteAt(int position) {
        DoublyNode temp = first;
        if (position == 1) {
            return deleteAtFirst();
        }
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        return data;
    }

    public int deleteAtLast() {
        int data = last.data;
        last = last.prev;
        last.next = null;
        return data;
    }
}
