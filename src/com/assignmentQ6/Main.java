package com.assignmentQ6;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();
        
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the string ");
        String str=scan.nextLine();
        System.out.println(validator.isValid(str));

    }
}
