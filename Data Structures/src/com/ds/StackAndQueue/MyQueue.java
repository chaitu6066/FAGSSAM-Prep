package com.ds.StackAndQueue;

class QueueNode {
    int data;
    QueueNode next;
    public QueueNode(int data) {
        this.data = data;
    }
}
public class MyQueue {
    QueueNode head, tail;

    void enqueue(int data) {
        QueueNode temp = new QueueNode(data);
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = tail.next;
    }

    int dequeue() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        int result = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
