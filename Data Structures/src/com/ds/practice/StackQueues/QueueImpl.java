package com.ds.practice.StackQueues;

public class QueueImpl {

    /*
     * Queue Functionality(FIFO) can be implemented as Singly Linked List with the help of 2 references.
     * Enqueue - adding the element (Similar to adding an element at head of linked list)
     *   i. Create a head reference & tail reference. Initially these all point to null.
     *   ii.new Node = head.next, new Node = head;
     * Dequeue - removing the element (Similar to removing an element at tail of linked list)
     *   i. Create a tail reference to the list and remove the tail by moving to next node.
     *   ii. tmp = tail, tail = tail.next, tmp.next = null.
     *
     * */

    SLLNode head;
    SLLNode tail;

    public void Enqueue(int data){
        if(head == null && tail == null){
            head = new SLLNode(data);
            tail = head;
            return;
        }
        SLLNode node = new SLLNode(data);
        head.next = node;
        head = node;
    }

    public void Dequeue(){
        if(head == null && tail == null){
            return;
        }
        SLLNode tmp = tail;
        tail = tail.next;
        tmp.next = null;
    }
}
