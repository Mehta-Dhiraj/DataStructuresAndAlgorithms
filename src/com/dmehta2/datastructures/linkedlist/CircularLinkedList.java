package com.dmehta2.datastructures.linkedlist;

public class CircularLinkedList {
    public Node head;

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            do {
                temp = temp.next;
            } while (temp.next != head);
            temp.next = newNode;
        }
        newNode.next = head;
    }


    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            do {
                temp = temp.next;
            } while (temp.next != head);
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static CircularLinkedList create(int[] data) {
        CircularLinkedList list = new CircularLinkedList();
        for (int datum : data) {
            list.insertAtLast(datum);
        }
        return list;
    }

    public void display() {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
