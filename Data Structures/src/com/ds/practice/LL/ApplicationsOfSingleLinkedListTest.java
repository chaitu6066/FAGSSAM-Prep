package com.ds.practice.LL;

import com.ds.practice.utils.SingleLinkedListUtils;
import org.junit.Test;
import com.ds.practice.utils.SingleLinkedListUtils.SLLNode;

public class ApplicationsOfSingleLinkedListTest {

    ApplicationsOfSingleLinkedList sll = new ApplicationsOfSingleLinkedList();
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

    @Test
    public void findKthLastElementTest(){
        System.out.println(utils.print(utils.createTillValue(10)));
        System.out.println(sll.findKthLastElement(utils.createTillValue(10), 5).data);
        System.out.println(sll.findKthLastElement(utils.createTillValue(10), 10).data);
        System.out.println(sll.findKthLastElement(utils.createTillValue(10), 11));
        System.out.println(sll.findKthLastElement(utils.createTillValue(10), 1).data);

    }

    @Test
    public void removeDupsTest(){
        SLLNode one = new SLLNode(2);
        SLLNode two = new SLLNode(3);one.next = two;
        SLLNode three = new SLLNode(2);two.next = three;
        SLLNode four = new SLLNode(1);three.next = four;
        SLLNode five = new SLLNode(3);four.next = five;

        System.out.println(utils.print(utils.removeDuplicates(one)));
    }
    @Test
    public void printCirclesTest(){
        System.out.println(utils.print(utils.createTillValue(3)));
        System.out.println(utils.print(sll.printListAsCircles(utils.createTillValue(3))));
        System.out.println(utils.print(utils.createTillValue(4)));
        System.out.println(utils.print(sll.printListAsCircles(utils.createTillValue(4))));
        System.out.println(utils.print(utils.createTillValue(1)));
        System.out.println(utils.print(sll.printListAsCircles(utils.createTillValue(1))));
        System.out.println(utils.print(utils.createTillValue(17)));
        System.out.println(utils.print(sll.printListAsCircles(utils.createTillValue(17))));
        System.out.println(utils.print(utils.createTillValue(16)));
        System.out.println(utils.print(sll.printListAsCircles(utils.createTillValue(16))));
    }

    @Test
    public void reverseTest(){
        System.out.println(utils.print(sll.reverse(utils.createTillValue(4))));
        System.out.println(utils.print(sll.reverse(utils.createTillValue(5))));
    }

    @Test
    public void rotateTest(){
        System.out.println(utils.print(sll.rotateSLL(utils.createTillValue(3), 2)));
        System.out.println(utils.print(sll.rotateSLL(utils.createTillValue(3), 3)));
        System.out.println(utils.print(sll.rotateSLL(utils.createTillValue(3), 13)));
        System.out.println(utils.print(sll.rotateSLL(utils.createTillValue(3), 14)));
        System.out.println(utils.print(sll.rotateSLL(utils.createTillValue(1), 17)));

    }


}