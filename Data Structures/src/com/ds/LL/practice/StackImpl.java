package com.ds.LL.practice;

import com.ds.LL.practice.SingleLinkedListUtils.SLLNode;

public class StackImpl {

    /*
    * Stack Functionality(FILO) can be implemented as Singly Linked List.
    * pop - removing the top element
    *   i. Create a head reference to the list and remove at head
    *   ii. tmp = head, head = head.next, tmp.next = null;
    * push - adding to the top element
    *   i. Create a head reference to the list and insert at head
    *   ii. new Node .next = head, head = new Node.
    *
    * */
    SLLNode head;

    public Integer pop(){
        if(head == null){
            return null;
        }
        SLLNode tmp = head;
        head = head.next;
        tmp.next = null;
        return tmp.data;
    }

    public void push(int data){
        if(head == null){
            head = new SLLNode(data);
            return;
        }
        SLLNode node = new SLLNode(data);
        node.next = head;
        head = node;
    }
}
