package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.Semaphore;

/*
 Semaphore : java.util.concurrent.Semaphore
 
 Q. What is Semaphore in Java concurrent utility API?
 Ans. A Semaphore provides synchronization object that helps in controlling access to a shared resource through the use of a counter.
 If the counter is greater than zero, then access is allowed. If it is zero then access is denied.
 - Counter takes care of the specified number of permits that allow access to the shared resource.
 - For a thread to access a shared resource, a thread must be granted a permit from the Semaphore.
 
 Q. Explain the process of how Semaphore counter takes care of synchronization among multiple threads trying to access the same shared resource.
 Ans. In Semaphore, the thread that wants to access to the shared resource tries to acquire a permit.
 acquire() method :
 	If the Semaphore's count is greater than zero, then the thread acquires a permit. Once the thread has been granted with the permit, the count is decremented.
	If the Semaphore's count is zero, then the thread will be blocked until a permit can be acquired.
release() method :
	When the thread no longer needs access to the shared resource, it releases the permit, which causes the Semaphore's count to be incremented.
	If there is another thread waiting for a permit, then that thread will acquire a permit at that time.
	
Q. What are the 2 constructors of a Semaphore?
Ans.
	Semaphore has 2 constructors :
		semaphore(int num)
		semaphore(int num, boolean how)
	num -  Here the num specifies the initial count. Thus, the num specifies the number of threads that can access a shared resource at any given point of time.
	If num is one, only one thread can access the shared resource at any one time. 
	
	how - By setting how to true, you can ensure that waiting threads are granted a permit in the order in which they requested access.
	By default, waiting threads are granted a permit in an undefined manner.
	
Q. Explain acquire() method in Semaphore.
Ans. 
	void acquire( ) throws InterruptedException
	void acquire(int num) throws InterruptedException
	
	The first form acquires one permit. Most often, the first form is used.
	The second form acquires num permits. 
	If the permit cannot be granted at the time of the call, then the invoking thread suspends until the permit is available.

  Open Declaration : void java.util.concurrent.Semaphore.acquire() throws InterruptedException
  
public void acquire() throws InterruptedException

Acquires a permit from this semaphore, blocking until one is available, or the thread is interrupted. 
Acquires a permit, if one is available and returns immediately, reducing the number of available permits by one. 

If no permit is available then the current thread becomes disabled for thread scheduling purposes and lies dormant until one of two things happens,
Some other thread invokes the release() method for this semaphore and the current thread is next to be assigned a permit; or Some other thread interrupts the current thread. 

If the current thread has its interrupted status set on entry to this method; or is interrupted while waiting for a permit, 
then InterruptedException is thrown and the current thread'sinterrupted status is cleared.Throws:InterruptedException - if the current thread is interrupted  

Q. Explain the release() method in Semaphore.
Ans.
	void release( )
	void release(int num)
	
	The first form releases one permit. 
	The second form releases the number of permits specified by num.
	
	To use a semaphore to control access to a resource, each thread that wants to use that resource must first call acquire( ) before accessing the resource. 
	When the thread is done with the resource, it must call release( ).
	
From Oracle documentation :
	
void java.util.concurrent.Semaphore.release()

public void release()

Releases a permit, returning it to the semaphore. 
Releases a permit, increasing the number of available permits by one. 
If any threads are trying to acquire a permit, then one is selected and given the permit that was just released. 
That thread is (re)enabled for thread scheduling purposes. 

There is no requirement that a thread that releases a permit must have acquired that permit by calling acquire(). 
Correct usage of a semaphore is established by programming convention in the application.

 * */

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);

		new Thread(new IncrementThread(sem, "IncrementThread")).start();
		new Thread(new DecrementThread(sem, "DecrementThread")).start();
	}
}

class SharedResource{
	static int countShared = 0;
}

//A Thread Execution that increments the count
class IncrementThread implements Runnable{

	String name;
	Semaphore sem;

	public IncrementThread(Semaphore s, String n) {
		sem = s;
		name = n;
	}

	public void run() {
		System.out.println("Starting the Thread : "+name);

		try {
			//First, get a permit from the Semaphore by acquire() method
			System.out.println(name+" is waiting for a permit");
			sem.acquire();
			System.out.println(name+" gets a permit");

			//Second, access the shared resource once permit is granted from the Semaphore
			for(int i=0; i<5; i++) {
				SharedResource.countShared++;
				System.out.println(name+" : "+SharedResource.countShared);
			}

			//Third, Allow a context switch -- if possible
			Thread.sleep(10);
		}
		catch(InterruptedException exc) {
			System.out.println(exc);
		}

		//Fourth, Release the permit back to the Semaphore by release() method
		System.out.println(name+" releases the permit");
		sem.release();
	}

}

//A Thread that decrements the count
class DecrementThread implements Runnable{

	String name;
	Semaphore sem;

	public DecrementThread(Semaphore s, String n) {
		sem = s;
		name = n;	
	}

	public void run() {
		System.out.println("Starting the Thread : "+name);

		try {
			//First, get a permit from Semaphore by acquire() method
			System.out.println(name+" is waiting for a permit");
			sem.acquire();
			System.out.println(name+" gets a permit");

			//Second, access the shared resource once permit is granted from the Semaphore
			for(int i=0; i<5; i++) {
				SharedResource.countShared--;
				System.out.println(name+" : "+SharedResource.countShared);
			}

			//Third, Allow a context switch if possible
			Thread.sleep(10);	
		}
		catch(InterruptedException exc) {
			System.out.println(exc);	
		}

		//Fourth, Release the permit back to Semaphore by release() method
		System.out.println(name+" releases the permit");
		sem.release();
	}
}

/*
Starting the Thread : IncrementThread
IncrementThread is waiting for a permit
Starting the Thread : DecrementThread
IncrementThread gets a permit
DecrementThread is waiting for a permit
IncrementThread : 1
IncrementThread : 2
IncrementThread : 3
IncrementThread : 4
IncrementThread : 5
IncrementThread releases the permit
DecrementThread gets a permit
DecrementThread : 4
DecrementThread : 3
DecrementThread : 2
DecrementThread : 1
DecrementThread : 0
DecrementThread releases the permit

 * */

/*
 
Open Declaration   java.util.concurrent.Semaphore

A counting semaphore. Conceptually, a semaphore maintains a set of permits. 
Each acquire() blocks if necessary until a permit is available, and then takes it. Each release() adds a permit,potentially releasing a blocking acquirer.
However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly. 
Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource. 
For example, here is a class that uses a semaphore to control access to a pool of items: 
 
 class Pool {
   private static final int MAX_AVAILABLE = 100;
   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

   public Object getItem() throws InterruptedException {
     available.acquire();
     return getNextAvailableItem();
   }

   public void putItem(Object x) {
     if (markAsUnused(x))
       available.release();
   }

   // Not a particularly efficient data structure; just for demo

   protected Object[] items = ... whatever kinds of items being managed
   protected boolean[] used = new boolean[MAX_AVAILABLE];

   protected synchronized Object getNextAvailableItem() {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (!used[i]) {
          used[i] = true;
          return items[i];
       }
     }
     return null; // not reached
   }

   protected synchronized boolean markAsUnused(Object item) {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (item == items[i]) {
          if (used[i]) {
            used[i] = false;
            return true;
          } else
            return false;
       }
     }
     return false;
   }
 }

Before obtaining an item each thread must acquire a permit from the semaphore, guaranteeing that an item is available for use.
When the thread has finished with the item it is returned back to the pool and a permit is returned to the semaphore, allowing another thread to acquire that item. 
Note that no synchronization lock is held when acquire() is called as that would prevent an item from being returned to the pool. 
The semaphore encapsulates the synchronization needed to restrict access to the pool, separately from any synchronization needed to maintain the consistency of the pool itself. 

A semaphore initialized to one, and which is used such that it only has at most one permit available, can serve as a mutual exclusion lock. 
This is more commonly known as a binary semaphore, because it only has two states: one permit available, or zero permits available. 
When used in this way, the binary semaphore has the property (unlike many Lock implementations), that the "lock" can be released by a thread other than the owner (as semaphores have no notion of ownership). 
This can be useful in some specialized contexts, such as deadlock recovery. 

The constructor for this class optionally accepts a fairness parameter. 
When set false, this class makes no guarantees about the order in which threads acquire permits. 
In particular, barging is permitted, that is, a thread invoking acquire() can be allocated a permit ahead of a thread that has been waiting - logically the new thread places itself at the head of the queue of waiting threads. 
When fairness is set true, the semaphore guarantees that threads invoking any of the acquire methods are selected to obtain permits in the order in which their invocation of those methods was processed(first-in-first-out; FIFO). 
Note that FIFO ordering necessarily applies to specific internal points of execution within these methods. 
So, it is possible for one thread to invoke acquire before another, but reach the ordering point after the other, and similarly upon return from the method.
Also note that the untimed tryAcquire methods do not honor the fairness setting, but will take any permits that are available. 

Generally, semaphores used to control resource access should be initialized as fair, to ensure that no thread is starved out from accessing a resource. 
When using semaphores for other kinds of synchronization control, the throughput advantages of non-fair ordering often outweigh fairness considerations. 

This class also provides convenience methods to acquire and release multiple permits at a time. 
Beware of the increased risk of indefinite postponement when these methods are used without fairness set true. 

Memory consistency effects: Actions in a thread prior to calling a "release" method such as release() happen-before actions following a successful "acquire" method such as acquire()in another thread.

Since:1.5
 
 * */


