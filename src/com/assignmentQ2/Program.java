package com.assignmentQ2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Program {

	public static void main(String[] args) {
		ArrayList al=new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		int count=50;
		try {
			for(Object x:al) {
				System.out.print(x+" ");
				al.add(count);
				count+=10;
			}
		}catch(ConcurrentModificationException e) {
			System.out.println("Caught ConcurrentModificationException: " + e);
		}
	}

}
