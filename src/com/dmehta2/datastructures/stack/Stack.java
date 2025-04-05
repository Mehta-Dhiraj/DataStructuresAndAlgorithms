package com.dmehta2.datastructures.stack;

public class Stack<E> {

    private final Object[] stack;
    private int top;
    private final int size;

    public Stack(int size) {
        this.size = size;
        this.stack = new Object[size];
        this.top = -1;
    }

    public void createStack(Object[] arr, int size) {
        for (int i = 0; i < size; i++) {
            top++;
            stack[top] = arr[i];
        }
    }

    public void push(E data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (E) stack[top--];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (E) stack[top];
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }
}
