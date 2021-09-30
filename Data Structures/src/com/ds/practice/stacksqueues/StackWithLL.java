package com.ds.practice.stacksqueues;

class StackWithLL {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            System.out.println("Stack underflow");
        } else {
            System.out.println(head.data + " Popped from stack");
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }


    public static void main(String[] args) {
        StackWithLL stackWithLL = new StackWithLL();
        stackWithLL.push(10);
        stackWithLL.push(20);
        stackWithLL.push(30);
        stackWithLL.push(40);
        stackWithLL.push(50);
        stackWithLL.traverse();
        System.out.println();
        stackWithLL.pop();
        stackWithLL.pop();
        stackWithLL.traverse();
    }
}