package com.ds.practice.stacksqueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Return the overlapping time intervals
 * <p>
 * Input : {(1,5),(2,3),(6,9),(10,11),(7,8)}
 * Output : {(1,5),(6,9),(10,11)}
 * <p>
 * Algorithm:
 * <p>
 * a) Sort the sets in the list
 * b) Prepare the output interval with the starting interval in list
 * c) Remove interval set from list if the interval start value is greater than output interval start and
 *    interval end value is less than output interval end value
 * d) Update the output interval end value with the larger end value in the sets
 */

public class OverLappingTimeIntervals {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval() {

        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static List<Interval> getOverlappingIntervals(List<Interval> intervals) {
        // Sort the elements
        Collections.sort(intervals);
        Interval outPutInterval = new Interval();
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (i == 0) {
                outPutInterval.start = intervals.get(i).start;
                outPutInterval.end = intervals.get(i).end;
            } else {
                // Remove interval set from list if the interval start value is greater than output interval start and
                // interval end value is less than output interval end value
                if (intervals.get(i).start > outPutInterval.start && intervals.get(i).end < outPutInterval.end) {
                    intervals.remove(intervals.get(i));
                }
                // Update the output interval end value with the larger end value in the sets
                outPutInterval.end = intervals.get(i).end;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(6, 9));
        intervals.add(new Interval(10, 11));
        intervals.add(new Interval(7, 8));
        OverLappingTimeIntervals.getOverlappingIntervals(intervals).forEach(obj -> System.out.println("(" + obj.start + "," + obj.end + ")"));
    }
}
