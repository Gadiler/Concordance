package RBTreePackage;

import java.io.PrintWriter;

public class LinkedList {

	protected String word;
	protected SinglyNode head, tail;
	private int size = 0;

	/*
	 * @param word - any LinkedList have word as data.
	 * 
	 * @param head - reference to the first node at the list.
	 * 
	 * @param tail - reference to the last node at the list.
	 * 
	 * @param size - count of how often each word appears.
	 */

	// Constructor
	public LinkedList() {
		this.head = null;
		this.tail = null;
		word = "";
	}

	// Constructor
	public LinkedList(String word, SinglyNode head, SinglyNode tail, int size) {
		this.word = word;
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public SinglyNode getHead() {
		return head;
	}

	public void setHead(SinglyNode head) {
		this.head = head;
	}

	public SinglyNode getTail() {
		return tail;
	}

	public void setTail(SinglyNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	// Function to check if list is empty
	public boolean isEmpty() {
		return head == null;
	}

	public String getWord() {
		return word;
	}

	public void insertSinglyNode(int line) {
		if (head == null) {
			head = new SinglyNode(line);
			tail = head;
		} else { // if (tail.line != line) -> terms of line repeat.
			tail.setNext(new SinglyNode(line));
			tail = tail.getNext();
		}
		size++;
	}

	public void display(PrintWriter out) {
		// in case there is only one node.
		if (head.next == null) {
			out.print(getWord() + " {" + size + " time}");
			head.displayLines(out);
			out.println();
			return;
		}
		// in case there is more than 1 nodes.
		SinglyNode temp = head;
		out.print(getWord() + " {" + size + " times}");
		while (temp != null) {
			temp.displayLines(out);
			temp = temp.next;
		}
		out.println();
	}

	public void display() {
		// in case there is only one node.
		if (head.next == null && size == 1) {
			System.out.print(getWord() + "{" + size + " time}");
			head.displayLines();
			return;
		}
		// in case there is more than 1 nodes.
		SinglyNode temp = head;
		System.out.print(getWord() + "{" + size + " times}");
		while (temp != null) {
			temp.next.displayLines();
			temp = temp.next;
		}
	}

}
