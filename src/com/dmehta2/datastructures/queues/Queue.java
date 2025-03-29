package com.dmehta2.datastructures.queues;

public class Queue<E> {

    Object[] array;
    int front;
    int rear;
    int capacity;
    int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(E value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = value;
        if (front == -1) {
            front = rear;
        }
        size++;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.println(array[i]);
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        E element = (E) array[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) array[front];
    }

}
