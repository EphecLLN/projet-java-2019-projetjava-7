package model;

import model.*;
public class Node {
	private BoostVie boost;
	private Node previous;
	private Node next;
	
	public Node(BoostVie c) {
		boost=c;
		previous=null;
		next=null;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public Node getNext() {
		return next;
	}
	public BoostVie getCons(){
		return boost;
	}
	public void setPrevious(Node n) {
		previous=n;
	}
	public void setNext(Node n) {
		next=n;
	}
}
