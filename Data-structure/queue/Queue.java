package queue;

import java.util.Scanner;

public class Queue {

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
        queue.addQueue(2);
        queue.addQueue(5);
        queue.addQueue(5);
//        queue.outQueue();
//        queue.outQueue();
//        queue.outQueue();
//        queue.addQueue(1);
//        queue.showQueue();
        System.out.println(queue.outQueue());
        System.out.println(queue.outQueue());
        System.out.println(queue.outQueue());
    }
}
