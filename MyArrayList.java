package Lab_6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
		private E[] elements;
		private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}
	public void growSize() {
		if (size == elements.length) {
			int newCapactity = elements.length *2;
			E[] newElements = (E[]) new Object[newCapactity];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
				
			}
			elements = newElements;
		}
	}
	public int size() {
		return size;	
		
	}
		
	public boolean isEmpty() {
		return size == 0;
	}
	// Replaces the element at index i with e, and
	//returns the replaced element. ∗/
	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			new IndexOutOfBoundsException();
		}
		
			E replacedElement = elements[index];
			elements[index] = (E) elements;
			
			return replacedElement;
		
	}
	// It is used to append the specified element at the
	//end of a list.
	public boolean add(E e) {
		if(size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		
	return true;
	}
	// Inserts element e to be at index i, shifting all
	//subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
			
		}
		
		if (size == elements.length) {
			growSize();
		}
		
		for (int j = size; j < i; j++) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
		
	}
	//fting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E removedElement = elements[i];
		
		for (int j = i; j < size -1; j++) {
			elements[j] = elements[j+1];
			
			
		}
		elements[size - 1] = null;
		size --;
		
	return removedElement;
	}
	
	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		
		size = 0;
	}
	
	// It is used to return the index in this list of the
	//last occurrence of the specified element, or -1 if the
	//list does not contain this element.
	public int lastIndexOf(Object o) {
		int lastIndex = -1;
		for (int i = 0; i < size; i++) {
			if (areEqual(o,elements[i])) {
				lastIndex = i ;
			}
		}
	return lastIndex ;
	}

	private boolean areEqual(Object o, Object e) {
	if (o == null) {
		return e == null;
	}
		return o.equals(e);
	}

	// It is used to return an array containing all of the
	//elements in this list in the correct order.
	public E[] toArray() {
		E [] result = (E[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = elements[i];
			
		}
		return result;
		
	}
	
	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			clonedList.add(elements[i]);
			
		}
		
		return clonedList;
	}
	// It returns true if the list contains the specified
	//element
	public boolean contains(E o) {
		for(E element : elements) {
			if(areEqual(o, element)) {
				return true;
			}
		}
		
		return false;
	}
	// It is used to return the index in this list of the
	//first occurrence of the specified element, or -1 if the
	//List does not contain this element.
	public int indexOf(E o) {
		int index = -1;
		
		for (int i = 0; i < size; i++) {
			if (areEqual(o,elements[i])) {
				index = i;
				break;
			}
		}
		
		return index;
		
	}
	
	// It is used to remove the first occurrence of the
	// specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (areEqual(e,elements[i])) {
				
				removeAt(i);
				return true;
				
			}
		}
		
		return false;
	
	}

	private void removeAt(int index) {
		for (int i = index; i < size -1; i++) {
			elements[i] = elements[i +1];
			
		}
		
		elements[size -1] = null;
		size--;
		
	}
	
	// It is used to sort the elements of the list on the
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements,0,size,c);
		
	}

	public static void main(String[] args) {
		
		MyArrayList<Integer> list = new MyArrayList<>();
		
			list.add(1);
	        list.add(3);
	        list.add(2);
	        list.add(4);
	      System.out.println("List after adding elements: " + Arrays.toString(list.toArray()));
	        
	        int size = list.size;
	        System.out.println("Size of List: "+ size);
	        
	        boolean isEmpty = list.isEmpty();
	        System.out.println("list is empty: "+ isEmpty);
	        
	        list.add(5);
	        System.out.println("List after adding elements: " + Arrays.toString(list.toArray()));
	        
	        list.add(2, 9);
	        System.out.println("List after adding elements: " + Arrays.toString(list.toArray()));
	        
	        
	        
	        
	        
	       int replacedValue = list.set(1, 10);
	        System.out.println(replacedValue);
	        
	        
	        
	       int index = list.indexOf(3);
	        System.out.println("Index of 3: " + index);
	        
	       list.remove(2);
	       System.out.println("List after removing element at index 2: " + Arrays.toString(list.toArray()));
	        
	        int lastIndex = list.lastIndexOf(3);
	      System.out.println(lastIndex);
	        
	       boolean contains = list.contains(2);
	       Object[] arr = list.toArray();
	       System.out.println("List after removing element at index 2: " + Arrays.toString(list.toArray()));
	    
	       
		
	}
	
	
	

}
