package com.fan.linkedlist.models;

public class Node {

    public int value;
    public Node next;
    public Node(int value) {
        // your code here
    	this.value = value;
    	this.next = null;
    }
    
    public String toString() {
    	return Integer.toString(this.value);
    }

}
