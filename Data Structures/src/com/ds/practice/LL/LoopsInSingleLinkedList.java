package com.ds.practice.LL;

import com.ds.practice.utils.SingleLinkedListUtils;
import com.ds.practice.utils.SingleLinkedListUtils.SLLNode;

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

    public SLLNode getIntersectionNode(SLLNode head1, SLLNode head2) {
        SLLNode runnerOne = head1;
        SLLNode runnerTwo = head2;
        int length1 = 0,length2 = 0;
        SingleLinkedListUtils utils = new SingleLinkedListUtils();
        if (runnerOne != null || runnerTwo != null) {
            length1 = utils.findLength(runnerOne);
            length2 = utils.findLength(runnerTwo);
        }
        if(length1 > length2){
            int diff = length1 - length2;
            while(diff == 0){
                runnerOne = runnerOne.next;
                diff--;
            }
        }else if(length2 > length1){
            int diff = length2 - length1;
            while(diff == 0){
                runnerTwo = runnerTwo.next;
                diff--;
            }
        }
        while(runnerOne != null && runnerTwo != null){
            if(runnerOne.equals(runnerTwo))
                return runnerOne;
            runnerOne = runnerOne.next;
            runnerTwo = runnerTwo.next;
        }
        return null;
    }
}