package com.ds.LL.practice;

import com.ds.LL.practice.SingleLinkedListUtils.SLLNode;

public class LoopsInSingleLinkedList {
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

    public boolean isLoop(SLLNode head) {
        SLLNode first = head;
        SLLNode second = head;
        while (head.next != null) {
            first = first.next;
            if (second.next != null && second.next.next != null) {
                second = second.next.next;
                if (first.data == second.data) {
                    return true;
                }
            }
            head = first;
        }
        return false;
    }

    public SLLNode getRunnersMeet(SLLNode head) {
        SLLNode first = head;
        SLLNode second = head;
        while (head.next != null) {
            first = first.next;
            if (second.next != null && second.next.next != null) {
                second = second.next.next;
                if (first.data == second.data) {
                    return first;
                }
            }
            head = first;
        }
        return null;
    }

    public SLLNode getIntersection(SLLNode head) {
        SLLNode runnerOne = head;
        SLLNode runnerTwo = getRunnersMeet(head);
        if (runnerTwo != null) {
            while (true) {
                if (runnerOne.equals(runnerTwo)) {
                    return runnerOne;
                }
                runnerOne = runnerOne.next;
                runnerTwo = runnerTwo.next;
            }
        }
        return null;
    }
}