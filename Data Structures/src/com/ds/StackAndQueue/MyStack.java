package com.ds.StackAndQueue;

class StackNode {
    int data;
    StackNode next;
    public StackNode(int data) {
        this.data = data;
    }
}
public class MyStack {
    StackNode top;

    void push(int data) {
        if (top == null) {
            top = new StackNode(data);
            return;
        }
        StackNode temp = new StackNode(data);
        temp.next = top;
        top= temp;
    }

    int pop() {
        if (top != null) {
            int result = top.data;
            top = top.next;
            return result;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(20);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
