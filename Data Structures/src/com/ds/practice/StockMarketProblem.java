package com.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMarketProblem {

    static class DoubleLinkedListNode {
        int data;
        DoubleLinkedListNode next;
        DoubleLinkedListNode prev;

        DoubleLinkedListNode(int data){
            this.data = data;
        }

        int compareTo(DoubleLinkedListNode node){
            if(data >= node.data){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        Integer[] in = {100, 80, 60, 70, 60, 75, 85, 120};

        DoubleLinkedListNode node = createDLLFromArray(in);
        generate(node).forEach(data -> System.out.print( data +","));
    }

    static ArrayList<Integer> generate(DoubleLinkedListNode node){

        ArrayList<Integer> list = new ArrayList<>();
        if(node == null){
            list.add(1);
            return list;
        }
        while(node != null){
            DoubleLinkedListNode prev = node.prev;
            int count = 1;
            while(prev != null){
                if (node.compareTo(prev) < 0){
                    break;
                }else{
                    count ++;
                }
                prev = prev.prev;
            }
            list.add(count);
            node = node.next;
        }
        return list;
    }

    static DoubleLinkedListNode createDLLFromArray(Integer[] in){
        List<Integer> inAsList = Arrays.asList(in);
        DoubleLinkedListNode head = new DoubleLinkedListNode(inAsList.get(0));
        DoubleLinkedListNode tmp = head;
        for(int i=1; i < inAsList.size(); i++){
            DoubleLinkedListNode node = new DoubleLinkedListNode(inAsList.get(i));
            tmp.next = node;
            node.prev = tmp;
            tmp = node;
        }
        return head;
    }
}
