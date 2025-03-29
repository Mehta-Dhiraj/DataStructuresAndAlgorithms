package com.dmehta2.datastructures.linkedlist;

public class LinkedList {

    public Node head;

    public void creat(int[] data) {
        for (int datum : data) {
            Node node = insertAtLast(datum);
        }
    }

    public static LinkedList concat(LinkedList list1, LinkedList list2) {

        if (list1.head == list2.head) {
            return list1;
        }

        Node temp = list1.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = list2.head;
        return list1;
    }

    public static LinkedList merge(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                mergedList.insertAtLast(temp1.data);
                temp1 = temp1.next;
            } else {
                mergedList.insertAtLast(temp2.data);
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            mergedList.insertAtLast(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            mergedList.insertAtLast(temp2.data);
            temp2 = temp2.next;
        }
        return mergedList;
    }

    public Node insertAtLast(int data) {
        // write the code to insert a new node at the end of the linked list
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return head;
    }

    public void insertDataInSortedList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp != null && temp.data < data) {
                prev = temp;
                temp = temp.next;
            }
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                prev.next = newNode;
                newNode.next = temp;
            }
        }
    }

    public void reverse() {
        Node next = head;
        Node current = null;
        Node prev = null;
        while (next != null) {
            prev = current;
            current = next;
            next = next.next;
            current.next = prev;
        }
        head = current;
    }

    public void recReverse(Node prev, Node current) {

        if (current != null) {
            recReverse(current, current.next);
            current.next = prev;
        } else {
            head = prev;
        }

    }

    public Node insertNodeAtPosition(Node llist, int data, int position) {
        // Write your code here
        Node newNode = new Node(data);

        if (llist == null) {
            llist = newNode;
        } else {
            Node temp = llist;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return llist;
    }

    public Node deleteNode(Node llist, int position) {
        Node temp = head;
        Node prev = null;

        // Base case if linked list is empty
        if (temp == null)
            return head;

        // Case 1: Head is to be deleted
        if (position == 1) {
            head = temp.next;
            return head;
        }

        // Case 2: Node to be deleted is in middle
        // Traverse till given position
        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }

        // If given position is found, delete node
        if (temp != null) {
            prev.next = temp.next;
        } else {
            System.out.println("Data not present");
        }

        return head;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
