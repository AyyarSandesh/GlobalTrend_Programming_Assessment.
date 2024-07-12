package com.assignmentQ8;

import java.util.Random;
import java.util.Scanner;

public class KthLargetElement {
	 public int findKthLargest(int[] nums, int k) {
	        return quickselect(nums, 0, nums.length - 1, nums.length - k);
	    }

	    private int quickselect(int[] nums, int left, int right, int k) {
	        if (left == right) {
	            return nums[left];
	        }

	        Random random = new Random();
	        int pivotIndex = left + random.nextInt(right - left);
	        pivotIndex = partition(nums, left, right, pivotIndex);

	        if (k == pivotIndex) {
	            return nums[k];
	        } else if (k < pivotIndex) {
	            return quickselect(nums, left, pivotIndex - 1, k);
	        } else {
	            return quickselect(nums, pivotIndex + 1, right, k);
	        }
	    }

	    private int partition(int[] nums, int left, int right, int pivotIndex) {
	        int pivotValue = nums[pivotIndex];
	        swap(nums, pivotIndex, right); // Move pivot to end
	        int storeIndex = left;

	        for (int i = left; i < right; i++) {
	            if (nums[i] < pivotValue) {
	                swap(nums, storeIndex, i);
	                storeIndex++;
	            }
	        }

	        swap(nums, right, storeIndex); // Move pivot to its final place
	        return storeIndex;
	    }

	    private void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }

	    public static void main(String[] args) {
	    	 KthLargetElement solution = new  KthLargetElement();
	    	 Scanner scan=new Scanner(System.in);
	    	 System.out.println("Enter the size of array");
	    	 int size=scan.nextInt();
	        int[] nums =new int[size];
	        System.out.println("Enter the element of array");
	        for(int i=0;i<nums.length;i++) {
	        	nums[i]=scan.nextInt();
	        }
	        System.out.println("Enter the k element ");
	        int k = scan.nextInt();
	        System.out.println("The " + k + "th largest element is " + solution.findKthLargest(nums, k)); 
	    }
}
