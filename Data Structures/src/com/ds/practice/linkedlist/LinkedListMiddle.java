package com.ds.practice.linkedlist;

class LinkedListMiddle {
    Node head;

    static class Node {
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
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    public void traverse(Node node) {
        if (node == null) {
            System.out.println("List is empty");
        } else {
            Node currentNode = node;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    public int findMiddle() {
        Node fastPointer = head;
        Node slowPointer = head;
        int middle;
        if (head == null) {
            middle = -1;
        } else {
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            middle = slowPointer.data;
        }
        return middle;
    }

    public Node reversal() {
        Node currentNode = null;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            currentNode = head;
            Node previousNode = null;
            Node nextNode;
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            currentNode = previousNode;
        }
        return currentNode;
    }

    public static void main(String[] args) {
        LinkedListMiddle linkedListMiddle = new LinkedListMiddle();
        linkedListMiddle.insert(10);
        linkedListMiddle.insert(20);
        linkedListMiddle.insert(30);
        linkedListMiddle.insert(40);
        linkedListMiddle.insert(50);
        linkedListMiddle.insert(60);
        linkedListMiddle.traverse();
        System.out.println();
        System.out.println(linkedListMiddle.findMiddle());
        System.out.println();
        linkedListMiddle.traverse(linkedListMiddle.reversal());
    }
}