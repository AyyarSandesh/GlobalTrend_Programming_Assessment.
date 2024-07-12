package com.assignmentQ9;

import java.util.ArrayList;
import java.util.List;

public class IntervalTree {
    private IntervalNode root;

    public IntervalTree() {
        this.root = null;
    }

    public void insertInterval(int start, int end) {
        root = insert(root, start, end);
    }

    private IntervalNode insert(IntervalNode node, int start, int end) {
        if (node == null) {
            return new IntervalNode(start, end);
        }

        if (start <= node.start) {
            node.left = insert(node.left, start, end);
        } else {
            node.right = insert(node.right, start, end);
        }

        // Update overlapping intervals for current node
        if (doOverlap(node.start, node.end, start, end)) {
            node.overlappingIntervals.add(new int[]{start, end});
        }

        return node;
    }

    public void deleteInterval(int start, int end) {
        root = delete(root, start, end);
    }

    private IntervalNode delete(IntervalNode node, int start, int end) {
        if (node == null) {
            return null;
        }

        if (start < node.start) {
            node.left = delete(node.left, start, end);
        } else if (start > node.start) {
            node.right = delete(node.right, start, end);
        } else {
            if (end == node.end) {
                // Found the node to delete
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    IntervalNode successor = findMin(node.right);
                    node.start = successor.start;
                    node.end = successor.end;
                    node.right = delete(node.right, successor.start, successor.end);
                }
            } else {
                node.right = delete(node.right, start, end);
            }
        }

        // Update overlapping intervals for current node
        updateOverlappingIntervals(node);

        return node;
    }

    private IntervalNode findMin(IntervalNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public List<int[]> findOverlappingIntervals(int start, int end) {
        List<int[]> result = new ArrayList<>();
        findOverlapping(root, start, end, result);
        return result;
    }

    private void findOverlapping(IntervalNode node, int start, int end, List<int[]> result) {
        if (node == null) {
            return;
        }

        // If the node overlaps with [start, end], add its overlapping intervals to result
        if (doOverlap(node.start, node.end, start, end)) {
            result.addAll(node.overlappingIntervals);
        }

        // Traverse left if necessary
        if (node.left != null && node.left.end >= start) {
            findOverlapping(node.left, start, end, result);
        }

        // Traverse right if necessary
        if (node.right != null && node.start <= end) {
            findOverlapping(node.right, start, end, result);
        }
    }

    private boolean doOverlap(int start1, int end1, int start2, int end2) {
        return !(end1 < start2 || start1 > end2);
    }

    private void updateOverlappingIntervals(IntervalNode node) {
        node.overlappingIntervals.clear();
        if (node.left != null) {
            node.overlappingIntervals.addAll(node.left.overlappingIntervals);
        }
        if (node.right != null) {
            node.overlappingIntervals.addAll(node.right.overlappingIntervals);
        }
        if (doOverlap(node.start, node.end, node.start, node.end)) {
            node.overlappingIntervals.add(new int[]{node.start, node.end});
        }
    }

}

