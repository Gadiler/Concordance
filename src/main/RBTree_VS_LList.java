package main;

public class RBTree_VS_LList {

	public static RBTreePackage.concordance c1;
	public static linkedListPackage.concordance c2;

	// First thread: Red-Black Tree.
	static Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			c1 = new RBTreePackage.concordance();
		}
	});

	// Second thread: Singly Linked List.
	static Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
			c2 = new linkedListPackage.concordance();
		}
	});

	public static void main(String[] args) {

		t1.start();
		t2.start();
	}
}
