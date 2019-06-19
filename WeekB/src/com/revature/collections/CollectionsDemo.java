package com.revature.collections;

import com.revature.model.*; // imports all classes/interfaces from this package
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		//funWithLists();
		//funWithSets();
		//funWithQueues();
		funWithMaps();
		//funWithIterator();
	}
	
	public static void funWithIterator() {
		
		//initialize a Collection (extends Interable interface)
		
		Set<User> userSet = new HashSet<>();
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		// userSet.add(new User("David", "Tennant", "doc10", "tardis"));
		// another way to create and add a User to the Set
		
		
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		
		/*
		 * Iterator:
		 * 
		 * - Iterable is an interface which is extended by Collection
		 * - Iterable provides methods for easy traversal of any concrete subtype
		 * 		- define interator() method, which returns an Iterator
		 * - Iterator has methods:
		 * 		- .next()
		 * 		- .hasNext()
		 * 		- .remove()
		 * - Using the Iterator allows us to safely remove elements in place and traverse multiple Collections at once
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
		 * 
		 */
		
		Iterator<User> userIterator = userSet.iterator();
		
		// use hasNext() method (which returns a boolean) as the condition for a While loop
		// it will stop as soon as there's no longer any objects left in the collection
		while(userIterator.hasNext()) {
			User u = userIterator.next(); // don't call more than once in same block - it will iterate through everything twice as fast
			// next() returns the next element, and steps forward the position of the iterator
			// could use remove() to remove elements from the Collection (filtering a Collection)
			System.out.println(u);
		}
	}
	
	public static void funWithMaps() {
		/*
		 * Map: 
		 * 
		 * - An object which maps keys to values
		 * - No duplicate keys
		 * - Every key may map to at most one value
		 * - Most implementations allow keys to be null
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
		 * 
		 */
		
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("mithrandir", "you_shall_not");
		credentialsMap.put(null, ""); // is fine, as long as there is only one null key
		credentialsMap.put("bono", null); // null values are fine, any number of keys may have null values
		credentialsMap.put("bono2", null);
		credentialsMap.put("doc10", "tardis");
		
		// retrieve objects by their keys
		System.out.println(credentialsMap.get("doc10"));
		
		// iterate through map
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println("Example of putAll method: ");
		System.out.println();
		
		Map<String, String> soccerTeamsMap01 = new HashMap<>();
		soccerTeamsMap01.put("Spain", "Barcelona");
		soccerTeamsMap01.put("France", "PSG"); 
		soccerTeamsMap01.put(null, "DC United"); 
		
		for (Map.Entry<String, String> entry : soccerTeamsMap01.entrySet()) {
			System.out.println("soccerTeamsMap01 - Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println();
		
		Map<String, String> soccerTeamsMap02 = new HashMap<>();
		soccerTeamsMap02.put("Germany", "Dortmund");
		
		for (Map.Entry<String, String> entry : soccerTeamsMap02.entrySet()) {
			System.out.println("soccerTeamsMap02 - Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println();
		
		soccerTeamsMap02.putAll(soccerTeamsMap01);
		
		for (Map.Entry<String, String> entry : soccerTeamsMap02.entrySet()) {
			System.out.println("soccerTeamsMap02 after putAll - Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
	}
	
	public static void funWithQueues() {
		/*
		 * Queue:
		 * 
		 * - Typically for holding elements while waiting to process them
		 * - Provide methods for adding, removing, and inspecting elements
		 * - Two versions for each of these behaviors: one which throws an exception if the operation fails
		 * and one which does not.
		 * - FIFO - First In First Out, except for PriorityQueue, which uses a Comparator for
		 * the elements' natural ordering
		 * - Duplicates are allowed
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
		 */
		
		Queue<User> userQueue = new LinkedList<>();
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		
		userQueue.add(u1);
		userQueue.add(u2);
		userQueue.add(u3);
		userQueue.add(u1); // Queues allow duplicates
		
		while (userQueue.size() !=0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll()); // removes and returns head of Queue
		}
		
	}
	
	public static void funWithSets() {
		/*
		 * Set:
		 * 
		 * - Sets are not ordered
		 * - Duplicate elements are not allowed (i.e. elements must be unique)
		 * - Two sets are equal if they have the same elements (enforced by equals() and hashcode() implementations)
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
		 */
		
		Set<User> userSet = new HashSet<>();
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		// no duplicates....
		// addition of duplicate elements will be ignored
		
		userSet.add(u1); // this is ignored
		// this is the same object (according to ==) as an existing element
		
		User u4 = new User("David", "Tennant", "doc10", "tardis"); // this is also ignored
		userSet.add(u4);
		// this is a different object (according to ==) with the same fields as an existing element
		// both are ignored, it's the .equals() comparison that's being used (equality, not identity)
		
		for (User user : userSet) {
			System.out.println(user);
		}
		
		// notice that insertion order is ignored!
	}
	
	public static void funWithLists() {
		/*
		 * List:
		 * 
		 * - Lists are ordered Collections
		 * - Duplicate elements are allowed
		 * 
		 * Some additional List features (beyond methods defined in Collection):
		 * - Positional access (we can access elements based on where they are in the list)
		 * (We can access/manipulate elements based on position in list)
		 * - Search: you can search for an element and retrieve its numerical position
		 * - Iteration: listIterator() expands on capabilities of Iterator
		 * - Range-view: you can access/manipulate subsets of the List
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		 * 
		 * 
		 */
		
		List<User> users = new ArrayList<>();  
		// you generally want to use the supertype of whatever Collection
		// User is the type of each element in the List, replaces the generic type parameter in List<E? specification
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		// we have an addAll() method, but it takes a Collection
		
		// duplicates are allowed, so the following should work:
		
		users.add(u1);
		
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("Size of list: " + users.size());
		
		System.out.println("-----------------------------------------");
		
		// List of Integers
		List<Integer>  integerList = new Vector<>();// wrapper class
		
		integerList.add(10); 
		// Implicitly converting from int (primitive) to Integer (Object).
		// This is called box, auto-boxing specifically.
		
		integerList.add(-255);
		integerList.add(9);
		integerList.add(345);
		integerList.add(36);
		integerList.add(456);
		
		System.out.println("integer list, in insertion order: ");
		
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		
		System.out.println("-----------------------------------------");
		
		/*
		 * Collections utility class has static methods for operating on Collection objects
		 * 
		 * sort() method:
		 * - It must be used with a Collection of Comparable elements
		 * - Otherwise, it must be provided a Comparator for that datatype 
		 * - (That is where you implement the Comparable interface for your class
		 * and create a Comparator for it)
		 * 
		 * Comparable is an interface
		 */
		
		Collections.sort(integerList);
		
		System.out.println("integer list, sorted");
		
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		
		System.out.println("-----------------------------------------");
	}
	
}
