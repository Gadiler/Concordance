# Concordance
A "concordance" is an alphabetical list of the words present in a text with a count of how 
often every word appears and quotes where each word appears in the text.

The program takes in a text file containing English text
and produces a list of all words by alphabetic order with the word line number.

The language used: ## Java

## Run Instructions: 
In the package, there are two files. one for the input file and the other for the output.
For changing the text input, edit the file 'input.txt'.

## Logic:
The high-level logic of the program is based on the use of a filter reader
class to parse the text, and store words in a Red-Black Tree along with other details.

The structure, as we can see in the "Red-black Tree diagram" file, is  Red-Black Tree containing LinkedList of line-number.
Any RBTNode containing - LinkedList of data and 3 RBTNode - 'parent', 'left' and 'right' child.
Any LinkedList containing - 'word' and SinglyLinkedList - 'head' and 'tail'.

## Complexity:
Filling the tree takes O(nlg(n)) - 
O(n) to run through all the words in the text file, 
and O(lg(n)) to store \ search \ other operation of RB-Tree.
** 'n' is the number of words in the text. **

# Pseudo code:

Concordance() {
	while ( hasNext() ) {				 // Run through any word in the textFile {O(n)}.
		while ( whiteSpace ) { skip }
		if  ( word.length > 2 && word != "the" ) 
			insert( word, lineNumber );	// O(lg(n))
	} 					// End of loop.
	display();					// O(n)
}

insert( String, int ) {
	temp = searchWord( word );  		// If null - not exist, create new Node with the word and insert. 
	if( temp == null ) {				// else - add the lineNum to the tail of the LinkedList. {O(lg(n))}
		temp = new RBTNode;
	}else {
		while ( !rightPlace ) {		// Run till the right place for the new RBTNode.
			root = root.next;		// If greater than, next = right. otherwise next = left.
		}				
		temp = root.next;
	}
	fixInsert(); 				// Fix the insertion by the Red-Black Tree algorithm.
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------	

### Example of output on THIS README file:

add {1 time} 42

algorithm {1 time} 50

all {2 times} 8, 25

along {1 time} 17

alphabetic {1 time} 8

alphabetical {1 time} 4

and {10 times} 5, 8, 13, 17, 20, 20, 21, 21, 26, 41

Any {3 times} 20, 21, 32

appears {2 times} 5, 5

are {1 time} 13

based {1 time} 16

Black {4 times} 17, 19, 19, 50

can {1 time} 19

changing {1 time} 14

child {1 time} 20

citations {1 time} 5

class {1 time} 17

code {1 time} 29

Complexity {1 time} 23

concordance {2 times} 4, 31

containing {4 times} 7, 19, 20, 21

count {1 time} 4

create {1 time} 41

Data {2 times} 1, 20

details {1 time} 17

diagram {1 time} 19

each {2 times} 5, 5

edit {1 time} 14

else {2 times} 42, 44

End {1 time} 36

Engelsman {1 time} 2

English {1 time} 7

exist {1 time} 41

file {5 times} 7, 13, 14, 19, 25

files {1 time} 13

Filling {1 time} 24

filter {1 time} 16

Fix {1 time} 50

fixInsert {1 time} 50

for {4 times} 13, 13, 14, 45

Gadi {1 time} 2

greater {1 time} 46

hasNext {1 time} 32

head {1 time} 21

high {1 time} 16

how {1 time} 4

input {3 times} 13, 14, 14

insert {3 times} 35, 40, 41

insertion {1 time} 50

Instructions {1 time} 12

int {1 time} 40

Java {1 time} 10

language {1 time} 10

left {2 times} 20, 46

length {1 time} 34

level {1 time} 16

line {2 times} 8, 19

lineNum {1 time} 42

lineNumber {1 time} 35

LinkedList {4 times} 19, 20, 21, 42

list {2 times} 4, 8

Logic {2 times} 16, 16

loop {1 time} 36

new {3 times} 41, 43, 45

next {4 times} 46, 46, 46, 48

nlg {1 time} 24

Node {1 time} 41

not {1 time} 41

null {2 times} 41, 42

number {3 times} 8, 19, 27

often {1 time} 5

one {1 time} 13

operation {1 time} 26

order {1 time} 8

other {3 times} 13, 17, 26

otherwise {1 time} 46

output {1 time} 13

package {1 time} 13

parent {1 time} 20

parse {1 time} 17

place {1 time} 45

present {1 time} 4

print {1 time} 37

produces {1 time} 8

program {2 times} 7, 16

Pseudo {1 time} 29

RBTNode {4 times} 20, 20, 43, 45

reader {1 time} 16

Red {4 times} 17, 19, 19, 50

right {3 times} 20, 45, 46

rightPlace {1 time} 45

root {3 times} 46, 46, 48

Run {4 times} 12, 25, 32, 45

search {1 time} 26

searchWord {1 time} 41

see {1 time} 19

SinglyLinkedList {1 time} 21

skip {1 time} 33

store {2 times} 17, 26

String {1 time} 40

Structure {2 times} 1, 19

tail {2 times} 21, 42

takes {2 times} 7, 24

temp {4 times} 41, 42, 43, 48

text {8 times} 4, 5, 7, 7, 14, 17, 25, 27

textFile {1 time} 32

than {1 time} 46

there {1 time} 13

through {2 times} 25, 32

till {1 time} 45

Tree {6 times} 17, 19, 19, 24, 26, 50

two {1 time} 13

txt {1 time} 14

use {1 time} 16

used {1 time} 10

where {1 time} 5

while {3 times} 32, 33, 45

whiteSpace {1 time} 33

with {4 times} 4, 8, 17, 41

word {10 times} 5, 5, 8, 21, 32, 34, 34, 35, 41, 41

words {5 times} 4, 8, 17, 25, 27
