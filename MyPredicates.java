package Lab_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()) {
			T next = iter.next();
			if(p.test(next))
				iter.remove();
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
			while(iterator.hasNext()){
				T obj = iterator.next();
				if (!p.test(obj)) {
					
					iterator.remove();
					
				}
			}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		for(T obj : coll) {
			if(p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for(T item : coll) {
			if(p.test(item)) {
				return index;
			}
			
			index++;
			
		}
		return -1;
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		Even p = new Even();
		//MyPredicates.remove(list, p);
		//System.out.print(list);
	
	   // retain(list, p);
	   // System.out.println("Updated list: " + list);
		int index = find(list, p);

        if (index != -1) {
            System.out.println("The index of the first even number is: " + index);
        } else {
            System.out.println("No even number found in the collection.");
        }
    	
		
		 Set<String> strings = new HashSet<>();
	     strings.add("apple");
	     strings.add("banana");
	     strings.add("cherry");
	     strings.add("date");
	     
	     Predicate<String> startsWithAPredicate = s -> s.startsWith("a");
	   
	        
	     Set<String> result = collect(strings, startsWithAPredicate);

	       
	     System.out.println("Collected strings: " + result);
	        
	    }
	
}
