package com.ds.StackAndQueue;

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

    public static void main(String[] args) {
        StackProblems stackProblems = new StackProblems();
        System.out.println(stackProblems.isBalanced("{}{}{{}}[]{[]})"));
    }
}
