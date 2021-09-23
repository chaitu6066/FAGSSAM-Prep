package com.ds.LL;

public class FindLoopSingleLinkedList {
    /*
     * This class is to find the loops in a given Linked List
     *
     * Input - 1 -> 2 -> 3 -> 4 -> 5
     *                       \      \
     *                       8<- 7 <- 6
     * Output - true
     *
     * Input - 1 -> 2 -> 3 -> 4 -> 5
     * Output - false
     * */

    static class SLLNode {
        int data;
        SLLNode next;
        SLLNode(int data){
            this.data = data;
            next = null;
        }
        SLLNode getNext() {
            return next; //TODO return shawllow copy Look into this topic and provide a best alternate value
        }
    }

    public boolean isLoop(SLLNode head) {

        SLLNode first = head;
        SLLNode second = head;
        while(head.next != null){
            first = first.next;
            if(second.next != null && second.next.next != null){
                second = second.next.next;
                if(first.data == second.data){
                    return true;
                }
            }
            head = first;
        }
        return false;
    }

   }
