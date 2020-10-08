package linkedListPackage;

import java.io.PrintWriter;

public class SinglyLinkedList {

	protected String word;
	protected Node head, tail;
	protected SinglyLinkedList next;

	/* @param word - any SinglyLinkedList (-> SLL) have word as data.
	 * 
	 * @param head - reference to the first node at the list of lines.
	 * 
	 * @param tail - reference to the last node at the list of lines.
	 * 
	 * @param next - reference to the next SLL (next word by the alphabetic order).
	 */

	// Constructor
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Constructor
	public SinglyLinkedList(String word, int line) {
		this.word = word;
		insert(line);
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node n) {
		tail.next = n;		
		tail = n;
	}
	
	public SinglyLinkedList getNext() {
		return next;
	}

	public void setNext(SinglyLinkedList n) {
		if (next == null) {
			next = n;
		}else {
			n.next = getNext();
			next = n;
		}
	}

	// Function to check if list is empty
	public boolean isEmpty() {
		return head == null;
	}

	public String getWord() {
		return word;
	}

	public void insert(int line) {
		if (head == null) {
			head = new Node(line);
			tail = head;
		} else  { 		// if (tail.line != line) -> terms of line repeat.
			tail.setNext(new Node(line));
			tail = tail.getNext();
		}
	}

	public void display(PrintWriter out) {
		// in case there is only one node.
		if (head.next == null) {
			out.print(getWord());
			head.displayLines(out);
			out.println();
			return;
		}
		// in case there is more than 1 nodes.
		Node temp = head;
		out.print(getWord());
		while (temp != null) {
			temp.displayLines(out);
			temp = temp.next;
		}
		out.println();
	}

	public void display() {
		// in case there is only one node.
		if (head.next == null) {
			System.out.print(getWord());
			head.displayLines();
			System.out.println();
			return;
		}
		// in case there is more than 1 nodes.
		Node temp = head;
		System.out.print(getWord());
		while (temp != null) {
			temp.displayLines();
			temp = temp.next;
		}
		System.out.println();
	}

}
