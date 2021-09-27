package com.ds.LL.practice;

import org.junit.Test;
import com.ds.LL.practice.SingleLinkedListUtils.SLLNode;

import static org.junit.jupiter.api.Assertions.*;

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