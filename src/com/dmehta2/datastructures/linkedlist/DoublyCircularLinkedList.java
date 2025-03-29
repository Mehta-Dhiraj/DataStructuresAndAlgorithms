package com.dmehta2.datastructures.linkedlist;

public class DoublyCircularLinkedList {
    DoublyNode first;
    DoublyNode last;

    public static DoublyCircularLinkedList create(int[] datas) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        for (int data : datas) {
            list.insertAtLast(data);
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
        if (last == null) {
            last = newNode;
        }
        last.next = first;
        first.prev = last;
    }

    public void display() {
        DoublyNode temp = first;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (first != temp);
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

        if (first == null) {
            insertAtFirst(data);
        } else {
            DoublyNode newNode = new DoublyNode(data);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            last.next = first;
            first.prev = last;
        }
    }

    public void deleteAtFirst() {
        int data = first.data;
        first = first.next;
        first.prev = last;
        last.next = first;
        System.out.println("Deleted: " + data);
    }

    public void deleteAt(int position) {
        DoublyNode temp = first;
        if (position == 1) {
            deleteAtFirst();
            return;
        }
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        System.out.println("Deleted: " + data);
    }

    public void deleteAtLast() {
        int data = last.data;
        last = last.prev;
        last.next = first;
        first.prev = last;
        System.out.println("Deleted: " + data);
    }
}
