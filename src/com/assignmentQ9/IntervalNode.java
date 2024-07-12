package com.assignmentQ9;

import java.util.ArrayList;
import java.util.List;

class IntervalNode {
    int start;
    int end;
    IntervalNode left;
    IntervalNode right;
    List<int[]> overlappingIntervals;

    public IntervalNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.overlappingIntervals = new ArrayList<>();
    }
}
