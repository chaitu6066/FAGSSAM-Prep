package com.ds.practice.stacksqueues;

import java.util.Arrays;
import java.util.Stack;

public class StockPriceProblem {
    public int[] getStockPriceVariations(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (i == 0) { // inserting for initial value
                stack.push(i);
                result[i] = 1;
            } else {
                if (input[i] <= input[stack.peek()]) {
                    result[i] = 1;
                } else {
                    stack.pop(); // popping the element if we found the larger value than the peek o the stack
                    result[i] = i - stack.peek();
                }
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StockPriceProblem stockPriceProblem = new StockPriceProblem();
        int[] input = {100, 80, 60, 70, 60, 75, 85};
        Arrays.stream(stockPriceProblem.getStockPriceVariations(input)).forEach(System.out::print);

    }
}
