package Lab_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<>();
		for(String w : words) {
			WordCount wc = new WordCount(w, comtWord(w));
			if(re.contains(wc))
			re.add(wc);
				
			
		}
		return re;
	}

	private int comtWord(String w) {
		int  count =0;
		for(String word : words) {
			if(word.equals(w)) {
				count ++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String > re = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for(WordCount wc : list) {
			if(wc.getCount() == 1) {
				re.add(wc.getWord());
			}
		}
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> distincWords = new HashSet<>();
		for(String w : words) {
			distincWords.add(w);
			
		}
		
		return distincWords;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount>  exportWordCounts() {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				
				return o1.getWord().compareTo (o2.getWord());
			}
		});
		 re.addAll(getWordCounts());
		 
		return re;
	}
	

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				
				return - (o1.getCount() - o2.getCount());
			}
		});
		 re.addAll(getWordCounts());
		 
		return re;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		
		Set<String> filteredWords = new HashSet<>();
		
		for(String w : words) {
			if(!w.startsWith(pattern)) {
				filteredWords.add(w);
			}
		}
		
		return filteredWords;
	}
}
