package com.ds.practice.StackQueues;

import com.ds.practice.utils.SingleLinkedListUtils;
import org.junit.Test;

public class StackImplTest {

    StackImpl stack = new StackImpl();
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

    @Test
    public void test(){
        stack.push(55);
        System.out.println(utils.print(stack.head));
        stack.push(2);stack.push(3);stack.push(4);
        System.out.println(utils.print(stack.head));
        System.out.println(stack.pop());
        System.out.println(utils.print(stack.head));
        stack.pop();stack.pop();
        System.out.println(utils.print(stack.head));

        stack.pop();stack.pop();

    }

}