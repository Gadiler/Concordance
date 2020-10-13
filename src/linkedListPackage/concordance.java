package linkedListPackage;

import java.util.*;

import RBTreePackage.TextReader;

import java.io.*;

public class concordance {

	static TextReader in; // An input stream for reading the input file.
	static PrintWriter out; // Output stream for writing the output file.

	static long startTime = System.currentTimeMillis();
	static LinkedList index0 = new LinkedList();
	static int size = 0;

	// This LinkedList holds the concordance. Words from the file
	// are used as keys in the list. The value associated with
	// each word is a node that contains the line numbers on which
	// the word occurs in the file. The node contains values
	// belonging to the wrapper class, Integer.

	public concordance() {

		openFiles(); // Open input and output files.

		int lineNum = 1; // The number of the line in the input
							// file that is currently begin processed.

		while (true) {
			while (in.peek() != '\0' && !Character.isLetter(in.peek())) {
				// Skip over non-letter characters, stopping when
				// end-of-file ('\0') or a letter is seen. If the
				// character is an end-of-line character, add one
				// to lineNum to reflect that fact that we are moving
				// on to the next line in the file.
				char ch = in.getAnyChar();
				if (ch == '\n') {
					lineNum++; // Start a new line.
				}
			}
			if (in.eof()) {
				// The end-of-file has been reached, so exit from the loop.
				break;
			}
			String word = in.getAlpha(); // The next word from the file.
			if (word.length() > 2 && !word.equalsIgnoreCase("the")) {
				// Add the reference to word to the concordance, unless
				// the word is "the" or the word has length <= 2.
				addReference(word, lineNum);
			}
		}

		printConcordance(); // Print the data to the output file.

		if (out.checkError()) {
			// Some error occurred on the output stream.
			System.out.println("An error occurred while writing the data.");
			System.out.println("Output file might be missing or incomplete.");
			System.exit(1);
		}
		System.out.println(size + " distinct words were found at the Linked List.");
		long endTime = System.currentTimeMillis();
		System.out.println("Time measure for Linked List EXAMPLE: " + (endTime - startTime) + "-Milli Second\n");
	}

	static void openFiles() {
		// Open the global variable "in" as an input file with name
		// "inputText". Open the global variable "out" as an output
		// file with name "outputText".
		// If an error occurs while trying to open the files, then an
		// error message is printed and the program will be terminated.
		try {
			in = new TextReader(new FileReader("inputTextSLL.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(new FileWriter("outputTextSLL.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end openFiles()

	static void addReference(String term, int lineNum) {
		// Add a line reference to the concordance. The
		// concordance is stored in the global variable, index.
		// The word has been found on line number lineNum.

		SinglyLinkedList tempList = index0.head;
		if (tempList == null) {
			tempList = new SinglyLinkedList(term, lineNum);
			index0.head = tempList;
			size++;
		} else {
			while (tempList.next != null && tempList.next.getWord().compareToIgnoreCase(term) <= 0) {
				tempList = tempList.getNext();
			}
			if (tempList.getWord().equalsIgnoreCase(term)) {
				tempList.insert(lineNum);
			} else if (tempList.getWord().compareToIgnoreCase(term) < 0) {
				tempList.setNext(new SinglyLinkedList(term, lineNum));
				size++;
			} else {
				index0.head = new SinglyLinkedList(term, lineNum);
				index0.head.next = tempList;
				size++;
			}
		}
	}

	static void printConcordance() {
		while (index0.head != null) {
			index0.head.display(out);
			index0.head = index0.head.next;
		}
		out.close();
	}

	@SuppressWarnings("rawtypes")
	static class AlphabeticalOrder implements Comparator {
		// Represents a Comparator that can be used for
		// comparing Strings according to alphabetical
		// order. It is an error to apply this
		// Comparator to objects that are non-strings.
		public int compare(Object obj1, Object obj2) {
			String str1 = (String) obj1; // Type-cast object to Strings.
			String str2 = (String) obj2;
			str1 = str1.toLowerCase(); // Convert to lower case.
			str2 = str2.toLowerCase();
			return str1.compareTo(str2); // Compare lower-case Strings.
		}
	}

	static class LinkedList {
		SinglyLinkedList head, tail;
		int size;

		public LinkedList() {
			head = null;
			tail = null;
			size++;
		}

		public SinglyLinkedList insert(String term, int lineNum) {
			SinglyLinkedList tempList = index0.head;
			if (tempList == null) {
				tempList = new SinglyLinkedList(term, lineNum);
				index0.head = tempList;
				size++;
			} else {
				while (tempList.next != null && tempList.next.getWord().compareToIgnoreCase(term) <= 0) {
					tempList = tempList.getNext();
				}
				if (tempList.getWord().equalsIgnoreCase(term)) {
					tempList.insert(lineNum);
				} else if (tempList.getWord().compareToIgnoreCase(term) < 0) {
					tempList.setNext(new SinglyLinkedList(term, lineNum));
					size++;
				} else {
					index0.head = new SinglyLinkedList(term, lineNum);
					index0.head.next = tempList;
					size++;
				}
			}
			return tempList;
		}
	}
} // end class Concordance
