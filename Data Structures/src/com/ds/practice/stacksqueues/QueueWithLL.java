package com.ds.practice.stacksqueues;

class QueueWithLL {
    Node head, tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            head = head.next;
        }
    }


    public static void main(String[] args) {
        QueueWithLL queueWithLL = new QueueWithLL();
        queueWithLL.enqueue(10);
        queueWithLL.enqueue(20);
        queueWithLL.enqueue(30);
        queueWithLL.dequeue();
        queueWithLL.dequeue();
        System.out.println("Head : " + queueWithLL.head.data);
        System.out.println("Tail : " + queueWithLL.tail.data);

    }
}