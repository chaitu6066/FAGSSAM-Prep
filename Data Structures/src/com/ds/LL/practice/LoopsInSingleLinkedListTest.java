package com.ds.LL.practice;

import org.junit.Assert;
import org.junit.Test;
import com.ds.LL.practice.SingleLinkedListUtils.SLLNode;

public class LoopsInSingleLinkedListTest {

    LoopsInSingleLinkedList findLoopSingleLinkedList = new LoopsInSingleLinkedList();

    @Test
    public void test() {
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData1()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData2()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData3()));
        Assert.assertTrue(findLoopSingleLinkedList.isLoop(testData4()));
        Assert.assertFalse(findLoopSingleLinkedList.isLoop(testData5()));

    }

    public SLLNode testData5(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        SLLNode three = new SLLNode(3);two.next = three;
        SLLNode four = new SLLNode(4);three.next = four;
        SLLNode five = new SLLNode(5);four.next = five;
        SLLNode six = new SLLNode(6);five.next = six;
        SLLNode seven = new SLLNode(7);six.next = seven;
        SLLNode eight = new SLLNode(8);seven.next = eight;
        return one;
    }

    public SLLNode testData1(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        SLLNode three = new SLLNode(3);two.next = three;
        SLLNode four = new SLLNode(4);three.next = four;
        SLLNode five = new SLLNode(5);four.next = five;
        SLLNode six = new SLLNode(6);five.next = six;
        SLLNode seven = new SLLNode(7);six.next = seven;
        SLLNode eight = new SLLNode(8);seven.next = eight;
        eight.next = four;
        return one;
    }

    public SLLNode testData2(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        two.next = one;
        return one;
    }

    public SLLNode testData3(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        SLLNode three = new SLLNode(3);two.next = three;
        three.next = one;
        return one;
    }

    public SLLNode testData4(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        SLLNode three = new SLLNode(3);two.next = three;
        three.next = two;
        return one;
    }

}