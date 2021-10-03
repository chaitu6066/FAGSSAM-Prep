package com.ds.practice.StackQueues;

import org.junit.Test;
import com.ds.practice.StackQueues.ApplicationsOfStack.Pair;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationsOfStackTest {

    public ApplicationsOfStack ofStack = new ApplicationsOfStack();

    @Test
    public void testMaximumRectangleArea(){
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(4);heights.add(2);heights.add(10);heights.add(11);heights.add(4);heights.add(3);
        System.out.println(ofStack.maximumRectangleArea(heights));
    }

    @Test
    public void testOverlap(){
        Pair one = new Pair(1,5);
        Pair two = new Pair(2,3);
        Pair three = new Pair(6,10);
        Pair four = new Pair(7,9);
        Pair five = new Pair(10,11);
        ArrayList<Pair> inArr = new ArrayList<>();
        inArr.add(one);inArr.add(two);inArr.add(three);inArr.add(four);inArr.add(five);
        ofStack.overLappingIntervals(inArr).forEach(pair -> {
            System.out.println("("+pair.start +","+pair.end+")");
        });
    }
}