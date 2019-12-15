package model;

import model.*;
public class Node {
	private Consommables cons;
	private Node previous;
	private Node next;
	
	public Node(Consommables c) {
		cons=c;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public Node getNext() {
		return next;
	}
	public Consommables getCons(){
		return cons;
	}
	public void setPrevious(Node n) {
		previous=n;
	}
	public void setNext(Node n) {
		next=n;
	}
}
