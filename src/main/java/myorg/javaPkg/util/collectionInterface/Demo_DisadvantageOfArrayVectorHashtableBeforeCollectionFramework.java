package myorg.javaPkg.util.collectionInterface;

import java.util.Hashtable;
import java.util.Vector;

/*
 Q. What is the need for a separate collection framework in Java?
Ans. In Java a separate Collection Framework was introduced in JDK 1.2 which contains all the Collection classes and interfaces in it(Collection Interface – java.util.Collection, Map Interface – java.util.Map).Before Collection /framework was introduced in JDK 1.2, the standard methods for grouping Java objects(or collections) were 
	-	Arrays
	-	Vectors
	-	Hashtables
All of the above collections(Arrays, Vectors, Hashtables) had no common interface. Hence, although the main aim of all the collections are same(aim – to search, sort, insert, manipulate, delete the objects in the collection), the implementation of the common operations like search, sort, insert, manipulate, delete were defined differently and independently and had no correlation among them. Hence, there was lack of a central, unifying theme.
It was also very difficult for the developers and the users to remember all the different methods, syntax and constructors present in every separate collection class.
Therefore, it was decided to have a central framework for all types of collection to perform similar kind of operations like- search, sort, insert, manipulate, delete objects in a collection.

 * */

public class Demo_DisadvantageOfArrayVectorHashtableBeforeCollectionFramework {

	public static void main(String[] args) {

		//Creating instances of the array and at the same time adding elements into the array
		int arrInt[] = new int[] { 1, 2, 3, 4 }; 
		
		//Creating instances of the vector
		Vector<Integer> vec = new Vector(); 

		//Creating instances of the Hashtable
		Hashtable<Integer, String> ht 
		= new Hashtable(); 

		/* Instance Creation : 
		In the above we observed the difference mechanisms to create the objects for Array, Vector and Hashtable
		 Array - Array instance creation requires []
		 Vector and Hashtable - Vector and Hashtable require ()
		*/
		
		// Adding the elements into the vector 
		vec.addElement(1); 
		vec.addElement(2); 

		// Adding the element into the Hashtable 
		ht.put(1, "collection interface"); 
		ht.put(2, "map interface"); 
		
		/*
		Adding Elements : 
		In the above we observed the different mechanisms to add the elements into Vector and Hashtable
		Vector - element insertion requires addElement(), 
		Hashtable - element insertion requires put()  
		 */

		// Accessing the first element of the array, vector and hashtable 
		System.out.println("Array - Element at 0th index : "+arrInt[0]); 
		System.out.println("Vector - Element at 0th index : "+vec.elementAt(0)); 
		System.out.println("Hashtable - Element at 0th index : "+ht.get(1)); 

		/* In the above we observed the diffent methods to access the elements from the different collections
		  Array elements are accessed using [], 
		 Vector elements using elementAt() 
		 Hashtable elements using get() 
		 */
		
		/*Conclusion - Even if we wanted to add, access the elements but the methods are different for the different collection. 
		 Hence we require a central, unifying framework to have common methods to achieve the similar operations for all types of collections
		 */
		
		/*
		Output :
			Array - Element at 0th index : 1
			Vector - Element at 0th index : 1
			Hashtable - Element at 0th index : collection interface
		*/

	} 
} 