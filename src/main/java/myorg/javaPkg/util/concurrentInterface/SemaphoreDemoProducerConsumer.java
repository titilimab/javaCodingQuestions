package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.Semaphore;

/*
 An implementation of a producer and consumer that uses semaphores to control synchronization
 Program : The producer class produces a value through put method
 The Consumer class consumes the value through get method
 The synchronization of accessing the value by producer and consumer classes is achieved by Semaphore
 First Producer acquires the permit from Producer Semaphore semProd then puts/produces a value and then releases the Consumer Semaphore semCon for Consumer to consume it.
 Then Consumer acquires the permit from Consumer Semaphore semCon and gets/consumes the value and then finally releases the Producer Semaphore semProd for Producer to act upon it.

 This way synchronization is maintained between put() method in Producer class and get() method in Consumer class.

 * */
class Q{

	int n;

	//Start with consumer Semaphore unavailable. Hence, initilaize the semaphore with count 0

	/*
	Note :  Please note that semCon is initialized with no available permits that is 0.
	This ensures that put() method executes first.
	The ability to set the initial synchronization state is one of the more powerful aspects of a semaphore.
	 * */
	static Semaphore semCon = new Semaphore(0);

	//producer Semaphore. This is available. Hence, initialize the semaphore with count 1
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			semCon.acquire();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted exception caught in get method while semCon.acquire() gets executed");
		}

		System.out.println("Got : "+n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted exception caught in put method while semProd.acquire() gets executed");
		}
		this.n = n;
		System.out.println("Put : "+n);
		semCon.release();		
	}
}

// Producer class that implements Runnable by giving definition to run() method

class Producer implements Runnable{
	Q q;

	Producer(Q q){
		this.q = q;
	}

	public void run() {
		for(int i=0; i<5; i++)
			q.put(i);
	}
}

// Consumer class that implements Runnable by giving definition to run() method
class Consumer implements Runnable{
	Q q;

	Consumer(Q q){
		this.q = q;
	}

	public void run() {
		for(int i=0; i<5; i++)
			q.get();	
	}	
}

//Main class that creates the Consumer and Producer Threads and start the Threads

public class SemaphoreDemoProducerConsumer {

	public static void main(String args[]) {
		Q q = new Q();
		Thread ConsumerThread = new Thread(new Consumer(q), "Consumer");
		ConsumerThread.start();
		Thread ProducerThread = new Thread(new Producer(q), "Producer");
		ProducerThread.start();
	}
}

/*Output :

Put : 0
Got : 0
Put : 1
Got : 1
Put : 2
Got : 2
Put : 3
Got : 3
Put : 4
Got : 4
 */

/*
 Observation on output :
 - In the above output we can see that the calls to put() and get() methods are perfectly synchronized.
 That means each call to put() method is followed by a call to get() method and no values are missed.
 - Without the semaphores, multiple calls to put() method would have occurred without matching calls to get() resulting values being missed.
 - The sequencing of put() method and get() calls is handled by two semaphores : semProd and semCon
 - Before put() method can produce a value, it must acquire a permit from semProd. After it has set the value, it releases semCon for the get() method to acquire.
 - Before get() method can consume a value, it must acquire a permit from semCon. After it consumes the value, it releases semProd for the put() method to acquire.
 * */

