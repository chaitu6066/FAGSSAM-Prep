package com.ds.practice.utils;

public class SingleLinkedListUtils {
    public static class SLLNode {
        public int data;
        public SLLNode next;
        public SLLNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public SLLNode getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(SLLNode next) {
            this.next = next;
        }
    }

    public SLLNode createTillValue(int n) {
        SLLNode head = null;

        if(n == 0) {
            return null;
        }
        if(n >= 1) {
            head = new SLLNode(1);
        }
        SLLNode temp = head;
        for(int i=2; i<n+1; i++) {
            SLLNode node = new SLLNode(i);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public String print(SLLNode head) {
        StringBuilder value = new StringBuilder();
        String separator = "->";

        value.append(head.data);
        SLLNode node = head;
        while(node.next != null) {
            node = node.next;
            value.append(separator);value.append(node.data);
        }
        return value.toString();
    }

    public SLLNode removeDuplicates(SLLNode head){
        SLLNode node = head;
        while(node != null){
            SLLNode next = node.next;
            while (next !=null){
                if(node.data == next.next.data){
                    next = next.next.next;
                }
                if(next != null ){
                    next = next.next;
                }
            }
            node = node.next;
        }
        return head;
    }
}