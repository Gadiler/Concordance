package linkedListPackage;

import java.io.PrintWriter;

public class Node {

	protected int line;
	protected Node next;

	public Node() {
		next = null;
		line = 0;
	}

	public Node(int line) {
		this.line = line;
		this.next = null;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getLine() {
		return line;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	// Display the lines list into file.
	public void displayLines(PrintWriter out) {
		out.print(" " + getLine() + (next == null ? "" : ","));
	}

	public void displayLines() {
		System.out.print(" " + getLine() + (next == null ? "" : ","));
	}
}
