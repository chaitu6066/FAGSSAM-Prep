package com.ds.StackAndQueue;

public class QueueProblems {
    int getMaxSum(int input[], int windowLen) {
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        for (int i=0;i<windowLen;i++) {
            result += input[i];
        }
        int currentMax = result;
        for (int i=windowLen;i<input.length;i++) {
            currentMax =  currentMax + input[i] - input[i-windowLen];
            if (currentMax > result) {
                result = currentMax;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        QueueProblems qp = new QueueProblems();
        int arr[] = { 1, 2, 3, 40, 5, 6, 7, 8, 9, 10 };
        int k = 4;
        System.out.println(qp.getMaxSum(arr,k));
    }
}
