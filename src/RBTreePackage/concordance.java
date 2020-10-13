package RBTreePackage;

import java.util.*;
import java.io.*;

public class concordance {

	static TextReader in; // An input stream for reading the input file.
	static PrintWriter out; // Output stream for writing the output file.

	static long startTime = System.currentTimeMillis();
	static RedBlackTree index0 = new RedBlackTree(new AlphabeticalOrder());

	// This Red-Black Tree holds the concordance. Words from the file
	// are used as keys in the list. The value associated with
	// each word is a node that contains the line numbers on which
	// the word occurs in the file. The node contains values
	// belonging to the wrapper class, Integer.

	public concordance() {

		openFiles(); // Open input and output files.

		int lineNum = 1; // The number of the line in the input
							// file that is currently begin processed.

		while (!in.eof()) { // Run through the file until the end-of-file.
			// O(nlg(n)) -> run on each word in the text file, search the tree for the
			// correct word.
			// if present, insert lineNum. otherwise - create a new node and insert it into
			// the tree.

			String word = in.getAlpha(); // The next word from the file.

			while (in.peek() != '\0' && !Character.isLetter(in.peek())) {
				// Run through White-Space.
				// Skip over non-letter characters, stopping when
				// end-of-file ('\0') or a letter is seen. If the
				// character is an end-of-line character ('\n'), add one
				// to lineNum to reflect that fact that we are moving
				// on to the next line in the file.
				char ch = in.getAnyChar();
				if (ch == '\n') {
					lineNum++; // Start a new line.
				}
			}
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
		System.out.println(index0.getSize() + " distinct words were found at the Red-Black Tree.");
		long endTime = System.currentTimeMillis();
		System.out.println("Time measure for Red-Black Tree EXAMPLE: " + (endTime - startTime) + "-Milli Second\n");
	}

	static void openFiles() {
		// Open the global variable "in" as an input file with name
		// "inputText". Open the global variable "out" as an output
		// file with name "outputText".
		// If an error occurs while trying to open the files, then an
		// error message is printed and the program will be terminated.
		try {
			in = new TextReader(new FileReader("inputTextRBT.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(new FileWriter("outputTextRBT.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end openFiles()

	static void addReference(String term, int lineNum) { // O(lg(n))
		// Add a line reference to the concordance. The
		// concordance is stored in the global variable, index.
		// The word has been found on line number lineNum.
		index0.insert(term, lineNum);
	}

	static void printConcordance() { // O(n)
		index0.inorder(out);
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
} // end class Concordance
