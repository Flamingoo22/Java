package com.fan.linkedlist.models;

public class SinglyLinkedList {
    public Node head;
    private static int length = 0;
    public SinglyLinkedList() {
        // your code here
    	this.head = null;
    	
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        length++;
    }
    
    public Node remove() {
    	if(this.head == null) {
    		return new Node(0);
    	}
    	else {
    		Node preNode = this.head;
    		Node runner = this.head.next;
    		while(runner.next!= null) {
    			preNode = runner;
    			runner = runner.next;
    		}
    		preNode.next = null;
    		length --;
    		return runner;
    	}
    }
    
    public Node find(int value) {
    	if(head == null) {
    		return new Node(0);
    	}
    	else {
    		Node runner = this.head;
    		while(runner.value != value) {
    			runner = runner.next;
    			if(runner == null) {
    				return new Node(0);
    			}
    		}
    		return runner;
    	}
    }
    
    public Node removeAt(int num) {
    	if (num > length) {
    		System.out.println("TOO BIG");
    		return new Node(0);
    	}
    	else if (num == length) {
    		System.out.println("BACK");
    		return this.remove();
    	}
    	else {
    		int index = 0;
    		Node prevNode = this.head;
    		Node runner = prevNode.next;
    		while(index < num) {
    			prevNode = runner;
    			runner = runner.next;
    			index++;
    		}
    		System.out.println("WE HERE");
    		prevNode.next = runner.next;
    		runner.next = null;
    		length --;
    		return runner;
    	}
    }
    
    public void printValues() {
    	Node runner = this.head;
    	while(runner!= null) {
    		System.out.println(runner.value);
    		runner = runner.next;
    	}
    	System.out.println("**************\n\n");
    }
    
    
}
