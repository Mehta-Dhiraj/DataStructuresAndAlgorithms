package com.dmehta2.datastructures.heap;

public class HeapImpl {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(0);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(25);
        heap.insert(5);
        heap.insert(40);
        heap.insert(35);

        System.out.println("Heap elements size:" + heap.size());
        heap.print();
        heap.display();
    }
}
