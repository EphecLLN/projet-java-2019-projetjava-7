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
	/*
	 * retourne le  noeud previous
	 * @return {Node}
	 */
	public Node getPrevious() {
		return previous;
	}
	/*
	 * retourne le noeud next
	 * @return {Node}
	 */
	public Node getNext() {
		return next;
	}
	/*
	 * retourne le consommable
	 * @return {BoostVie}
	 */
	public BoostVie getCons(){
		return boost;
	}
	/*
	 * Attribue le noeud previous
	 * @param{Node}
	 */
	public void setPrevious(Node n) {
		previous=n;
	}
	/*
	 * Attribue le noeud next
	 * @param{Node}
	 */
	public void setNext(Node n) {
		next=n;
	}
}
