package com.ds.LL.practice;

import com.ds.LL.practice.SingleLinkedListUtils.SLLNode;
public class CRUDSingleLinkedList {
    /*
     * This class is to do insert/delete/update the singly linked list at either specified position or node
     */

    public SLLNode deleteNodeAt(SLLNode head, int position){
        SLLNode pointer = head;
        if(position == 0){
            return null;
        }else{
            for(int i = 1 ; i<position ; i++){
                if(pointer.next != null){
                    pointer = pointer.next;
                }else {
                    return null;
                }
            }
            if(pointer.next != null){
                pointer.next = pointer.next.next;
                return head;
            }
        }
        return null;
    }

    public SLLNode delete(SLLNode node){
        //TODO
        return null;
    }
}
