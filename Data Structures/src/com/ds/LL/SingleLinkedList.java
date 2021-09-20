package com.ds.LL;

import java.util.HashSet;

public class SingleLinkedList {
    class SLLNode {
        int data;
        SLLNode next;

        SLLNode(int data) {
            this.data = data;
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

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.appendAtTail(10);
        sll.appendAtTail(20);
        sll.appendAtTail(30);
        sll.appendAtTail(40);
        sll.print();
        if (sll.deleteNode(20)) {
            System.out.println("20 deleted from list");
        }
        sll.appendAtTail(10);

        sll.print();
        sll.removeDuplicatesWithoutExtraSpace(sll).print();
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(10);
        sll.appendAtTail(1000);
        sll.appendAtTail(10);
        sll.print();
        sll.printKthlastNodeIntheList(sll, 2);
    }

// ********************** Problems *********************

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

}