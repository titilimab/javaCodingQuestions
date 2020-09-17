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

		/*
		StringBuilder append() method :
The java.lang.StringBuilder.append() method is used to append the string representation of the passing argument to the existing sequence. 
There are 14 ways/forms in which the append() method can be used by the passing of various types of arguments

Syntax:
public StringBuilder append(String s)
		 * */

		StringBuilder sbAppend=new StringBuilder("Hello ");  
		sbAppend.append("Java");//now original string is changed  
		System.out.println("StringBuilder : append : "+sbAppend);

		/*
		 Console Output :
		 StringBuilder : append : Hello Java
		 * */

		/*
		 StringBuilder insert() method :
The java.lang.StringBuilder.insert(int offset, char c) method inserts the given string or character sequence with the existing string at the given position.
There are 12 ways/forms in which the insert() method can be used by the passing of various types of arguments.

Syntax:
public StringBuilder insert(int offset, char c)
		 * */

		StringBuilder sbInsert=new StringBuilder("Hello ");  
		sbInsert.insert(1,"Java");//now original string is changed  
		System.out.println("StringBuilder : Insert : "+sbInsert);  

		/*
		 Console Output :
		 StringBuilder : Insert : HJavaello 
		 */

		/*
		public StringBuilder replace(int startIndex, int endIndex, String str) method :
The java.lang.StringBuilder.replace(int startIndex, int endIndex, String str) method replaces the characters in a substring of the existing sequence from startIndex to endIndex with characters in the specified passing String.
There is only 1 implementation to the replace() method.

Syntax :
public StringBuilder replace(int start, int end, String str)
		 */
		StringBuilder sbReplace=new StringBuilder("Hello");  
		sbReplace.replace(1,3,"Java");  
		System.out.println("StringBuilder : Replace : "+sbReplace);//1 index = e, 3 index = l, replaces "ell" with Java. Expected output : HJavao. Observation - The endIndex character is included in the new string. Not sure why?
		/*
		 Console output :
		 StringBuilder : Replace : HJavalo
		 * */

		/*
		 public StringBuilder delete(int startIndex, int endIndex) method :
The java.lang.StringBuilder.delete(int startIndex, int endIndex) method deletes the characters in a substring of the existing sequence from startIndex to endIndex with characters in the specified passing String.
There is only 1 implementation to the delete() method.

Syntax :
public StringBuilder delete(int start, int end)		 
		 * */
		StringBuilder sbDelete=new StringBuilder("Hello");  
		sbDelete.delete(1,3);  
		System.out.println("StringBuilder : delete : "+sbDelete); //Observation - The endIndex character is included in the new string. Not sure why?
		/*
		 Console Output :
		 StringBuilder : delete : Hlo
		 * */

		/*
		 public StringBuilder reverse() method :
The java.lang.StringBuilder.reverse() method causes the character sequence/string that calls the reverse() method to be replaced by reverse of the sequence.
There is only 1 implementation to the reverse() method.

Syntax :
public StringBuilder reverse()	 
		 * */

		StringBuilder sbReverse=new StringBuilder("Hello");  
		sbReverse.reverse();  
		System.out.println("StringBuilder : reverse : "+sbReverse);//prints olleH  
		/*
		 Console Output :
		 StringBuilder : reverse : olleH  
		 * */
		/*
public int capacity() method :
The java.lang.StringBuilder.capacity() method of StringBuilder class returns the current capacity of the Builder. 
The default capacity of the Builder is 16. 
If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. 
For example if your current capacity is 16, it will be (16*2)+2=34.

Syntax :
public int capacity()
		 * */
		StringBuilder sbCapacity=new StringBuilder();  
		System.out.println("Old capacity before initialization : "+sbCapacity.capacity());//default 16  
		sbCapacity.append("Hello");  
		System.out.println("String : "+sbCapacity+"\nCapacity after string append when length of string is less than 16 : "+sbCapacity.capacity());//now 16  
		sbCapacity.append("Java is my favourite language");  
		System.out.println("String : "+sbCapacity+"\nCapacity after string append when length of string is more than 16 :"+sbCapacity.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2
		sbCapacity.append("Python is in progress.I love it!");  
		System.out.println("String : "+sbCapacity+"\nCapacity after string append when length of string is more than 34 :"+sbCapacity.capacity());//now (34*2)+2=70 i.e (oldcapacity*2)+2
		/*
Console Output :
Old capacity before initialization : 16
String : Hello
Capacity after string append when length of string is less than 16 : 16
String : HelloJava is my favourite language
Capacity after string append when length of string is more than 16 :34
String : HelloJava is my favourite languagePython is in progress.I love it!
Capacity after string append when length of string is more than 34 :70

		 * */

		/*
public int ensureCapacity(int capacity) method :
The java.lang.StringBuilder.ensureCapacity() method of StringBuilder class ensures that the given capacity is the minimum to the current capacity.  
The default capacity of the Builder is 16. 
If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. 
For example if your current capacity is 16, it will be (16*2)+2=34.

Syntax :
public int ensureCapacity(int capacity)
		 * */

		StringBuilder sbEnsureCapacity=new StringBuilder();  
		System.out.println("Old capacity before initialization : "+sbEnsureCapacity.capacity());//default 16  
		sbEnsureCapacity.append("Hello");  
		System.out.println("String : "+sbEnsureCapacity+"\nCapacity after string append when length of string is less than 16 : "+sbEnsureCapacity.capacity());//now 16  
		sbEnsureCapacity.append("java is my favourite language");  
		System.out.println("String : "+sbEnsureCapacity+"\nCapacity after string append when length of string is less than 34 : "+sbEnsureCapacity.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
		sbEnsureCapacity.ensureCapacity(10);//now no change  
		System.out.println("String : "+sbEnsureCapacity+"\nCapacity after capacity set to 10 : "+sbEnsureCapacity.capacity());//now 34  
		sbEnsureCapacity.ensureCapacity(50);//now (34*2)+2  
		System.out.println("String : "+sbEnsureCapacity+"\nCapacity after capacity set to 50 : "+sbEnsureCapacity.capacity());//now 70

		/*
		 Console Output :
Old capacity before initialization : 16
String : Hello
Capacity after string append when length of string is less than 16 : 16
String : Hellojava is my favourite language
Capacity after string append when length of string is less than 16 : 34
String : Hellojava is my favourite language
Capacity after capacity set to 10 : 34
String : Hellojava is my favourite language
Capacity after capacity set to 50 : 70
		 * */

	}






















}
