package model;

import model.*;

public class LinkedList {
	private Node first;
	private Node last;
	private int size;
	public LinkedList() {
		size=0;
		first=null;
		last=null;
	}
	public BoostVie getFirst() {
		return first.getCons();
	}
	public BoostVie getLast() {
		return last.getCons();
	}
	public void setNode(BoostVie c) {
		Node n= new Node(c);
		if(size==0) {
			first=n;
			last=n;
		}
		else if(size==1){
			first.setNext(n);
			last=n;
			n.setPrevious(first);
		}
		else {
			Node buffer=last;
			last=n;
			buffer.setNext(n);
			n.setPrevious(buffer);
		}
		size++;
	}
	public void removeLast() {
		if(last!=null) {
			if(size==1) {
				first=null;
				last=null;
				size--;
			}else {
				last=last.getPrevious();
				last.setNext(null);
				size--;
			}
		}
	}
}
