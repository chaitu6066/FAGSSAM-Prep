package com.ds.LL;

import java.util.ArrayList;
import java.util.HashSet;

public class SingleLinkedList {
    class SLLNode {
        int data;

        SLLNode next;

        SLLNode(int data) {
            this.data = data;
            next = null;
        }
    }

    class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    SLLNode head;

    public void appendAtTail(int data) {

        if (head == null) {
            head = new SLLNode(data);
            return;
        }

        SLLNode cHead = head;
        while (cHead.next != null) {
            cHead = cHead.next;
        }
        cHead.next = new SLLNode(data);
    }

    public void appendToHead(int data) {
        SLLNode temp = new SLLNode(data);
        temp.next = head;
        head = temp;
    }

    public boolean deleteNode(int data) {

        SLLNode cHead = head;

        if (cHead.data == data) {
            cHead = cHead.next;
            return true;
        }

        while (cHead.next != null) {
            if (cHead.next.data == data) {
                cHead.next = cHead.next.next;
                return true;
            }
            cHead = cHead.next;
        }

        return false;
    }

    void print() {
        SLLNode cHead = head;
        System.out.println("List Elements: ");
        while (cHead != null) {
            System.out.print(cHead.data + "\t");
            cHead = cHead.next;
        }
        System.out.println();
    }

//TODO: Implement following functions 1. insertAtHead() and do the same for double linked list
    // If you are not able to progress, will add om 26th Sept

    public DLLNode insertAtHead(DLLNode head, int data){
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            return  newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }

    void printForDLL(DLLNode node) {
        DLLNode cHead = node;
        System.out.println("List Elements: ");
        while (cHead != null) {
            System.out.print(cHead.data + "\t");
            cHead = cHead.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> add = new ArrayList<>();

        SingleLinkedList sll = new SingleLinkedList();
        sll.appendAtTail(10);
        sll.appendAtTail(20);
        sll.appendAtTail(30);
        sll.appendAtTail(40);
        sll.appendAtTail(10);
        sll.removeDuplicatesWithoutExtraSpace(sll).print();
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(1000);
        sll.appendAtTail(10);

        sll.printKthlastNodeIntheList(sll, 2);
        sll.reverseASLL(sll).print();
        sll.addTwoLists();
        sll.loopCheckHelper();
        sll.getIntersectionNodeHelper();

        DLLNode node = sll.insertAtHead(null, 1);
        sll.printForDLL(sll.insertAtHead(node, 2));

    }

/* ********************* Problems *********************/



/* ******************* Remove Duplicates */

    SingleLinkedList removeDuplicatesWithExtraSpace(SingleLinkedList list) {
        if (list == null || list.head == null)
            return null;
        HashSet<Integer> hashSet = new HashSet<>();
        SLLNode sll = list.head, previous = null;

        while (sll != null) {
            if (hashSet.contains(sll.data)) {
                previous.next = sll.next;
            } else {
                hashSet.add(sll.data);
                previous= sll;
            }
            sll = sll.next;
        }
        return list;
    }

    SingleLinkedList removeDuplicatesWithoutExtraSpace(SingleLinkedList list) {
        if (list == null || list.head == null)
            return null;

        SLLNode cHead = list.head, nextNode;

        while (cHead != null && cHead.next != null) {
            nextNode = cHead;

            while (nextNode.next != null) {
                if (cHead.data == nextNode.next.data) {
                    nextNode.next = nextNode.next.next;
                }else {
                    nextNode = nextNode.next;
                }
            }
            cHead = cHead.next;

        }

        return list;
    }


/* **************** Print the Kth node from last ******************/

    void printKthlastNodeIntheList(SingleLinkedList list, int k) {
        SLLNode fast = list.head, slow = list.head;

        for(int i=0;i<k;i++) {
            if (fast == null){
                System.err.println("List is smaller than K");
                return;
            }
            fast=fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        assert slow != null;
        System.out.println(slow.data);
    }

/* ************* Reverse a single linked List *****************/

    SingleLinkedList reverseASLL(SingleLinkedList list) {

        SLLNode cHead = list.head, prev = null;
        while (cHead != null){
            SLLNode temp = cHead.next;
            cHead.next = prev;
            prev = cHead;
            cHead = temp;
        }
        list.head = prev;
        return list;
    }


/* ************************  2 numbers represented in the form of linked list. Each node contains
 * single digit. Return the result in the form of new list.
 ************************/

    //TODO: Implement the followup questions 1. If the length of the LL are not same?

    void addTwoLists() {
        SLLNode h1 = new SLLNode(4);
        h1.next = new SLLNode(2);
        h1.next.next = new SLLNode(3);
        h1.next.next.next = new SLLNode(5);

        SLLNode h2 = new SLLNode(4);
        h2.next = new SLLNode(2);
        h2.next.next = new SLLNode(3);
        h2.next.next.next = new SLLNode(5);

        SLLNode result = sumOfTwoLLRecursive(h1, h2);
        System.out.print("Sum of 2 LLs is: \t");
        while (result != null) {
            System.out.print("\t" + result.data);
            result = result.next;
        }
        System.out.println();
    }

    SLLNode sumOfTwoLLRecursive(SLLNode l1, SLLNode l2) {
        return sumOfTwoLLHelper(l1, l2, 0);
    }

    SLLNode sumOfTwoLLHelper(SLLNode list1, SLLNode list2, int carry) {
        if ( list1 == null && list2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (list1 != null) {
            sum += list1.data;
        }
        if (list2 != null){
            sum += list2.data;
        }

        SLLNode result = new SLLNode(sum%10);
        if (list1 != null || list2 != null) {
            result.next = sumOfTwoLLHelper(list1.next, list2.next, sum / 10);
        }
        return result;
    }

/* ********** Find out that the Linkedlist is null terminated or has a loop ************/

    void loopCheckHelper() {
        SLLNode s1 = new SLLNode(1);
        SLLNode s2 = new SLLNode(2);
        s1.next = s2;
        SLLNode s3 = new SLLNode(3);
        s2.next = s3;
        SLLNode s4 = new SLLNode(4);
        s3.next = s4;
        SLLNode s5 = new SLLNode(5);
        s4.next = s5;
        SLLNode s6 = new SLLNode(6);
        s5.next = s6;
        SLLNode s7 = new SLLNode(7);
        s6.next = s7;
        SLLNode s8 = new SLLNode(8);
        s7.next = s8;
        SLLNode s9 = new SLLNode(9);
        s8.next = s9;
        s9.next = s4;// This is loop creation. It should be null. But we are pointing to s4
        // again to create loop.

        if (hasLoop(s1)){
            System.out.println("Loop starting Node: " + getLoopStartingNode(s1).data);
        }

    }

    boolean hasLoop(SLLNode cHead) {
        SLLNode slow = cHead, fast = cHead;

        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return slow == fast;
    }


    SLLNode getLoopStartingNode(SLLNode cHead) {
        SLLNode slow = cHead, fast = cHead;

        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        slow = cHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

/* ********* How do you find the middle node of a linked list? Ans : Runner technique. Implement
slow pointer and fast pointer answer
 */
    //TODO: Implement Fast and Slow Pointer: Ref: Above method hasLoop()
public static SLLNode getMiddleElement(SLLNode head){
    SLLNode runner1 = head;
    SLLNode runner2 = head;
    while(runner2 != null && runner2.next != null && runner2.next.next !=null){
        runner1 = runner1.next;
        runner2 = runner2.next.next;
    }
    return runner1;
}


    /* ****** Find out whether 2 linked list intersect or not. If yes, return the starting point
    of the intersection.
     */


   void getIntersectionNodeHelper() {
       SLLNode s1 = new SLLNode(1);
       SLLNode s2 = new SLLNode(2);
       s1.next = s2;
       SLLNode s3 = new SLLNode(3);
       s2.next = s3;
       SLLNode s4 = new SLLNode(4);
       s3.next = s4;
       SLLNode s5 = new SLLNode(5);
       s4.next = s5;
       SLLNode s6 = new SLLNode(6);
       s5.next = s6;
       SLLNode s7 = new SLLNode(7);
       s6.next = s7;
       SLLNode s8 = new SLLNode(8);
       s7.next = s8;
       SLLNode s9 = new SLLNode(9);
       s8.next = s9;

       SLLNode l1 = new SLLNode(11);
       SLLNode l2 = new SLLNode(12);
       l1.next = l2;
       SLLNode l3 = new SLLNode(13);
       l2.next = l3;
       l3.next = s7;

       SLLNode result = getIntersectionNode(l1, s1);
       if (result != null) {
           System.out.println("Intersection Starting Node: " + result.data);
       }
   }

    SLLNode getIntersectionNode(SLLNode l1, SLLNode l2) {
        if (l2 == null || l1 == null)
            return null;

        int l1Len = getLLLength(l1);
        int l2Len = getLLLength(l2);

        SLLNode shortLL, longLL;

        if (l1Len < l2Len) {
            shortLL = l1;
            longLL = l2;
        } else {
            shortLL = l2;
            longLL = l1;
        }

        int diff = Math.abs(l1Len - l2Len);

        while (diff > 0) {
            longLL = longLL.next;
            diff--;
        }

        while (shortLL != longLL && shortLL != null) {
            shortLL = shortLL.next;
            longLL = longLL.next;
        }

        if (shortLL == longLL) {
            return shortLL;
        }
        return null;

    }

    int getLLLength(SLLNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }

/* ************** Print LL from last **********/

    void printLLFromTailRecur(SLLNode list) {
       if (list == null) {
           return;
       }
       printLLFromTailRecur(list.next);
       System.out.println(list.data);
    }

}