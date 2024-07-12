package com.assignmentQ9;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntervalTree intervalTree = new IntervalTree();

        intervalTree.insertInterval(15, 20);
        intervalTree.insertInterval(10, 30);
        intervalTree.insertInterval(5, 25);
        intervalTree.insertInterval(12, 22);
        intervalTree.insertInterval(17, 19);

        // Find all intervals overlapping with [14, 23]
        List<int[]> overlappingIntervals = intervalTree.findOverlappingIntervals(14, 23);
        System.out.println("Intervals overlapping with [14, 23]: ");
        for (int[] interval : overlappingIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        // Delete the interval [12, 22]
        intervalTree.deleteInterval(12, 22);

        // Find all intervals overlapping with [14, 23] after deletion
        overlappingIntervals = intervalTree.findOverlappingIntervals(14, 23);
        System.out.println("\nIntervals overlapping with [14, 23] after deletion of [12, 22]: ");
        for (int[] interval : overlappingIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
