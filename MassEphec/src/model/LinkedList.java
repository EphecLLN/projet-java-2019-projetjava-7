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
	/*
	 * retourne le premier noeud
	 * @return {Node}
	 */
	public Node getFirst() {
		return first;
	}
	/*
	 * retourne le consommable du dernier noeud
	 * @return {BoostVie}
	 */
	public BoostVie getLast() {
		return last.getCons();
	}
	/*
	 * rplace un noeud en derniere position
	 * @param {BoostVie}
	 */
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
	/*
	 * retire le dernier noeud
	 */
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
