package com.ds.LL.practice;

import org.junit.Test;

public class ApplicationsOfSingleLinkedListTest {

    ApplicationsOfSingleLinkedList sll = new ApplicationsOfSingleLinkedList();
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

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