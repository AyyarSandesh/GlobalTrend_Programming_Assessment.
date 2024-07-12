package com.assignmentQ7;

import java.util.Scanner;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the current area
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            
            // Update max area if current area is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter size of the array");
        int size=scan.nextInt();
        int[] heights = new int[size];
        System.out.println("Enter the heights");
        for(int i=0;i<heights.length;i++){
        	heights[i]=scan.nextInt();
        }
        System.out.println("Maximum area: " + solution.maxArea(heights));
    }
}
