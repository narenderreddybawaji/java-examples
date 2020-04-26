package com.streamseg.a;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class shows ways to create diff collections. Also, we can use arrays
 * initially instead list/set/map to write code quickly. May or may not wise for
 * actual code practice.
 * 
 */
public class SreamCollectorsEg {

	public void createLst() {
		Book[] bookArr = { new Book(1, "book1", "auther1"), new Book(2, "book2", "auther2"),
				new Book(3, "book3", "auther3") };

		/* (a) Arrays.asList -> But this can only be use to return ArrayList */
		List<Book> bookList1 = Arrays.asList(bookArr); // LinkedList ll = new
														// LinkedList(Arrays.asList(bookArr));

		/* (b) Streams */
		
		// (b.1) List
		// To create ArrayList
		List<Book> bookList2 = Stream.of(bookArr).collect(Collectors.toList());
		// To create LinkedList
		List<Book> bookList3 = Stream.of(bookArr).collect(Collectors.toCollection(LinkedList::new));

		// (b.2) Set
		// To create HashSet
		Set<Book> bookSet = Stream.of(bookArr).collect(Collectors.toSet());

		// (b.3) Map
		// To create HashMap based on book id as map key & book obj as value.
		// Function.identity() can use to have all fields
		Map<Integer, Book> bookMap = Stream.of(bookArr).collect(Collectors.toMap(Book::getBookId, Function.identity()));
		
		// To create LinkedHashMap based on book id as map key & book title as
		// value.
		Map<Integer, String> bookMap2 = Stream.of(bookArr)
				.collect(Collectors.toMap(Book::getBookId, Book::getTitle, null, LinkedHashMap::new));

	}

	public static void main(String[] args) {
		SreamCollectorsEg obj = new SreamCollectorsEg();
	}

}
