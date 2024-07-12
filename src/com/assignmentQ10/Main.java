package com.assignmentQ10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the String");
        String str1 = scan.nextLine();
        System.out.println("\"" + str1 + "\" is a palindrome: " + checker.isPalindrome(str1));
    }
}
