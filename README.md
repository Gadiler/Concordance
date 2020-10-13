# Concordance
A "concordance" is an alphabetical list of the words present in a text with a count of how 
often every word appears and quotes where each word appears in the text. to [read more.](https://en.wikipedia.org/wiki/Bible_concordance)

The program takes in a text file containing English text
and produces a list of all words by alphabetic order with the word line number.

The language used: **Java**

## introduction:
There are 2 data structures.
1. Red-Black Tree.
2. Singly Linked List.

At the main function, we create two threads to check **_what data is faster_**.
Any thread have his own anonymous inner class `run` with creating a relevant concordance.


## Run Instructions: 
* In the package, there are two files. 
	* input text file.
	* output text file.
	
For changing the text input, edit the file `inputText.txt`.

## Logic:
The high-level logic of the program is based on the use of a filter reader
class to parse the text, and store words in the data structures along with other details.

### RBTree Structure:
The structure, as we can see in the [Red-black Tree diagram](https://github.com/Gadiler/Concordance/blob/main/src/RBTreePackage/Red-Black%20Tree%20diagram.pdf) file, 
is Red-Black Tree containing LinkedList of line-number.

Any RBTNode containing:
* LinkedList of data
* RBTNode: `parent`, `left` and `right` child.
* inner LinkedList containing:
	* data-> `word` 
	* SinglyLinkedList-> `head` and `tail`.

#### RBT Complexity:
* Filling the tree takes O(nlg(n)) 
	* O(n) to run through all the words in the text file.
	* O(lg(n)) to store \ search \ other operation of RB-Tree.
##### n' is the number of words in the text.



### SLList Structure:
The data structure, as we can see in the [Singly-Linked-List diagram](https://github.com/Gadiler/Concordance/blob/main/src/linkedListPackage/Linked%20List%20diagram.pdf) file,
is Singly Linked-List contining Linked-List of line-number.

Any SLL containing:
- LinkedList-> data: `Head` \ `Tail`; reference to the first \ last SSL.
- `Size` -> number of words.
* inner SLL containing:
	* LinkedList-> data: `word` 
	* LinkedList-> `Head` \ `Tail`; reference to the first \ last node.
	
#### SLL Complexity:
* Filling the tree takes O(n^2) 
	* O(n) to run through all the words in the text file.
	* O(n) to store \ search on SL-List.
	* **'n' is the number of words in the text.**
	
---	
## Pseudo code:
```java
Concordance() {

	while ( hasNext() ) {				// Run through any word in the textFile {O(n)}.
		while ( whiteSpace ) { skip }
		if  ( word.length > 2 && word != "the" ) 
			insert( word, lineNumber );	// O(lg(n))
	} 						// End of loop.
	display();					// O(n)
}

insert( String, int ) {

	temp = searchWord( word );  			// If null - not exist, create new Node with the word and insert.
	
	if ( temp == null ) {				// else - add the lineNum to the tail of the LinkedList. {O(lg(n))}
		temp = new RBTNode;	
	}else {
		while ( !rightPlace ) {			// Run till the right place for the new RBTNode \ SLLNode.
			root = root.next;		// If (RBTree && greater than), next = right. otherwise next = left.
		}					// If (SLList && greater than), next = next.next. otherwiae - inaert.
		temp = root.next;
	}
	fixInsert(); 					// Fix the insertion by the Red-Black Tree algorithm. -> only at the RBTree data structure.
}
```
---
### Example of output on THIS README file:

- add {1 time} 72
- algorithm {1 time} 80
- all {2 times} 6, 39
- along {1 time} 25
- alphabetic {1 time} 6
- alphabetical {1 time} 2
- and {7 times} 3, 6, 20, 25, 32, 35, 70
- anonymous {1 time} 16
- Any {4 times} 16, 30, 48, 60
- appears {2 times} 3, 3
- are {2 times} 11, 20
- based {1 time} 24
- Black {4 times} 12, 28, 29, 80
- can {2 times} 28, 46
- changing {1 time} 21
- check {1 time} 15
- child {1 time} 33
- class {2 times} 16, 25
- code {1 time} 57
- Complexity {1 time} 38
- Concordance {4 times} 2, 2, 19, 60
- containing {6 times} 5, 29, 31, 34, 49, 52
- contining {1 time} 47
- count {1 time} 2
- create {2 times} 15, 70
- creating {1 time} 16
- data {9 times} 11, 15, 25, 32, 34, 46, 49, 52, 80
- details {1 time} 27
- diagram {1 time} 28
- display {1 time} 65
- each {1 time} 3
- edit {1 time} 21
- else {2 times} 72, 75
- End {1 time} 64
- English {1 time} 5
- every {1 time} 3
- exist {1 time} 70
- faster {1 time} 16
- file {6 times} 5, 20, 21, 29, 40, 47
- files {1 time} 20
- Filling {1 time} 38
- filter {1 time} 24
- first {1 time} 53
- Fix {1 time} 80
- fixInsert {1 time} 80
- for {4 times} 20, 20, 21, 75
- function {1 time} 15
- greater {2 times} 76, 77
- hasNext {1 time} 60
- have {1 time} 16
- head {3 times} 35, 49, 53
- high {1 time} 24
- his {1 time} 16
- how {1 time} 3
- inner {3 times} 16, 33, 51
- input {2 times} 20, 21
- inputText {1 time} 21
- insert {4 times} 63, 68, 72, 78
- insertion {1 time} 80
- Instructions {1 time} 20
- int {1 time} 70
- introduction {1 time} 11
- Java {2 times} 10, 58
- language {1 time} 8
- last {1 time} 53
- left {2 times} 32, 77
- length {1 time} 62
- level {1 time} 24
- line {3 times} 6, 29, 47
- lineNum {1 time} 72
- lineNumber {1 time} 63
- Linked {3 times} 13, 47, 47
- LinkedList {7 times} 29, 31, 33, 49, 52, 53, 72
- list {5 times} 2, 6, 15, 47, 47
- Logic {2 times} 24, 24
- loop {1 time} 65
- main {1 time} 15
- more {1 time} 5
- new {3 times} 70, 73, 75
- next {7 times} 76, 76, 76, 77, 77, 77, 80
- nlg {1 time} 38
- node {2 times} 56, 70
- not {1 time} 70
- null {2 times} 70, 72
- number {5 times} 8, 30, 41, 48, 50
- often {1 time} 3
- one {1 time} 20
- only {1 time} 80
- operation {1 time} 40
- order {1 time} 6
- other {3 times} 20, 25, 40
- otherwise {2 times} 76, 77
- output {1 time} 21
- own {1 time} 16
- package {1 time} 20
- parent {1 time} 32
- parse {1 time} 25
- place {1 time} 75
- present {1 time} 2
- produces {1 time} 6
- program {2 times} 5, 24
- Pseudo {1 time} 56
- quotes {1 time} 3
- RBTNode {4 times} 30, 32, 74, 75
- RBTree {3 times} 27, 76, 80
- read {1 time} 3
- reader {1 time} 25
- Red {4 times} 12, 28, 29, 80
- reference {1 time} 53
- relevant {1 time} 16
- right {3 times} 32, 75, 76
- rightPlace {1 time} 75
- root {3 times} 76, 76, 78
- run {5 times} 16, 19, 39, 60, 75
- search {1 time} 40
- searchWord {1 time} 70
- see {2 times} 28, 46
- Singly {2 times} 13, 47
- SinglyLinkedList {1 time} 35
- Size {1 time} 50
- skip {1 time} 62
- SLL {2 times} 48, 51
- SLList {2 times} 45, 77
- SLLNode {1 time} 76
- store {2 times} 25, 40
- String {1 time} 68
- Structure {5 times} 28, 28, 46, 46, 82
- structures {2 times} 12, 25
- tail {4 times} 37, 50, 53, 72
- takes {2 times} 5, 38
- temp {4 times} 70, 72, 73, 78
- text {8 times} 2, 3, 5, 6, 21, 25, 39, 45
- textFile {1 time} 60
- than {2 times} 76, 77
- There {2 times} 11, 20
- thread {1 time} 16
- threads {1 time} 15
- through {2 times} 39, 60
- till {1 time} 75
- Tree {6 times} 13, 28, 29, 38, 41, 80
- two {2 times} 15, 20
- txt {1 time} 23
- use {1 time} 24
- used {1 time} 8
- what {1 time} 15
- where {1 time} 3
- while {3 times} 60, 61, 75
- whiteSpace {1 time} 61
- with {5 times} 2, 6, 16, 25, 70
- word {11 times} 3, 3, 6, 35, 53, 60, 62, 62, 63, 70, 70
- words {6 times} 2, 6, 25, 39, 41, 51
