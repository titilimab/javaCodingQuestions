package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 CyclicBarrier Theory :
 Requirement- When a situation in a concurrent programming requires a set of two or more threads to wait for a predetermined execution point called the
 Barrier point until all the threads in the set have reached that point.
 To handle the above situation, the Java concurrent API supplies the CyclicBarrier class.
 It enables us to define a synchronization object which is a CyclicBarrier object by passing the action class object as a parameter which suspends until the
 specified number of threads has reached the barrier point.
 
Constructors:
CyclicBarrier(int numThreads)
CyclicBarrier(int numThreads, Runnable action)

Here, numThreads specifies the number of threads that must reach the barrier
before execution continues. In the second form, action specifies a thread that
will be executed when the barrier is reached.

Procedure:
1. create a CyclicBarrier object, specifying the number of threads that you will be waiting for. Next, when each thread reaches the barrier, have it call
await( ) on that object. This will pause execution of the thread until all of the other threads also call await( ). Once the specified number of threads has
reached the barrier, await( ) will return and execution will resume.

2. In case you have specified an action, then that action thread is executed.

wait Methods :
1. int await( ) throws InterruptedException, BrokenBarrierException
The first form waits until all the threads have reached the barrier point

2. int await(long wait, TimeUnit tu)
throws InterruptedException, BrokenBarrierException, TimeoutException
The second form waits only for the period of time specified by wait. The units represented by wait are specified by tu.
 
Note: Both the forms of the above wait() methods return a value that indicates the order that the threads arrive at the barrier point. 
The first thread returns a value equal to the number of threads waited upon minus one. The last thread returns zero.

Note:
A CyclicBarrier can be reused because it will release waiting threads each time the specified number of threads calls await() method

*/

/*
 CyclicBarrierDemo Program :
Here is an example that illustrates CyclicBarrierDemo class. 
It waits until a set of three threads have reached the barrier point. 
When that occurs, the thread specified by CyclicBarrierAction executes.
 */

public class CyclicBarrierDemo {

	public static void main(String args[]) {
		
		CyclicBarrier cb = new CyclicBarrier(3, new CyclicBarrierAction());
		
		System.out.println("*** Starting ***");
		
		new Thread(new MyThreadCyclicBar(cb, "A")).start();
		new Thread(new MyThreadCyclicBar(cb, "B")).start();
		new Thread(new MyThreadCyclicBar(cb, "C")).start();
		new Thread(new MyThreadCyclicBar(cb, "X")).start();
		new Thread(new MyThreadCyclicBar(cb, "Y")).start();
		new Thread(new MyThreadCyclicBar(cb, "Z")).start();		
	}
}

//A Thread execution that uses a CyclicBarrier

class MyThreadCyclicBar implements Runnable{
	
	CyclicBarrier cbar;
	String name;
	
	MyThreadCyclicBar(CyclicBarrier c, String n) {
		cbar = c;
		name = n;
	}
	
	public void run() {
		System.out.println("Name of Thread : "+name);
		
		try {
			cbar.await();
		}catch(BrokenBarrierException e) {
			System.out.println(e);
		}catch(InterruptedException e) {
			System.out.println(e);
		}		
	}	
}

//An Object of CyclicBarrierAction (class defined below) is called when the number of CyclicBarrier ends.

class CyclicBarrierAction implements Runnable{
	public void run() {
		System.out.println("Cyclic Barrier is reached!");
	}
}

/*
Output :

*** Starting ***
Name of Thread : A
Name of Thread : B
Name of Thread : C
Cyclic Barrier is reached!
Name of Thread : X
Name of Thread : Y
Name of Thread : Z
Cyclic Barrier is reached!



*/