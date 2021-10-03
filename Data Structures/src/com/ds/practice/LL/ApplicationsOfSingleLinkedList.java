package com.ds.practice.LL;

import com.ds.practice.utils.SingleLinkedListUtils.SLLNode;

public class ApplicationsOfSingleLinkedList {
    /*
     * This class is to understand various applications of Singly Linked List
     *
     * 1. Rotate the given linked K times :-
     * i/p - 1->2->3->4->5->6 , k = 4
     * o/p - 3->4->5->6->1->2
     *      You have write access to the given list. No extra space allowed
     *      i. Copy the head ref in Pointer1 and iterate the pointer1 till you reach end of the ll and update pointer1.next = head.
     *          while doing above initialize count and calculate length of ll.
     *      ii.Do count - k - 1 [which gives the position where you need to break.
     *
     * 2. Reverse a given linked list :-
     * i/p - 1->2->3->4->5->6
     * o/p - 6->5->4->3->2->1
     *      You have write access to the list.
     *      i. Take 3 references, Prev=null, Curr=head & Next=null.
     *      ii. Put curr next into next.
     *      iii. Put Prev as Curr next.[in first iteration you are putting null as curr.next]
     *      iv. put curr into prev & next into curr.
     *
     * 3. Print given linked list in circles. Or i/p - a1->a2->a3->.....an-1->an o/p should be a1->an->a2->an-1->a3->....
     *                           /---\
     *      i/p 1->2->3   o/p - 1  2  3  1->3->2
     *                              \-/
     *
     *      Given ll length can be even or odd. Write access is allowed.
     *      i.Take 2 runners - One will traverse one node at a time & another will traverse 2 nodes at a time.
     *          If the fast runner.next && .next.next is null then we reached it reached the end of the ll.
     *      ii.Point the Slow runner.next into TempHead and make runner.next = null.
     *      iii. Pass the TempHead into a method which will return the Reverse of the linked list.
     *      iv. Take two ll heads, and do linking process.
     *
     *4.Print common elements in a 2 sorted slls.
     *      Two slls are sorted in the ascending order.
     *      i.Take 4 pointers. 1-head of first sll,2-head of second sll,3-head.next of f-sll,4-head.next of s-sll.
     *      ii.Check if 1<2 then
     *
     *5.Find the kth last element from the singly linked list.
     *      Runner Technique -
     *          Start a pointer from head and iterate over list k times.
     *          Now create second pointer from head and iterate over list until first pointer reaches last element.
     *
     * 6. Add two numbers
     *
     *
     *
     */

    public SLLNode findKthLastElement(SLLNode head, int k){
        SLLNode node = head;
        int i =0;
        while(i<k){
            if (node == null){
                return null;
            }
            node = node.next;
            i++;
        }
        SLLNode temp = head;
        while (node != null){
            temp = temp.next;
            node = node.next;
        }
        return temp;
    }

    public SLLNode printListAsCircles(SLLNode head){
        SLLNode node = head;
        SLLNode tempHead = null;
        SLLNode tmp1;
        SLLNode tmp2;

        tempHead = getMiddleElement(head).next;
        getMiddleElement(head).next = null;

        SLLNode secondLL = reverse(tempHead);
        //Now we need to append the 2 lists in a zigzag fashion.
        while(node != null && secondLL != null){
            tmp1 = node.next;
            tmp2 = secondLL.next;
            node.next = secondLL;
            secondLL.next = tmp1;
            node = tmp1;
            secondLL = tmp2;
        }

        return head;
    }

    public SLLNode getMiddleElement(SLLNode head){
        SLLNode runner1 = head;
        SLLNode runner2 = head;
        while(runner2 != null && runner2.next != null && runner2.next.next !=null){
            runner1 = runner1.next;
            runner2 = runner2.next.next;
        }
        return runner1;
    }

    public SLLNode reverse(SLLNode head){
        SLLNode curr = head;
        SLLNode prev = null,next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public SLLNode rotateSLL(SLLNode head, int k){
        SLLNode pointer = head;
        if(head == null){
            return null;
        }
        int length = 1;
        while(pointer.next != null){
            pointer = pointer.next;
            length++;
        }
        pointer.next = head;

        if(k > length){
            k = (k % length);
        }

        if(k < length){
            k = length - k - 1;
        }else{
            k = length - 1;
        }
        for(int i=0; i<k; i++){
            head = head.next;
        }
        SLLNode newHead = head.next;
        head.next = null;

        return newHead;
    }


}
