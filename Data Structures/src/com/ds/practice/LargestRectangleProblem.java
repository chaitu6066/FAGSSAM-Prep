package com.ds.practice;

import com.ds.practice.utils.SingleLinkedListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestRectangleProblem {

    static int maxArea = 0;
    SingleLinkedListUtils utils = new SingleLinkedListUtils();

    public static void main(String[] args){
        int[] in = {5,7,3,3,9,10,6,1,1,2};
        ArrayList<Integer> inAsList = new ArrayList<>();
        inAsList.add(1);inAsList.add(7);inAsList.add(0);inAsList.add(30);inAsList.add(30);
        inAsList.add(28);inAsList.add(6);inAsList.add(1);inAsList.add(1);inAsList.add(25);
        findLargestArea(inAsList);
        System.out.println(maxArea);
    }

    private static void findLargestArea(ArrayList<Integer> in) {
        if(in.isEmpty()){
            return;
        }
        List<Integer> smallValueIndices = getSmallElementsIndices(in);
        int area = in.size() * in.get(smallValueIndices.get(0));
        if( area > maxArea ){
            maxArea = area;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        for(int i = 0; i<in.size(); i++){
            if(smallValueIndices.contains(i)){
                count ++;
                findLargestArea(temp);
                temp = new ArrayList<>();
                continue;
            }
            if( count == smallValueIndices.size() && i == in.size()-1){
                temp.add(in.get(i));
                findLargestArea(temp);
            }
            temp.add(in.get(i));
        }
    }

    private static Integer getMinValue(ArrayList<Integer> in){
        Integer min = in.get(0);
        for(int i = 1; i<in.size(); i++){
            if (in.get(i) <= min){
                min = in.get(i);
            }
        }
        return min;
    }

    private static List<Integer> getSmallElementsIndices(ArrayList<Integer> in) {
        Integer min = getMinValue(in);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i<in.size(); i++){
            if (in.get(i) == min){
                ret.add(i);
            }
        }
        return ret;
    }
}
