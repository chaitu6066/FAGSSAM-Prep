package com.ds.practice.LL;

import com.ds.practice.utils.SingleLinkedListUtils;
import com.ds.practice.utils.SingleLinkedListUtils.SLLNode;

import org.junit.Assert;
import org.junit.Test;

public class CRUDSingleLinkedListTest {

    CRUDSingleLinkedList crudSingleLinkedList = new CRUDSingleLinkedList();
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

    @Test
    public void deleteTest() {

        Assert.assertEquals("1->2->3->5->6->7->8", utils.print(crudSingleLinkedList.deleteNodeAt(utils.createTillValue(8), 3)));
        Assert.assertEquals("1->2->3->4->5->6->7", utils.print(crudSingleLinkedList.deleteNodeAt(utils.createTillValue(8), 7)));
        Assert.assertNull(crudSingleLinkedList.deleteNodeAt(utils.createTillValue(8), 10));
        Assert.assertEquals("1->2->3->4->5->6->8", utils.print(crudSingleLinkedList.deleteNodeAt(utils.createTillValue(8), 6)));

    }

    @Test
    public void deleteSpecificNode(){
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);one.next = two;
        SLLNode three = new SLLNode(3);two.next = three;
        SLLNode four = new SLLNode(4);three.next = four;
        System.out.println(utils.print(one));
        one.delete(four);
        System.out.println(utils.print(one));
    }

}