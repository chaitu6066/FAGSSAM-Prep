package com.ds.LL;

import org.junit.Assert;
import org.junit.Test;

public class FindLoopSingleLinkedListTest {

    FindLoopSingleLinkedList findLoopSingleLinkedList = new FindLoopSingleLinkedList();

    @Test
    public void test() {
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData1()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData2()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData3()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData4()));
        Assert.assertFalse(findLoopSingleLinkedList.isLoop(testData5()));

    }

    public static FindLoopSingleLinkedList.SLLNode testData5(){
        FindLoopSingleLinkedList.SLLNode one = new FindLoopSingleLinkedList.SLLNode(1);
        FindLoopSingleLinkedList.SLLNode two = new FindLoopSingleLinkedList.SLLNode(2);one.next = two;
        FindLoopSingleLinkedList.SLLNode three = new FindLoopSingleLinkedList.SLLNode(3);two.next = three;
        FindLoopSingleLinkedList.SLLNode four = new FindLoopSingleLinkedList.SLLNode(4);three.next = four;
        FindLoopSingleLinkedList.SLLNode five = new FindLoopSingleLinkedList.SLLNode(5);four.next = five;
        FindLoopSingleLinkedList.SLLNode six = new FindLoopSingleLinkedList.SLLNode(6);five.next = six;
        FindLoopSingleLinkedList.SLLNode seven = new FindLoopSingleLinkedList.SLLNode(7);six.next = seven;
        FindLoopSingleLinkedList.SLLNode eight = new FindLoopSingleLinkedList.SLLNode(8);seven.next = eight;
        return one;
    }

    public static FindLoopSingleLinkedList.SLLNode testData1(){
        FindLoopSingleLinkedList.SLLNode one = new FindLoopSingleLinkedList.SLLNode(1);
        FindLoopSingleLinkedList.SLLNode two = new FindLoopSingleLinkedList.SLLNode(2);one.next = two;
        FindLoopSingleLinkedList.SLLNode three = new FindLoopSingleLinkedList.SLLNode(3);two.next = three;
        FindLoopSingleLinkedList.SLLNode four = new FindLoopSingleLinkedList.SLLNode(4);three.next = four;
        FindLoopSingleLinkedList.SLLNode five = new FindLoopSingleLinkedList.SLLNode(5);four.next = five;
        FindLoopSingleLinkedList.SLLNode six = new FindLoopSingleLinkedList.SLLNode(6);five.next = six;
        FindLoopSingleLinkedList.SLLNode seven = new FindLoopSingleLinkedList.SLLNode(7);six.next = seven;
        FindLoopSingleLinkedList.SLLNode eight = new FindLoopSingleLinkedList.SLLNode(8);seven.next = eight;
        eight.next = four;
        return one;
    }

    public static FindLoopSingleLinkedList.SLLNode testData2(){
        FindLoopSingleLinkedList.SLLNode one = new FindLoopSingleLinkedList.SLLNode(1);
        FindLoopSingleLinkedList.SLLNode two = new FindLoopSingleLinkedList.SLLNode(2);one.next = two;
        two.next = one;
        return one;
    }

    public static FindLoopSingleLinkedList.SLLNode testData3(){
        FindLoopSingleLinkedList.SLLNode one = new FindLoopSingleLinkedList.SLLNode(1);
        FindLoopSingleLinkedList.SLLNode two = new FindLoopSingleLinkedList.SLLNode(2);one.next = two;
        FindLoopSingleLinkedList.SLLNode three = new FindLoopSingleLinkedList.SLLNode(3);two.next = three;
        three.next = one;
        return one;
    }

    public static FindLoopSingleLinkedList.SLLNode testData4(){
        FindLoopSingleLinkedList.SLLNode one = new FindLoopSingleLinkedList.SLLNode(1);
        FindLoopSingleLinkedList.SLLNode two = new FindLoopSingleLinkedList.SLLNode(2);one.next = two;
        FindLoopSingleLinkedList.SLLNode three = new FindLoopSingleLinkedList.SLLNode(3);two.next = three;
        three.next = two;
        return one;
    }

}