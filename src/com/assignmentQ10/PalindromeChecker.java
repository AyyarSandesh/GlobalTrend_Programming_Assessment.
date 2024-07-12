package com.assignmentQ10;

public class PalindromeChecker {
	public boolean isPalindrome(String s) {
        // Convert to lowercase and remove non-alphanumeric characters
        String normalized = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
