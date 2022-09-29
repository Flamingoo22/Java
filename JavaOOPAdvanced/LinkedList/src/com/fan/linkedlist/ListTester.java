package com.fan.linkedlist;

import com.fan.linkedlist.models.SinglyLinkedList;

public class ListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList sl1 = new SinglyLinkedList();
        sl1.add(3);
        sl1.add(4);
        sl1.add(10);
        sl1.add(5);
        sl1.add(15);
        sl1.add(2);
        sl1.printValues();
        sl1.removeAt(3);
        System.out.println(sl1.find(5));
        System.out.println(sl1.find(99));
        sl1.printValues();
	}

}
