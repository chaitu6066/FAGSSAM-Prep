package com.ds.practice.StackQueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ApplicationsOfStack {

    /*
     * 1.Given a set of interval pairs, i/p - { (1,5), (2,3), (7,9), (6,8), (10,11) }
     *   Find the overlapping intervals. o/p - { (1,5), (6,9), (10,11) }
     *
     * Algo -
     *   i. Sort the given pairs based on the left value. { (1,5), (2,3), (6,8), (7,9), (10,11) }
     *   ii. Put the starting pair in the Output Array. Now compare it with the other pairs in the order, there will be only 4 possible outcomes.
     *       if(a < l && l < b && r < b ){ (a,b) }
     *       if(a < l && l < b && r > b ){ (a,r) }
     *       if(l < a && a < r && r < b ){ (l,b) }
     *       if(a < l && b < l ){ (l,r) } and do the same when we reach the end of the Input array.
     *
     * 2.How much rain water will be trapped between all the buildings.Heights of the buildings is given as an array.
     *      i/p - {4,2,0,5,2,0,6,0,2,0,4}
     *      o/p - 24.
     *
     * Algo -
     *   i.
     *
     * 3.Maximum are of a rectangle that can be formed in a histogram. Given the heights of Bars in an array.
     *      i/p - {4,2,5,5} o/p-10.
     * Algo -
     *      i. At any given bar find the nearest smaller bars towards it's right & left. And calculate (right index - left index + 1) * bar height.
     *          Do this for every bar, which ever value is higher it is the maximum area of a rectangle that can be formed.
     *      ii.To find out we need to find the nearest smaller bar towards left for all bars, and also towards its right.
     *      iii.This we can do by iterating for the current bar towards its left to find the smaller & and also towards right. To do this for each
     *          bar we need to iterate for 1 bars over N times to find the smallest one. So Time Complexity is O(n*n).
     *      iv.To perform this operation efficiently, we need to have an array which tells us the smallest left/right bar index for a given bar.
     *          To do this we need to iterate over a given array and populate the s-left-array.
     *              Initialize stack to store the heights of bars in ascending order till the current bar height at any given bar.
     *              The value to be put into the bar is the st.top()+1.
     *          To populate the s-right-array. Iterate from reverse of the array and perform the same logic.
     *      * */

    public Integer maximumRectangleArea(ArrayList<Integer> heights){

        ArrayList<Integer> sLeft = new ArrayList<>();
        ArrayList<Integer> sRight = new ArrayList<>();

        Stack<Integer> tempStack = new Stack<>();

        for(int i=0; i< heights.size(); i++){
            if(tempStack.empty()){
                tempStack.push(i);
                sLeft.add(i);
                continue;
            }
            if(heights.get(i) > heights.get(tempStack.peek())){
                tempStack.push(i);
                sLeft.add(i);
            }else{
                tempStack.pop();
                if(tempStack.empty()){
                    tempStack.push(0);
                    sLeft.add(0);
                    continue;
                }
                while(heights.get(i) < heights.get(tempStack.peek())){
                    tempStack.pop();
                }
                sLeft.add(tempStack.peek()+1);
                tempStack.push(i);
            }
        }

        return 0;
    }

    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public ArrayList<Pair> overLappingIntervals(ArrayList<Pair> input) {
        //TODO Consider the input Array is sorted.

        ArrayList<Pair> output = new ArrayList<>();
        for(int i=0; i< input.size(); i++){
            if(i == 0){
                output.add(input.get(i));
            }else {
                Pair tmp = compare(output.get(output.size()-1), input.get(i));
                if(tmp.equals(input.get(i))){
                    output.add(tmp);
                }else{
                    output.remove(output.size()-1);
                    output.add(tmp);
                }
            }
        }
        return output;
    }

    Pair compare(Pair outArr, Pair inArr) {
        if (outArr.start <= inArr.start && inArr.start <= outArr.end && inArr.end <= outArr.end) {
            return outArr;
        } else if (outArr.start <= inArr.start && inArr.start <= outArr.end && inArr.end >= outArr.end) {
            return new Pair(outArr.start, inArr.end);
        } else if (inArr.start <= outArr.start && outArr.start <= inArr.end && inArr.end <= outArr.end) {
            return new Pair(inArr.start, outArr.end);
        } else if (outArr.start <= inArr.start && outArr.end <= inArr.start) {
            return inArr;
        } else {
            return outArr;
        }
    }
}
