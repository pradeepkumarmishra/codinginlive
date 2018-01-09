/*@Author:Pradeep mishra
 * 
 * this example shows how a thread can be interrupted by another thread while sleeping
 * 
 * 
 * */
public class SleepAndInterrupt {

	public static void main(String[] args) {

		Thread t = new Thread(() -> {
			long startTime=System.currentTimeMillis();
			while (true) {
				//System.out.println("Hey i will intrupt main thread after 2 seconds");
				long stopTime=System.currentTimeMillis();
				if(stopTime-startTime>2000){
					Thread.currentThread().interrupt();
					System.out.println("Main thread intruped...");
					break;
				}

			}
		});

		t.start();
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Thread is going to sleep");
				Thread.sleep(10000);//this thread sleeps for 10 seconds				
				System.out.println("Thread wake up");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
