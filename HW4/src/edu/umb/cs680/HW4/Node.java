package edu.umb.cs680.HW4;

public class Node {
	
	long key;
	long value;
	int frequency;
	Node prev;
	Node next;
 
    public Node(long key, long value, int frequency){
        this.key   = key;
        this.value = value;
        this.frequency = frequency;
    }
}