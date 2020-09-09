package myorg.javaPkg.util.collectionInterface;

import java.util.ArrayList;
import java.util.Scanner;

/*
  
 - ArrayList class extends AbstractList and implements the List interface .
 - ArrayList is a generic class that has the below declaration :
 	class ArrayList<E>
 	Here, E specifies the type of object that the ArrayList will hold
 	
- ArrayList provides dynamic arrays in Java that can grow as needed. It is gowable in nature.
- Q. Why ArrayList came into picture?
Ans. In Java, the standard arrays are of fixed length. After arrays are created, they can not grow or shrink.
	That means you must know in advance, how many elements an array will hold. But, sometimes, you may not know until run time precisely how large an array you need.
	To handle this situation, the Collections Framework defines ArrayList. ArrayList is growable in nature and a variable-length array of object references.
	That is, an ArrayList can dynamically increase or decrease in size. 
	ArrayLists are created with an initial size. When this size is exceeded, the collection is automatically enlarged.
	When objects are removed from the ArrayList, the size can be automatically reduced
	
- Q. What are the constructors of ArrayList class?
Ans. ArrayList class provides below 3 constructors

	- public ArrayList() : Constructs an empty list with an initial capacity of ten
	
	- public ArrayList(Collection<? extends E> c)
	Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
	Parameters:c - the collection whose elements are to be placed into this list.
	Throws:NullPointerException - if the specified collection is null
	
	- public ArrayList(int initialCapacity)
	Constructs an empty list with the specified initial capacity.
	Parameters:initialCapacity - the initial capacity of the list
	Throws:IllegalArgumentException - if the specified initial capacity is negative
 
 -Q. How to increase the capacity of an ArrayList manually by calling ensureCapacity() method?
 Ans.	Although the capacity of an ArrayList object increases automatically, as objects are stored in it. you can increase the capacity of an ArrayList manually
 		by calling ensureCapacity() method.
 		You might want to do this if you know in advance that you will be storing many more items in the collection than it can currently hold. 
 		By increasing its capacity once, at the start, you can prevent several reallocations later. 
 		Because reallocations are costly in terms of time, preventing unnecessary ones improves performance.
 		
 		- The method signature for ensureCapacity() is as below :
 		public void ensureCapacity(int minCapacity)
		Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
		Parameters:minCapacity - the desired minimum capacity
 
 
 
*/

public class ArrayList_Demo {

	public static void main(String[] args) {

		//Create an ArrayList
		ArrayList<String> arrList = new ArrayList<String>();

		//size() : Method to find size of ArrayList
		System.out.println("Initial size of ArrayList when no elements are added : "+arrList.size());

		//Add Elements to the ArrayList
		Scanner sn = new Scanner(System.in);
		for(int i=0; i<6; i++) {
			arrList.add(sn.next());
		}

		//size() : Method to find size of ArrayList
		System.out.println("Size of ArrayList after elements are added : "+arrList.size());

		//Display the arrayList
		System.out.println("Display the contents of the ArrayList after elements are added : "+arrList);

		//remove() : Method to remove elements from ArrayList : based on index
		arrList.remove(2);

		//size() : Method to find size of ArrayList
		System.out.println("Size of ArrayList after elements are removed : "+arrList.size());

		//Display the arrayList
		System.out.println("Display the contents of the ArrayList afyter elements are removed : "+arrList);

	}

}
