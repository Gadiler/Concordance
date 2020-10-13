# Concordance
A "concordance" is an alphabetical list of the words present in a text with a count of how
often every word appears and quotes where each word appears in the text, to [read more.](https://en.wikipedia.org/wiki/Bible_concordance)

The program takes in a text file containing English text
and produces a list of all words by alphabetic order with the word line number.

The language used: **Java**

## introduction:
There are 2 data structures.
1. Red-Black Tree.
2. Singly Linked List.

At the main function, i create two threads to check **_what data is faster_**.
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
* RBTNode: `parent`, `left` and `right` child.
* LinkedList of data.
	* inner LinkedList containing:
		* data: `word` 
		* Node-> `head` and `tail`
			- inner Node containing:
				- data: `line`
				- Node-> `next`

#### RBT Complexity:
* Filling the tree takes O(nlg(n)) 
	* O(n) to run through all the words in the text file.
	* O(lg(n)) to store \ search \ other operation of RB-Tree.
##### 'n' - number of words in the text.

---

### SLL Structure:
The data structure, as we can see in the [Singly-Linked-List diagram](https://github.com/Gadiler/Concordance/blob/main/src/linkedListPackage/Linked%20List%20diagram.pdf) file,
is Singly Linked-List contining Linked-List of line-number.

Any SLL containing:
* `fileName` - input source
* `Size` - number of words.
* LinkedList of data.
	* inner SLL containing:
		* data: `word` 
		* LinkedList-> `next`
		* Node-> `Head` \ `Tail`
			- inner Node containing:
				- data: `line` 
				- Node-> `next`
	
#### SLL Complexity:
* Filling the tree takes O(n^2) 
	* O(n) to run through all the words in the text file.
	* O(n) to store \ search on SL-List.
##### 'n' - number of words in the text.
	
---	
## Pseudo code:
```java
Concordance() {

	while ( hasNext() ) {				// Run through any word in the textFile {O(n)}.
		while ( whiteSpace ) { skip }
		if  ( word.length > 2 && word != "the" ) 
			insert( word, lineNumber );	// O(lg(n)) -> RBT \ O(n) -> SLL
	} 						// End of loop.
	display();					// O(n)
}

insert( String, int ) {

	temp = searchWord( word );  			// If null - not exist, create new Node with the word and insert.
	
	if ( temp == null ) {				// else - add the lineNum to the tail of the LinkedList.
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

- add {1 time} 91
- algorithm {1 time} 99
- all {3 times} 6, 46, 70
- along {1 time} 28
- alphabetic {1 time} 6
- alphabetical {1 time} 2
- and {6 times} 3, 6, 28, 35, 39, 89
- anonymous {1 time} 16
- Any {4 times} 16, 34, 56, 79
- appears {2 times} 3, 3
- are {2 times} 11, 20
- based {1 time} 27
- Black {4 times} 12, 31, 32, 99
- can {2 times} 31, 53
- changing {1 time} 24
- check {1 time} 15
- child {1 time} 36
- class {2 times} 16, 28
- code {1 time} 76
- Complexity {2 times} 45, 69
- Concordance {4 times} 2, 2, 19, 79
- containing {8 times} 5, 32, 35, 38, 41, 57, 61, 65
- contining {1 time} 54
- count {1 time} 2
- create {2 times} 15, 89
- creating {1 time} 16
- data {11 times} 11, 15, 28, 37, 38, 41, 53, 60, 61, 65, 99
- details {1 time} 30
- diagram {2 times} 31, 53
- display {1 time} 84
- each {1 time} 3
- edit {1 time} 24
- else {2 times} 91, 94
- End {1 time} 83
- English {1 time} 5
- every {1 time} 3
- exist {1 time} 89
- faster {1 time} 16
- file {8 times} 5, 22, 24, 24, 32, 47, 54, 71
- fileName {1 time} 57
- files {1 time} 21
- Filling {2 times} 45, 69
- filter {1 time} 27
- Fix {1 time} 99
- fixInsert {1 time} 99
- For {2 times} 24, 94
- function {1 time} 15
- greater {2 times} 95, 96
- hasNext {1 time} 79
- have {1 time} 16
- head {2 times} 39, 63
- high {1 time} 27
- his {1 time} 16
- how {1 time} 3
- inaert {1 time} 97
- inner {5 times} 16, 37, 40, 60, 64
- input {3 times} 21, 24, 57
- inputText {1 time} 24
- insert {3 times} 82, 87, 91
- insertion {1 time} 99
- Instructions {1 time} 20
- int {1 time} 89
- introduction {1 time} 11
- Java {2 times} 10, 77
- language {1 time} 8
- left {2 times} 35, 96
- length {1 time} 81
- level {1 time} 27
- line {5 times} 6, 32, 42, 54, 66
- lineNum {1 time} 91
- lineNumber {1 time} 82
- Linked {4 times} 13, 53, 54, 54
- LinkedList {6 times} 32, 36, 37, 59, 62, 92
- list {7 times} 2, 6, 15, 53, 54, 54, 72
- Logic {2 times} 27, 27
- loop {1 time} 84
- main {1 time} 15
- more {1 time} 5
- new {3 times} 89, 92, 94
- next {10 times} 44, 63, 68, 95, 95, 95, 96, 96, 96, 99
- nlg {1 time} 45
- Node {7 times} 39, 40, 42, 63, 64, 66, 89
- not {1 time} 89
- null {2 times} 89, 91
- number {6 times} 8, 34, 48, 56, 58, 72
- often {1 time} 3
- only {1 time} 99
- operation {1 time} 47
- order {1 time} 6
- other {2 times} 28, 47
- otherwiae {1 time} 96
- otherwise {1 time} 95
- output {1 time} 22
- own {1 time} 16
- package {1 time} 20
- parent {1 time} 35
- parse {1 time} 28
- place {1 time} 94
- present {1 time} 2
- produces {1 time} 6
- program {2 times} 5, 27
- Pseudo {1 time} 75
- quotes {1 time} 3
- RBT {2 times} 44, 82
- RBTNode {4 times} 34, 35, 93, 94
- RBTree {3 times} 30, 95, 99
- read {1 time} 3
- reader {1 time} 28
- Red {4 times} 12, 31, 32, 99
- relevant {1 time} 16
- right {3 times} 35, 94, 95
- rightPlace {1 time} 94
- root {3 times} 95, 95, 97
- run {6 times} 16, 19, 46, 70, 79, 94
- search {2 times} 47, 71
- searchWord {1 time} 89
- see {2 times} 31, 53
- Singly {3 times} 13, 53, 54
- Size {1 time} 58
- skip {1 time} 81
- SLL {5 times} 52, 56, 60, 68, 83
- SLList {1 time} 96
- SLLNode {1 time} 95
- source {1 time} 58
- store {3 times} 28, 47, 71
- String {1 time} 87
- Structure {5 times} 31, 31, 53, 53, 101
- structures {2 times} 12, 28
- tail {3 times} 40, 64, 91
- takes {3 times} 5, 45, 69
- temp {4 times} 89, 91, 92, 97
- text {12 times} 2, 3, 5, 6, 21, 22, 24, 28, 46, 52, 70, 75
- textFile {1 time} 79
- than {2 times} 95, 96
- There {2 times} 11, 20
- thread {1 time} 16
- threads {1 time} 15
- through {3 times} 46, 70, 79
- till {1 time} 94
- Tree {7 times} 13, 31, 32, 45, 48, 69, 99
- two {2 times} 15, 20
- txt {1 time} 26
- use {1 time} 27
- used {1 time} 8
- what {1 time} 15
- where {1 time} 3
- while {3 times} 79, 80, 94
- whiteSpace {1 time} 80
- with {5 times} 2, 6, 16, 28, 89
- word {11 times} 3, 3, 6, 39, 62, 79, 81, 81, 82, 89, 89
- words {8 times} 2, 6, 28, 46, 48, 59, 70, 72
