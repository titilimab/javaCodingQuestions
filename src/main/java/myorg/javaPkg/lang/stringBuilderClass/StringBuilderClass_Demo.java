package myorg.javaPkg.lang.stringBuilderClass;

/*
 Notes :

 Q. What is a String Builder class in Java?
 Ans. The StringBuilder class in java represents a mutable sequence of characters.
 StringBuilder is a part of java.lang package.
 It was first introduced in JDK 1.5

 Q. Show the hierarchy and signature of StringBuilder Class
 StringBuilder class is a part of java.lang package.
 It extends/inherits java.lang.Object class which is the root of the class hierarchy.

 java.lang.Object
 	java.lang.StringBuilder

 Implemented Interfaces :
 Serializable, ChaeSequence, Appendable

 Signature -
  	public final class StringBuilder
  	extends Object
  	implements Serializable, CharSequence. Appendable

Q. What are the difference between Classes - String, StringBuffer and StringBuilder
String - String class in Java creates an immutable sequence of characters
StringBuilder - StringBuilder class provides an alternative to String class, but it creates mutable sequence of characters
				StringBuilder does not provide synchronization. Hence it is not Thread safe in a concurrent/multi-thread programming environment.
				Its performance is better than StringBuffer as it does not take care of Synchronization.
StringBuffer - StringBuffer class provides an alternative to String class. but it creates mutable sequence of characters
				StringBuffer class takes care of synchronization. Hence it is Thread safe in a concurrent/multi-thread programming environment.
				StringBuffer performance is slower than StringBuilder as it takes care of Synchronization that comes as a performance overhead.


Q. Provide the note from Oracle documentation on StringBuilder:
Ans. 
java.lang.StringBuilder

A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization.
This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). 
Where possible,it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations. 
The principal operations on a StringBuilder are the append and insert methods, which are overloaded so as to accept data of any type. 
Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string builder. 
The append method always adds these characters at the end of the builder; the insert method adds the characters at a specified point. 

For example, if z refers to a string builder object whose current contents are "start", 
then the method call z.append("le") would cause the string builder to contain "startle", whereas z.insert(4, "le") would alter the string builder to contain "starlet". 

In general, if sb refers to an instance of a StringBuilder,then sb.append(x) has the same effect as sb.insert(sb.length(), x). 

Every string builder has a capacity. 
As long as the length of the character sequence contained in the string builder does not exceed the capacity, it is not necessary to allocate a new internal buffer. 
If the internal buffer overflows, it is automatically made larger. 

Instances of StringBuilder are not safe for use by multiple threads. If such synchronization is required then it is recommended that StringBuffer be used. 

Unless otherwise noted, passing a null argument to a constructor or method in this class will cause a NullPointerException to be thrown.

Since:JDK 1.5

 * */

public class StringBuilderClass_Demo {

	public static void main(String[] args) {

		/*

StringBuilder Constructors and Descriptions :

StringBuilder() :
Constructs a string builder with no characters in it and an initial capacity of 16 characters.

StringBuilder(CharSequence seq) :
Constructs a string builder that contains the same characters as the specified CharSequence.

StringBuilder(int capacity) :
Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.

StringBuilder(String str) :
Constructs a string builder initialized to the contents of the specified string.	  

		 */	
		//create a StringBuilder object using StringBuilder() constructor 
		StringBuilder str = new StringBuilder(); 
		str.append("New York"); 
		System.out.println("Constructor-StringBuilder() : String : "+ str); 

		// create a StringBuilder object using StringBuilder(CharSequence) constructor 
		StringBuilder str1 = new StringBuilder("ABRACADABRA"); 
		System.out.println("Constructor-StringBuilder(CharSequence) : String1 : "+ str1); 

		// create a StringBuilder object using StringBuilder(capacity) constructor 
		StringBuilder str2 = new StringBuilder(10); 
		System.out.println("Constructor-StringBuilder(capacity) : String2 : capacity = "+ str2.capacity()); 

		// create a StringBuilder object using StringBuilder(String) constructor 
		StringBuilder str3 = new StringBuilder("SimpleString"); 
		System.out.println("Constructor-StringBuilder(String) : String3 : "+ str3);

		/*
Console Output :

Constructor-StringBuilder() : String : New York
Constructor-StringBuilder(CharSequence) : String1 : ABRACADABRA
Constructor-StringBuilder(capacity) : String2 : capacity = 10
Constructor-StringBuilder(String) : String3 : SimpleString

		 * */

	}






















}
