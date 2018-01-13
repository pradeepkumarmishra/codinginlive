/*@Author:Pradeep Mishra
 * 
 * Main thread waits on other threads using latch object before proceeding its execution
 * this example shows how to use countdown latch
 * */

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {

	public static void main(String[] args) {
		
		final CountDownLatch latch=new CountDownLatch(3);
		
		new Thread(()->{
			System.out.println("first thread running..");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			latch.countDown();
		}).start();
		new Thread(()->{
			System.out.println("2nd thread running..");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			latch.countDown();
		}).start();
		new Thread(()->{
			System.out.println("3rd thread running..");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			latch.countDown();
		}).start();
		try {			
			latch.await();
			
		} catch (InterruptedException e) {
		}
		System.out.println("done with waiting now running..");
	}

}

class CountDownThread{
	
	CountDownThread(String name){
		
	}
}