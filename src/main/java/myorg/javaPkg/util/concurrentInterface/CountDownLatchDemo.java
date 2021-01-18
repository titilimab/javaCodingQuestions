package myorg.javaPkg.util.concurrentInterface;

import java.util.concurrent.CountDownLatch;

/*
 CountDownLatch Theory :
 
 Requirement/Problem Statement :
 Sometimes we want a thread to wait until one or more events have occurred.
 Solution:
 To handle such situation, the concurrent API supplies CountDownLatch.
 - The CountDownLatch object is initially created with a count of the number that refers the number of events that must occur before latch is released.
 - The number that represents the maximum count of events is passed a parameter to the CountDownLatch constructor at the time of object creation.
 - Each time an event happens, the count is decremented.
 - when the count reaches zero, the latch/lock opens.
 
 Methods in CountDownLatch class :
 -constructor method :
 	CountDownLatch(int num) : Here num specifies the number of events that must occur in order for the latch to open.
 -Other methods :
 	wait methods for the latch to open.
 	void await( ) throws InterruptedException
	boolean await(long wait, TimeUnit tu) throws InterruptedException
- countDown() method to decrement the count of events associated with the invoking object.
   
 * */

public class CountDownLatchDemo {

	public static void main(String args[]) {

		CountDownLatch cdl = new CountDownLatch(5);
		System.out.println("****Starting the Thread****");

		Thread cdlThread = new Thread(new MyThread(cdl));
		cdlThread.start();

		try {
			cdl.await();	
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println("\nThread execution done and latch is released.");	
	}
}

class MyThread implements Runnable{

	CountDownLatch latch;

	public MyThread(CountDownLatch c) {
		latch = c;
	}

	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(i);

			//Print the latch count before countDown() method is called
			long latchCountBefore = latch.getCount();
			System.out.println("****latch count before countDown() method being called : "+latchCountBefore);

			//call the countDown() method
			latch.countDown();

			//Print the latch count after countDown() method is called. latch count should get decreased after countDown() method is called
			long latchCountAfter = latch.getCount();
			System.out.println("****latch count after countdown() method is called : "+latchCountAfter);		
		}

	}
}

/*
 Sample output :
 ****Starting the Thread****
0
****latch count before countDown() method being called : 5
****latch count after countdown() method is called : 4
1
****latch count before countDown() method being called : 4
****latch count after countdown() method is called : 3
2
****latch count before countDown() method being called : 3
****latch count after countdown() method is called : 2
3
****latch count before countDown() method being called : 2
****latch count after countdown() method is called : 1
4
****latch count before countDown() method being called : 1
****latch count after countdown() method is called : 0

Thread execution done and latch is released.
 
 * */
