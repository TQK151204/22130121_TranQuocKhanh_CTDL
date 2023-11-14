package Lab_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();
	public MyWordCountApp() throws FileNotFoundException {
		this.loadData();
	}
	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("data/fit.txt"));

			while (input.hasNext()) {
				String word = input.next();
				map.put(word, map.getOrDefault(word, 0) +1);
			}
			System.out.println(map);
				
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
	
		return this.map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
	        System.out.println(entry.getKey() + " - " + entry.getValue());
	    }
		
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		 Set<String> sortedKeys = new TreeSet<>(map.keySet());
		    for (String key : sortedKeys) {
		        System.out.println(key + " - " + map.get(key));
		    }
	}
	
}

