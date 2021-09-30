package com.ds.practice.linkedlist;

class LinkedListReversal {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
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
            System.out.println("No elements in list");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    public void traverse(Node node) {
        if (head == null) {
            System.out.println("No elements in list");
        } else {
            Node currentNode = node;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    public void reverse() {
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode;
        if (head == null) {
            System.out.println("No elements in list to reverse");
        } else {
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            currentNode = previousNode;
            traverse(currentNode);
        }
    }

    public static void main(String[] args) {
        LinkedListReversal reversal = new LinkedListReversal();
        reversal.add(10);
        reversal.add(20);
        reversal.add(30);
        reversal.add(40);
        reversal.add(50);
        reversal.traverse();
        System.out.println();
        reversal.reverse();

    }
}