package com.assignmentQ1;

import java.util.HashMap;
import java.util.Scanner;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Enter the Capacity of cache memeory");
    	int capacity=scan.nextInt();
    	if(capacity<=100000) {
    		LRUCache cache = new LRUCache(capacity);
    		while(true) {
    			System.out.println("press 1 to put");
    			System.out.println("press 2 to get");
    			System.out.println("Enter your choice");
    			int choice=scan.nextInt();
    			switch(choice) {
	    			case 1:
	    				System.out.println("Enter the key");
	    				int key=scan.nextInt();
	    				System.out.println("Enter the value");
	    				int value=scan.nextInt();
	    				cache.put(key, value);
	    				break;
	    			case 2:
	    			
	    				System.out.println("Enter the key to get cache");
	    				System.out.println(cache.get(scan.nextInt()));
	    				break;
	    			default:System.exit(0);
	    		}
    		}
    	}else {
    		System.out.println("Please Enter a capacity between 1 to 100000");
    	}
    }
}


