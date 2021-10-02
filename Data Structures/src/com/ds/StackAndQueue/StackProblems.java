package com.ds.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class StackProblems {

    boolean isBalanced(String input) {
        Stack<Character> s = new Stack<>();

        for (int i=0;i<input.length();i++) {
            char cc = input.charAt(i);
            if (cc == '[' || cc == '{' ||cc == '(') {
                s.push(cc);
                continue;
            }
            if (s.isEmpty()) {
                return false;
            }
            switch (cc) {
                case '}':
                    if (s.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (s.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (s.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        return s.isEmpty();
    }

    int largestRectangleInHistogram(int ip[]) {
        Stack<Integer> s = new Stack<>();
        int lmax[] = new int[ip.length];
        int rmax[] = new int[ip.length];
        lmax[0] = 0;
        s.add(0);

        for (int i=1;i<ip.length;i++) {
            if (s.isEmpty()){
                lmax[i] = 0;
            } else {
                while (!s.isEmpty() && ip[s.peek()] >= ip[i]){
                    s.pop();
                }
                lmax[i] = s.isEmpty() ? 0 : s.peek()+1;
                s.push(i);
            }
        }
        s = new Stack<>();
        s.add(ip.length-1);

        for (int i=ip.length-1;i>=0;i--) {
            if (s.isEmpty()){
                rmax[i] = ip.length-1;
            } else {
                while (!s.isEmpty() && ip[s.peek()] >= ip[i]){
                    s.pop();
                }
                rmax[i] = s.isEmpty() ? ip.length-1 : s.peek()-1;
                s.push(i);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ip.length; i++) {
            int currentMax = ip[i] * (rmax[i]-lmax[i] +1);
            if(currentMax > max)
                max = currentMax;
        }
        return max;
    }

    public static void main(String[] args) {
        StackProblems stackProblems = new StackProblems();
        System.out.println(stackProblems.isBalanced("{}{}{{}}[]{[]})"));
        System.out.println(stackProblems.largestRectangleInHistogram(new int[]{2,2,5,6,2,3,2,2,2,
                2,2,2
        }));
        System.out.println(stackProblems.largestRectangleInHistogram(new int[]{4,2,10,11,4,3}));
    }
}
