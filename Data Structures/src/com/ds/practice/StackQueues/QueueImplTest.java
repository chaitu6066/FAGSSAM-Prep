package com.ds.practice.StackQueues;

import org.junit.Test;

public class QueueImplTest {

    QueueImpl queue = new QueueImpl();
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

    @Test
    public void test(){
        queue.Enqueue(1);
        System.out.println(utils.print(queue.tail));
        queue.Enqueue(2);queue.Enqueue(3);
        System.out.println(utils.print(queue.tail));
        queue.Dequeue();queue.Dequeue();
        System.out.println(utils.print(queue.tail));
    }
}