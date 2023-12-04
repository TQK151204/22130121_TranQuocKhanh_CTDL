package Lab_10_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		root = addRecursive(root, e);
	}

	private BNode<E> addRecursive(BNode<E> current, E e) {
		if (current == null) {

			return new BNode<>(e);
		}

		if (e.compareTo(current.getData()) < 0) {
			current.setLeft(addRecursive(current.getLeft(), e));
		} else if (e.compareTo(current.getData()) > 0) {
			current.setRight(addRecursive(current.getRight(), e));
		}

		return current;
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return depthRecursive(root, node);
	}

	private int depthRecursive(BNode<E> current, E value) {
		if (current == null) {
			return -1;
		}

		int compareResult = value.compareTo(current.getData());

		if (compareResult == 0) {
			return 0;
		} else if (compareResult < 0) {

			int leftDepth = depthRecursive(current.getLeft(), value);
			return leftDepth != -1 ? leftDepth + 1 : -1;
		} else {

			int rightDepth = depthRecursive(current.getRight(), value);
			return rightDepth != -1 ? rightDepth + 1 : -1;
		}
	}

	// compute the height of BST
	public int height() {
		return heghtRecursive(root);
	}

	private int heghtRecursive(BNode<E> root2) {
		if (root2 == null) {
			return -1;

		} else {
			int leftHeight = heghtRecursive(root2.getLeft());
			int rightHeight = heghtRecursive(root2.getRight());

			return Math.max(leftHeight, rightHeight) + 1;

		}

	}

	// Compute total nodes in BST
	public int size() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(BNode<E> current) {
		if (current == null) {
			return 0;

		} else {
			int sizeLeft = sizeRecursive(current.getLeft());
			int sizeRight = sizeRecursive(current.getRight());

			return sizeLeft + sizeRight + 1;
		}

	}

	// Check whether element e is in BST
	public boolean contains(E e) {

		return containsRecursive(root, e);
	}

	private boolean containsRecursive(BNode<E> current, E target) {
		if (current == null) {
			return false;
		}
		int result = target.compareTo(current.getData());
		if (result < 0) {
			return containsRecursive(current.getLeft(), target);
		} else if (result > 0) {
			return containsRecursive(current.getRight(), target);
		} else {
			return true;
		}

	}

	// Find the minimum element in BST
	public E findMin() {
		BNode<E> current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();
	}

	// Find the maximum element in BST
	public E findMax() {
		BNode<E> current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();
	}

	public boolean remove(E e) {
		root = removeRecursive(root, e);
		return true;
	}

	private BNode<E> removeRecursive(BNode<E> current, E value) {
		if (current == null) {
			return null;
		}

		int compareResult = value.compareTo(current.getData());

		if (compareResult < 0) {
			current.setLeft(removeRecursive(current.getLeft(), value));
		} else if (compareResult > 0) {
			current.setRight(removeRecursive(current.getRight(), value));
		} else {

			if (current.getLeft() == null) {
				return current.getRight();
			} else if (current.getRight() == null) {
				return current.getLeft();
			}

			current.setData(findMin(current.getRight()).getData());

			current.setRight(removeRecursive(current.getRight(), current.getData()));
		}

		return current;
	}

	public List<E> descendants(E data) {
		BNode<E> targetNode = findNode(root, data);

		if (targetNode == null) {
			return new ArrayList<>();
		}

		List<E> descendantsList = new ArrayList<>();
		collectDescendants(targetNode, descendantsList);

		return descendantsList;
	}

	private BNode<E> findNode(BNode<E> current, E value) {
		if (current == null) {
			return null;
		}

		int compareResult = value.compareTo(current.getData());

		if (compareResult == 0) {
			return current;
		} else if (compareResult < 0) {
			return findNode(current.getLeft(), value);
		} else {
			return findNode(current.getRight(), value);
		}
	}

	private void collectDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {

			descendantsList.add(node.getData());

			collectDescendants(node.getLeft(), descendantsList);
			collectDescendants(node.getRight(), descendantsList);
		}
	}

	private BNode<E> findMin(BNode<E> node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	// Method to get the ancestors of a node
	public List<E> ancestors(E data) {
		List<E> ancestorsList = new ArrayList<>();
		findAncestors(root, data, ancestorsList);

		return ancestorsList;
	}

	private boolean findAncestors(BNode<E> current, E value, List<E> ancestorsList) {
		if (current == null) {
			return false; 
		}

		int compareResult = value.compareTo(current.getData());

		if (compareResult == 0) {
			return true;
		}

		boolean foundInLeftSubtree = findAncestors(current.getLeft(), value, ancestorsList);
		boolean foundInRightSubtree = findAncestors(current.getRight(), value, ancestorsList);

		if (foundInLeftSubtree || foundInRightSubtree) {
			ancestorsList.add(current.getData());
		}

		return foundInLeftSubtree || foundInRightSubtree;
	}
	
	public void preorder() {
	    preorderRecursive(root);
	}

	private void preorderRecursive(BNode<E> current) {
	    if (current != null) {
	        System.out.print(current.getData() + " ");
	        preorderRecursive(current.getLeft());
	        preorderRecursive(current.getRight());
	    }
	}
	public void postorder() {
	    postorderRecursive(root);
	}

	private void postorderRecursive(BNode<E> current) {
	    if (current != null) {
	        postorderRecursive(current.getLeft());
	        postorderRecursive(current.getRight());
	        System.out.print(current.getData() + " ");
	    }
	}
	public void inorder() {
	    inorderRecursive(root);
	}

	private void inorderRecursive(BNode<E> current) {
	    if (current != null) {
	        inorderRecursive(current.getLeft());
	        System.out.print(current.getData() + " ");
	        inorderRecursive(current.getRight());
	    }
	}
	public BNode<E> getRoot() {
		return root;
	}

	public void setRoot(BNode<E> root) {
		this.root = root;
	}

}
