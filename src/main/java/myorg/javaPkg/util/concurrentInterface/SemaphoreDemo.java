package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.Semaphore;

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


