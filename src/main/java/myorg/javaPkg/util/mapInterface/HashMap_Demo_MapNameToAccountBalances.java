package myorg.javaPkg.util.mapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_Demo_MapNameToAccountBalances {
	
	public static void main(String[] args) {
		
		/*
		Create a HashMap : 
		Key : String : To hold Account Holder Name
		Value : Double : To hold Balance
		
		Note :
		A hash map does not guarantee the order of its elements. 
		Therefore, the order in which elements are added to a hash map is not necessarily the order in which they are read by an iterator.
		
		**** Types of constructors for HashMap ****
		
		1.	public HashMap() :
			Constructs an empty HashMap with the default initial capacity(16) and the default load factor (0.75).
			
		2.	public HashMap(int initialCapacity) :
			Constructs an empty HashMap with the specified initialCapacity and the default load factor (0.75).
			
			Parameters:initialCapacity - the initial capacity.
			
			Throws:IllegalArgumentException - if the initial capacity is negative.
			
		3.	public HashMap(Map<? extends K,? extends V> m) :
			Constructs a new HashMap with the same mappings as the specified Map. 
			The HashMap is created with default load factor (0.75) and an initial capacity sufficient to hold the mappings in the specified Map.
			
			Parameters:m - the map whose mappings are to be placed in this map
			
			Throws:NullPointerException - if the specified map is null
			
		4.	public HashMap(int initialCapacity, float loadFactor) :
			Constructs an empty HashMap with the specified initial capacity and load factor.
			
			Parameters:initialCapacity - the initial capacity, loadFactor - the load factor
			
			Throws:IllegalArgumentException - if the initial capacity is negative or the load factor is non positive
			
		 ******Performance of HashMap depends on 2 parameters:****
			
			Initial Capacity
			Load Factor

		1.	Initial Capacity � It is the capacity of HashMap at the time of its creation (It is the number of buckets a HashMap can hold when the HashMap is instantiated). 
			In java, it is 2^4=16 initially, meaning it can hold 16 key-value pairs.
			
		2.	Load Factor � It is the percent value of the capacity after which the capacity of Hashmap is to be increased (It is the percentage fill of buckets after which Rehashing takes place). 
			In java, it is 0.75f by default, meaning the rehashing takes place after filling 75% of the capacity.

		3.	Threshold � It is the product of Load Factor and Initial Capacity. In java, by default, it is (16 * 0.75 = 12). 
			That is, Rehashing takes place after inserting 12 key-value pairs into the HashMap.
			
		4.	Rehashing � It is the process of doubling the capacity of the HashMap after it reaches its Threshold. 
			In java, HashMap continues to rehash(by default) in the following sequence � 2^4, 2^5, 2^6, 2^7, �. so on.
			
		Note.	If the initial capacity is kept higher then rehashing will never be done. 
			But by keeping it higher it increases the time complexity of iteration. 
			So it should be chosen very cleverly to increase performance.
			The expected number of values should be taken into account to set initial capacity. 
			Most generally preferred load factor value is 0.75 which provides a good deal between time and space costs. 
			Load factor�s value varies between 0 and 1.
		*/
		
		HashMap<String, Double> hm = new HashMap<String, Double>();
		
		//Put elements into the HashMap as Key-Value pair
		hm.put("John Doe", 3434.34);
		hm.put("Tom Smith", 123.22);
		hm.put("Jane Baker", 1378.00);
		hm.put("Tod Hall", 99.22);
		hm.put("Ralph Smith", -19.08);
		
		//Print Size of the HashMap
		System.out.println("Size of the HashMap : "+hm.size());
		
		//Print Contents of the HashMap
		System.out.println("Content of the HashMap : \n"+hm);
		
		//Retrieve a set of all the entries stored in the HashMap
		/* 
		 **** All about entrySet() method : *****
		 
		Set<Entry<String, Double>> java.util.HashMap.entrySet()
		
		public Set<Map.Entry<K,V>> entrySet()

		Returns a Set view of the mappings contained in this map.The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. 
		If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by the iterator) the results of the iteration are undefined. 
		The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations. 
		It does not support the add or addAll operations.
		
		Specified by:entrySet in interface Map<K,V>
		
		Specified by:entrySet in class AbstractMap<K,V>
		
		Returns:a set view of the mappings contained in this map
		
		**** All about Map.Entry
		java.util.Map.Entry<String, Double>
		
		A map entry (key-value pair). 
		The Map.entrySet method returns a collection-view(collection view means view in the form of any collection of java.util.Collection Interface) of the map in the form of a set, whose elements are of this class. 
		The only way to obtain a reference to a map entry is from the iterator of this collection-view. 
		These Map.Entry objects are valid only for the duration of the iteration; 
		more formally,the behavior of a map entry is undefined if the backing map has been modified after the entry was returned by the iterator, except through the setValue operation on the map entry.
		*/
		System.out.println("\n***Display the HashMap Entries using entrySet() method : \n");
		Set<Map.Entry<String,Double>> set = hm.entrySet();
		
		//Diaplay the set
		for(Map.Entry<String, Double> me : set) {
			System.out.println(me.getKey()+":"+me.getValue());
		}
		
		System.out.println();
		
		//Deposit 1000 onto John Does account . 1000 should be added to the existing amount of 3434.34. Total Balance = 4434.34
		Double balance = hm.get("John Doe");
		hm.put("John Doe", balance+1000);
		
		//Display John Doe's new balance 
		System.out.println("John Doe 's new balance : "+hm.get("John Doe"));
		
		/*Console Output :
		 
		Size of the HashMap : 5
		Content of the HashMap : 
		{Tod Hall=99.22, John Doe=3434.34, Ralph Smith=-19.08, Tom Smith=123.22, Jane Baker=1378.0}
		
		***Display the HashMap Entries using entrySet() method : 
		
		Tod Hall:99.22
		John Doe:3434.34
		Ralph Smith:-19.08
		Tom Smith:123.22
		Jane Baker:1378.0
		
		John Doe 's new balance : 4434.34

		*/

	}

}
