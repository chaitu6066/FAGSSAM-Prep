package com.ds.practice.linkedlist;

class LinkedListLoop {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void traverse() {
        Node curreNode = head;

        while (curreNode != null) {
            System.out.print(curreNode.data + " ");
            curreNode = curreNode.next;
        }
    }

    public boolean isLoop() {
        Node fastPointer = head, slowPointer = head;
        while (fastPointer != null && slowPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public void makeLoop() {
        head.next.next.next = head;
    }

    public static void main(String[] args) {
        LinkedListLoop linkedListLoop = new LinkedListLoop();
        linkedListLoop.insert(10);
        linkedListLoop.insert(20);
        linkedListLoop.insert(30);
        linkedListLoop.insert(40);
        linkedListLoop.traverse();
        linkedListLoop.makeLoop();
        System.out.println();
        System.out.println("Linked list have loop : " + linkedListLoop.isLoop());
    }
}