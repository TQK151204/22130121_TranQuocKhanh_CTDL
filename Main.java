package Lab_10_Tree;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Create a BST of integers
		BST<Integer> bst = new BST<>();

		// Add some elements to the BST
		bst.add(50);
		bst.add(30);
		bst.add(70);
		bst.add(20);
		bst.add(40);
		bst.add(60);
		bst.add(80);

		printInOrder(bst.getRoot());
		System.out.println();
		int sizeTest = bst.size();
		System.out.println(bst.size());
		int minValue = bst.findMin();
		System.out.println(minValue);
		int maxValue = bst.findMax();
		System.out.println(maxValue);

		System.out.println(bst.contains(40));
		System.out.println(bst.depth(90));
		System.out.println(bst.height());
		System.out.println(bst.remove(50));
		System.out.println();
		printInOrder(bst.getRoot());
		List<Integer> des = bst.descendants(30);
		System.out.println(des);
		List<Integer> ances = bst.ancestors(40);
		System.out.println(ances);
		bst.preorder();
		System.out.println();
		bst.postorder();
		System.out.println();
		bst.inorder();
		

	}

	private static void printInOrder(BNode<Integer> node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.print(node.getData() + " ");
			printInOrder(node.getRight());
		}
	}

}
