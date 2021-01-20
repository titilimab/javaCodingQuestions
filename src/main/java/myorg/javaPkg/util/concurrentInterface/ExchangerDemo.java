package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.Exchanger;

/*
 ******************************
 Exchanger class :
 - The most interesting of the synchronization classes are Exchanger.
 - It is designed to simplify the exchange of data between two threads.
 - And exchanger object simply waits until two separate threads call exchange() method on the same exchanger object
 - When exchange method is called, it exchanges data supplied by the two threads
 
 Real time Use case : 
 One thread might prepare a buffer for receiving information over network connection.
 Another thread might fill that buffer with the information from the connection.
 The two threads work together synchronously so that each time a new buffer is needed, an exchange of data is made.
 
Declaration and Syntax :
	Exchanger is a generic class that is declared as shown here:
		Exchanger<V>
	Here, V specifies the type of the data being exchanged.

	- The only method defined by Exchanger is exchange( ), which has the two forms shown here:
		V exchange(V objRef) throws InterruptedException
		V exchange(V objRef, long wait, TimeUnit tu) throws InterruptedException, TimeoutException
		
		objRef is a reference to the data to exchange. The data received from the other thread is returned. 
		The second form of exchange( ) allows a time-out period to be specified. 
		
Note :
The key point about exchange( ) is that it won�t succeed until it has been called on the same Exchanger object by two separate threads.
Thus, exchange( ) synchronizes the exchange of the data.

 */



/*
*****************************************
Theory of exchange() method:

Declaration : String java.util.concurrent.Exchanger.exchange(String x) throws InterruptedException

1. This method Waits for another thread to arrive at this exchange point (unless the current thread is interrupted),
and then transfers the given object to it, receiving its object in return. 

2. If another thread is already waiting at the exchange point then it is resumed for thread scheduling purposes and receives the object passed in by the current thread. 
The current thread returns immediately,receiving the object passed to the exchange by that other thread. 

3. If no other thread is already waiting at the exchange then the current thread is disabled for thread scheduling purposes and lies dormant until one of two things happens: 
� Some other thread enters the exchange; 
		or 
� Some other thread interrupts the current thread. 

If the current thread: 
�has its interrupted status set on entry to this method; 
		or 
�is interrupted while waiting for the exchange, 
then InterruptedException is thrown and the current thread's interrupted status is cleared.

Parameters:x the object to exchange

Returns:the object provided by the other thread

Throws:InterruptedException - if the current thread was interrupted while waiting
 * */	

/*
 Program :
 Create two threads. One thread creates an empty buffer that will receive the data put into it by the second thread. 
 In this case, the data is a string. Thus, the first thread exchanges an empty string for a full one.
 * */

public class ExchangerDemo {
	
	public static void main(String args[]) {
		Exchanger<String> exMainObj = new Exchanger<String>();
		
		new Thread(new UseString(exMainObj)).start();
		new Thread(new MakeString(exMainObj)).start();
	}

}

//Define a Thread that makes/constructs a string
class MakeString implements Runnable{
	Exchanger<String> exMakeString;
	String strMakeString;

	//Constructor
	public MakeString(Exchanger<String> c) {
		exMakeString = c;
		strMakeString = new String();
	}

	public void run() {
		char ch = 'A';

		/*Construct a string with consecutive 5 characters from what is initialized with ch. 
		For example, if ch='A', strMakeString should be ABCDE from index 0 to 4 */

		for(int i=0; i<3; i++) {

			for(int j=0; j<5; j++) {

				//Fill the buffer. Here the buffer is strMakeString which will be later exchanged with UseString thread
				strMakeString += ch++;

				try {
					//Exchange a full buffer for an empty one
					strMakeString = exMakeString.exchange(strMakeString);
				}
				catch(InterruptedException e) {
					System.out.println(e);
				}
			}//End of inner for loop
		}//End of outer for loop		
	}//End of run()
}//End of MakeString Thread

//Define a Thread that will use a string from the buffer
class UseString implements Runnable{

	Exchanger<String> exUseString;
	String strUseString;
	
	//Constructor
	UseString(Exchanger<String> c){
		exUseString = c;
	}

	public void run() {
		for(int i=0; i<3; i++) {
			try {
				//Exchange an empty buffer for a full one
				strUseString = exUseString.exchange(new String());
				System.out.println("Retrieved from buffer : "+strUseString);

			}catch(InterruptedException e){
				System.out.println(e);
			}
		}//End of for loop
	}//End of run()
}// End of UseString Thread

