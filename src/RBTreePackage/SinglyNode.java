package RBTreePackage;

import java.io.PrintWriter;

public class SinglyNode {

	protected int line;
	protected SinglyNode next;
	
	/*@param line - the data of the LinkedList. 
	 * 
	 *@param next - the next node at the list of lines. 
	 * 
	 */

	public SinglyNode() {
		next = null;
		line = 0;
	}

	public SinglyNode(int line) {
		this.line = line;
		this.next = null;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getLine() {
		return line;
	}

	public SinglyNode getNext() {
		return next;
	}

	public void setNext(SinglyNode next) {
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
