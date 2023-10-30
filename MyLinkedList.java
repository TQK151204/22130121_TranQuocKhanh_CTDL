package Lab_6;

public class MyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public MyLinkedList() {
		super();

	}

	public void addFirst(E data) {
		Node<E> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;

		} else {

			newNode.setNext(head);
			head = newNode;

		}
		size++;
	}

	public int size() {
		return size;

	}

	public boolean isEmpty() {
		return size == 0;

	}

	public E first() {
		if (isEmpty()) {
			return null;

		}

		return head.getData();
	}

	public E last() {
		if (isEmpty()) {
			return null;

		}

		return tail.getData();
	}

	public void addLast(E data) {
		Node<E> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;

		} else {

			tail.setNext(head);
			tail = newNode;

		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;

		}

		E removedElement = head.getData();
		head = head.getNext();
		size--;

		if (size == 0) {

			tail = null;
		}

		return removedElement;
	}

	public E removeLast() {
		if (isEmpty()) {
			
			return null;
		}
		
		E removedElement;
		if (size == 1) {
			removedElement = head.getData();
			head = null;
			tail = null;
		} else {
			
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			
			removedElement = tail.getData();
			tail = current;
			tail.setNext(null);
		}
		
		size--;
		
		return removedElement;
	}
	public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        
        System.out.println("Is the list empty? " + list.isEmpty()); // Should be true
        System.out.println("Size of the list: " + list.size()); // Should be 0

        
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);

        
        System.out.println("First element: " + list.first()); // Should be 1
        System.out.println("Last element: " + list.last()); // Should be 3
        System.out.println("Size of the list: " + list.size()); // Should be 3

        
        int removedFirst = list.removeFirst();
        int removedLast = list.removeLast();

        System.out.println("Removed first element: " + removedFirst); // Should be 1
        System.out.println("Removed last element: " + removedLast); // Should be 3
        System.out.println("Size of the list after removal: " + list.size()); // Should be 1

        
        System.out.println("Is the list empty after removal? " + list.isEmpty()); // Should be false
    }

}
