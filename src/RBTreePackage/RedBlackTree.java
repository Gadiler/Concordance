package RBTreePackage;

import java.io.PrintWriter;
import java.util.Comparator;

class RBTreeNode {

	LinkedList data;
	RBTreeNode parent, left, right;
	int color = 0;

	/*
	 * @param data - LinkedList of the data, contain the word and list of the lines
	 * reference.
	 * 
	 * @param parent - RBTNode reference for the parent of the child by the
	 * algorithm of the Red-Black Tree.
	 * 
	 * @param left\right - RBTNode reference for the child of the parent, if
	 * newNode.data greater than or equal the root.data -> insert tight, otherwise
	 * insert left.
	 * 
	 * @ color - any node have color. 1 = Red, 0 = Black.
	 */

	public RBTreeNode() {
		data = null;
		parent = null;
		left = null;
		right = null;
	}
}

public class RedBlackTree {

	private Comparator<String> comparator;

	private RBTreeNode root;
	private RBTreeNode TNULL;
	private int size = 0;

	// Inorder recursive
	private void inOrderHelperRec(RBTreeNode node, PrintWriter out) {
		if (node != TNULL) {
			inOrderHelperRec(node.left, out);
			node.data.display(out);
			inOrderHelperRec(node.right, out);
		}
	}

	public int compare(String key, String key2) {
		return (comparator == null ? ((Comparable<String>) key).compareTo(key2) : comparator.compare(key, key2));
	}

	// Search the tree recursively
	@SuppressWarnings("unused")
	private RBTreeNode searchTreeHelperRec(RBTreeNode node, String key) {
		if (node == TNULL || key.equalsIgnoreCase(node.data.getWord())) {
			return node;
		}

		if (compare(key, node.data.getWord()) < 0) {
			return searchTreeHelperRec(node.left, key);
		}
		return searchTreeHelperRec(node.right, key);
	}

	// Search the tree
	public RBTreeNode searchTreeHelper(RBTreeNode node, String key) {
		RBTreeNode temp = node;
		while (temp != TNULL && !key.equalsIgnoreCase(temp.data.getWord())) {
			if (compare(key, temp.data.getWord()) < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return temp;
	}

	// Balance the node after insertion
	private void fixInsert(RBTreeNode k) {
		RBTreeNode u;
		while (k.parent.color == 1) {
			if (k.parent == k.parent.parent.right) {
				u = k.parent.parent.left;
				if (u != null && u.color == 1) {
					u.color = 0;
					k.parent.color = 0;
					k.parent.parent.color = 1;
					k = k.parent.parent;
				} else {
					if (k == k.parent.left) {
						k = k.parent;
						rightRotate(k);
					}
					k.parent.color = 0;
					k.parent.parent.color = 1;
					leftRotate(k.parent.parent);
				}
			} else {
				u = k.parent.parent.right;

				if (u != null && u.color == 1) {
					u.color = 0;
					k.parent.color = 0;
					k.parent.parent.color = 1;
					k = k.parent.parent;
				} else {
					if (k == k.parent.right) {
						k = k.parent;
						leftRotate(k);
					}
					k.parent.color = 0;
					k.parent.parent.color = 1;
					rightRotate(k.parent.parent);
				}
			}
			if (k == root) {
				break;
			}
		}
		root.color = 0;
	}

	public RedBlackTree() {
		TNULL = new RBTreeNode();
		TNULL.color = 0;
		TNULL.left = null;
		TNULL.right = null;
		root = TNULL;
	}

	public RedBlackTree(Comparator<String> comparator) {
		this.comparator = comparator;
	}

	public void inorder(PrintWriter out) {
		inOrderHelperRec(this.root, out);
	}

	public RBTreeNode searchTree(String k) {
		return searchTreeHelper(this.root, k);
	}

	public void leftRotate(RBTreeNode x) {
		RBTreeNode y = x.right;
		x.right = y.left;
		if (y.left != TNULL) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	public void rightRotate(RBTreeNode x) {
		RBTreeNode y = x.left;
		x.left = y.right;
		if (y.right != TNULL) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	public void insert(String key, int line) {

		RBTreeNode z = searchTree(key);

		// If NOT null then add new line into the LinedList.
		// Otherwise create new RBTNode and insert by the algorithm.
		if (z != null) {
			z.data.insertSinglyNode(line);
		} else {

			RBTreeNode tempNode = new RBTreeNode();
			SinglyNode tempSN = new SinglyNode(line);
			LinkedList tempList = new LinkedList(key, tempSN, tempSN, 1);
			tempNode.data = tempList;

			tempNode.left = TNULL;
			tempNode.right = TNULL;
			tempNode.color = 1;

			size++;

			RBTreeNode y = null;
			RBTreeNode x = this.root;

			while (x != TNULL) { // Run till the right place for the new RBTNode.
				y = x;
				if (compare(key, x.data.getWord()) < 0) {
					x = x.left;
				} else {
					x = x.right;
				}
			}

			tempNode.parent = y; // save the parent of the leaf.
			if (y == null) { // in case the tree is empty.
				root = tempNode;
			} else if (compare(key, y.data.getWord()) < 0) {
				y.left = tempNode;
			} else {
				y.right = tempNode;
			}

			if (tempNode.parent == null) {
				tempNode.color = 0;
				return;
			}

			if (tempNode.parent.parent == null) {
				return;
			}
			fixInsert(tempNode);
		}
	}

	public RBTreeNode getRoot() {
		return this.root;
	}

	public int getSize() {
		return size;
	}
}
