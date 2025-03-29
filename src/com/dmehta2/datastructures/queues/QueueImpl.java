package com.dmehta2.datastructures.queues;


public class QueueImpl {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>(5);
        queue.enqueue("Asfn");
        queue.enqueue("Bsfsd");
        queue.enqueue("Csfdfs");
        //queue.dequeue();

        queue.display();

        System.out.println("-----------------");
        Queue<Integer> queue2 = new Queue<>(5);

        queue2.enqueue(1);
        queue2.enqueue(2353);
        queue2.enqueue(353);
        queue2.dequeue();

        queue2.display();

        System.out.println("-----------------");
        Queue<Boolean> queue3 = new Queue<>(5);

        queue3.enqueue(true);
        queue3.enqueue(false);
        queue3.enqueue(true);

        queue3.display();

    }


}
