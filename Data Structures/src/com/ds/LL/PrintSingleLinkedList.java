package com.ds.LL;

public class PrintSingleLinkedList {
    /*
     * This class is to print the list with numbers with specified length
     *
     * Input - 4
     * Output - 1 -> 2 -> 3 -> 4*/

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

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        print(createTillValue(n));
    }

    public static SLLNode createTillValue(int n) {
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

    public static void print(SLLNode head) {
        StringBuilder value = new StringBuilder();
        String separator = "->";

        value.append(head.data);
        SLLNode node = head;
        while(node.next != null) {
            node = node.next;
            value.append(separator);value.append(node.data);
        }
        System.out.println(value.toString());
    }
}
