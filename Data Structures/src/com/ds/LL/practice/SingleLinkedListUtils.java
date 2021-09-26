package com.ds.LL.practice;

import java.util.ArrayList;
import java.util.HashSet;

public class SingleLinkedListUtils {
    public static class SLLNode {
        int data;
        SLLNode next;

        SLLNode(int data) {
            this.data = data;
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

}