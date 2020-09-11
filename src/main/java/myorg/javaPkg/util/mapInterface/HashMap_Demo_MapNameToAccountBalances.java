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
			System.out.print(me.getKey()+":");
			System.out.println(me.getValue());
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
